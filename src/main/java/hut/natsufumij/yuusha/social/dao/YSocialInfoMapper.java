package hut.natsufumij.yuusha.social.dao;

import hut.natsufumij.yuusha.social.entity.YSocialInfo;

public interface YSocialInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YSocialInfo record);

    int insertSelective(YSocialInfo record);

    YSocialInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YSocialInfo record);

    int updateByPrimaryKey(YSocialInfo record);
}