package hut.natsufumij.yuusha.userinfo.controller;

import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMRegister;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoVSimple;
import hut.natsufumij.yuusha.userinfo.service.UserInfoService;
import hut.natsufumij.yuusha.util.resp.RV;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/userInfo")
@AllArgsConstructor
@Validated
public class UserInfoController {

    private final UserInfoService userInfoService;

    /**
     * 根据id、ids、用户名、用户昵称来查找用户
     * @param query
     * @return
     */
    @GetMapping
   public RV<UserInfoVSimple> queryUser(UserMQuery query){
        return RV.of(userInfoService.queryUser(query));
   }

    /**
     * 注册一名用户，注意，用户名、手机号、邮箱必须不唯一
     * @param register
     */
    @PostMapping
    public RV<Void> RegisterUser(@Valid @RequestBody UserMRegister register){
        userInfoService.RegisterUser(register);
        return RV.of();
    }

    /**
     * 获取一个用户相信信息
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    public RV<UserInfoSelfV> getDetail(@PathVariable("id") Long userId){
        return RV.of(userInfoService.getDetail(userId));
    }

    /**
     * 用户修改个人信息
     * @param userMUpdate
     */
    @PutMapping
    public RV<Void> editUserInfo(@Valid @RequestBody UserMUpdate userMUpdate){
        userInfoService.editUserInfo(userMUpdate);
        return RV.of();
    }
}
