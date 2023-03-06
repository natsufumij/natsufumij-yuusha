package hut.natsufumij.yuusha.userinfo.dao;

import hut.natsufumij.yuusha.userinfo.entity.YUserInfo;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoVSimple;

import java.util.List;

public interface YUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YUserInfo record);

    int insertSelective(YUserInfo record);

    List<UserInfoVSimple> queryUserList(UserMQuery query);

    YUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YUserInfo record);

    int updateByPrimaryKey(YUserInfo record);
}