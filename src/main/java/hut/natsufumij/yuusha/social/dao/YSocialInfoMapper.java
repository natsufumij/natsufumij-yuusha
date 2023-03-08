package hut.natsufumij.yuusha.social.dao;

import hut.natsufumij.yuusha.social.entity.YSocialInfo;
import hut.natsufumij.yuusha.social.param.bo.SocialMQuery;
import hut.natsufumij.yuusha.social.param.vo.SocialSimpleV;

import java.util.List;

public interface YSocialInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YSocialInfo record);

    int insertSelective(YSocialInfo record);

    YSocialInfo selectByPrimaryKey(Long id);

    List<SocialSimpleV> querySocial(SocialMQuery query);

    int updateByPrimaryKeySelective(YSocialInfo record);

    int updateByPrimaryKey(YSocialInfo record);
}