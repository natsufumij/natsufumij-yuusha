package hut.natsufumij.yuusha.social.service;

import hut.natsufumij.yuusha.social.param.bo.SocialMemberMQuery;
import hut.natsufumij.yuusha.social.param.vo.SocialMemberV;

import java.util.List;

/**
 * 社团成员服务类
 */
public interface SocialMemberService {

    /**
     * 查询社团成员
     * @param query
     * @return
     */
    List<SocialMemberV> querySocialMember(SocialMemberMQuery query);
}
