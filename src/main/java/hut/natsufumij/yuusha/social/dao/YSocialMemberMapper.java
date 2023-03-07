package hut.natsufumij.yuusha.social.dao;

import hut.natsufumij.yuusha.social.entity.YSocialMember;

public interface YSocialMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YSocialMember record);

    int insertSelective(YSocialMember record);

    YSocialMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YSocialMember record);

    int updateByPrimaryKey(YSocialMember record);
}