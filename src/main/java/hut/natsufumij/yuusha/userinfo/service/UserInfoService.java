package hut.natsufumij.yuusha.userinfo.service;

import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMRegister;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoVSimple;

import java.util.List;

/**
 * 用户服务类,管理用户的操作
 */
public interface UserInfoService {

    /**
     * 根据id、ids、用户名、用户昵称来查找用户
     * @param query
     * @return
     */
    List<UserInfoVSimple> queryUser(UserMQuery query);

    /**
     * 注册一名用户，注意，用户名、手机号、邮箱必须不唯一
     * @param register
     */
    void RegisterUser(UserMRegister register);

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
