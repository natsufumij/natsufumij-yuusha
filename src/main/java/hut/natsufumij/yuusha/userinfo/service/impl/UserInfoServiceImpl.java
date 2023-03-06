package hut.natsufumij.yuusha.userinfo.service.impl;

import hut.natsufumij.yuusha.userinfo.dao.YUserInfoMapper;
import hut.natsufumij.yuusha.userinfo.entity.YUserInfo;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMRegister;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoVSimple;
import hut.natsufumij.yuusha.userinfo.service.UserInfoService;
import hut.natsufumij.yuusha.util.bean.Beans;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务接口实现类
 */
@AllArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final YUserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoVSimple> queryUser(UserMQuery query) {
        query.startPage();
        return userInfoMapper.queryUserList(query);
    }

    @Override
    public void RegisterUser(UserMRegister register) {
        YUserInfo userInfo= Beans.convert(register,YUserInfo::new);
        userInfo.setUserState(0);
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfoSelfV getDetail(Long userId) {
        YUserInfo info = userInfoMapper.selectByPrimaryKey(userId);
        return Beans.convert(info,UserInfoSelfV::new);
    }

    @Override
    public void editUserInfo(UserMUpdate userMUpdate) {
        YUserInfo info=Beans.convert(userMUpdate,YUserInfo::new);
        userInfoMapper.updateByPrimaryKeySelective(info);
    }
}
