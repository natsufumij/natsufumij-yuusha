package natsufumij.yuusha.userinfo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import hut.natsufumij.yuusha.userinfo.entity.YUserInfo;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMPush;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserV;

public interface UserInfoService extends IService<YUserInfo> {

    void pushUser(UserMPush push);

    IPage<UserV> queryUser(UserMQuery query);


    /**
     * 获取一个用户详细信息
     * @param userId
     * @return
     */
    UserInfoSelfV getDetail(Long userId);

    /**
     * 用户修改个人信息
     * @param userMUpdate
     */
    void editUserInfo(UserMUpdate userMUpdate);
}
