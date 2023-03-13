package natsufumij.yuusha.userinfo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hut.natsufumij.common.bean.Beans;
import hut.natsufumij.yuusha.userinfo.entity.YUserInfo;
import hut.natsufumij.yuusha.userinfo.enums.UserState;
import hut.natsufumij.yuusha.userinfo.mapper.TUserInfoMapper;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMPush;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserV;
import hut.natsufumij.yuusha.userinfo.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, YUserInfo> implements UserInfoService {

    @Override
    public void pushUser(UserMPush push) {
        YUserInfo info = Beans.convert(push, YUserInfo::new);
        info.setUserState(UserState.NORMAL);
        baseMapper.insert(info);
    }

    @Override
    public IPage<UserV> queryUser(UserMQuery query) {
        query.startPage();
        return baseMapper.queryUser(Page.of(query.getPageNum(), query.getPageSize()), query);
    }

    @Override
    public UserInfoSelfV getDetail(Long userId) {
        YUserInfo info = baseMapper.selectById(userId);
        return info == null ? null : Beans.convert(info, UserInfoSelfV::new);
    }

    @Override
    public void editUserInfo(UserMUpdate userMUpdate) {
        YUserInfo info=Beans.convert(userMUpdate, YUserInfo::new);
        updateById(info);
    }
}
