package natsufumij.yuusha.userinfo.controller;

import hut.natsufumij.common.resp.V;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMPush;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMQuery;
import hut.natsufumij.yuusha.userinfo.param.bo.UserMUpdate;
import hut.natsufumij.yuusha.userinfo.param.vo.UserInfoSelfV;
import hut.natsufumij.yuusha.userinfo.param.vo.UserV;
import hut.natsufumij.yuusha.userinfo.service.UserInfoService;
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

    @GetMapping
    public V<UserV> page(@Valid UserMQuery query){
        return V.yes(userInfoService.queryUser(query));
    }

    @GetMapping("/{id}")
    public V<UserInfoSelfV> getOne(@PathVariable("id") Long id){
        return V.yes(userInfoService.getDetail(id));
    }
    @PostMapping
    public V<Void> push(@RequestBody @Valid UserMPush query){
        userInfoService.pushUser(query);
        return V.yes();
    }

    @PutMapping
    public V<Void> update(@RequestBody @Valid UserMUpdate up){
        userInfoService.editUserInfo(up);
        return V.yes();
    }
}
