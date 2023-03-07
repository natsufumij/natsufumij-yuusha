package hut.natsufumij.yuusha.social.service;

import hut.natsufumij.yuusha.social.param.bo.SocialMQuery;
import hut.natsufumij.yuusha.social.param.bo.SocialMRegister;
import hut.natsufumij.yuusha.social.param.vo.SocialSimpleV;

import java.util.List;

/**
 * 社团服务接口
 */
public interface SocialService {

    /**
     * 注册一个社团
     * @param register
     */
    void RegisterSocial(SocialMRegister register);

    /**
     * 查询社团
     * @param query
     * @return
     */
    List<SocialSimpleV> querySocial(SocialMQuery query);
}
