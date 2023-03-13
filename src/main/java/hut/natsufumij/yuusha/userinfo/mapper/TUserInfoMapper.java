package hut.natsufumij.yuusha.userinfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hut.natsufumij.yuusha.userinfo.entity.YUserInfo;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.vo.UserV;
import org.apache.ibatis.annotations.Select;

public interface TUserInfoMapper extends BaseMapper<YUserInfo> {

    @Select("""
        <script>
        select id,user_name userName,nick_name nickName,sex,avatar
        from y_user_info
        <where>
            <if test="query.id!=null">
                id=#{query.id}
            </if>
            <if test="query.id==null">
                <if test="query.ids!=null and !query.ids.isEmpty()">
                    id in
                    <foreach collection="query.ids" open="(" close=")" item="item" separator=",">
                        #{item}
                    </foreach>
                </if>
                <if test="query.userName!=null and query.userName!=''">
                    user_name like concat(#{query.userName},'%')
                </if>
                <if test="query.nickName!=null and query.nickName!=''">
                    nick_name like concat(#{query.nickName},'%')
                </if>
            </if>
        </where>
    </script>
    """)
    IPage<UserV> queryUser(Page<UserV> page, UserMQuery query);
}
