package hut.natsufumij.yuusha.social.controller;


import hut.natsufumij.yuusha.social.param.bo.SocialMQuery;
import hut.natsufumij.yuusha.social.param.bo.SocialMRegister;
import hut.natsufumij.yuusha.social.param.bo.SocialMUpdate;
import hut.natsufumij.yuusha.social.param.vo.SocialSimpleV;
import hut.natsufumij.yuusha.social.service.SocialService;
import hut.natsufumij.yuusha.util.resp.RV;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/socialInfo")
@Validated
@AllArgsConstructor
public class SocialInfoController {

    private final SocialService socialService;

    /**
     * 注册一个社团
     * @param register
     */
    @PostMapping
    public RV<Void> RegisterSocial(@Valid @RequestBody SocialMRegister register){
        socialService.RegisterSocial(register);
        return RV.of();
    }

    /**
     * 查询社团
     * @param query
     * @return
     */
    @GetMapping
    public RV<SocialSimpleV> querySocial(@Valid SocialMQuery query){
        return RV.of(socialService.querySocial(query));
    }

    @PutMapping
    public RV<Void> updateSocial(@Valid @RequestBody SocialMUpdate update){
        socialService.updateSocial(update);
        return RV.of();
    }
}
