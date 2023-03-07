package hut.natsufumij.yuusha.social.service.impl;

import hut.natsufumij.yuusha.social.dao.YSocialInfoMapper;
import hut.natsufumij.yuusha.social.entity.YSocialInfo;
import hut.natsufumij.yuusha.social.param.bo.SocialMQuery;
import hut.natsufumij.yuusha.social.param.bo.SocialMRegister;
import hut.natsufumij.yuusha.social.param.vo.SocialSimpleV;
import hut.natsufumij.yuusha.social.service.SocialService;
import hut.natsufumij.yuusha.util.bean.Beans;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocialServiceImpl implements SocialService {

    private final YSocialInfoMapper socialInfoMapper;

    @Override
    public void RegisterSocial(SocialMRegister register) {
        YSocialInfo info= Beans.convert(register,YSocialInfo::new);
        socialInfoMapper.insertSelective(info);
    }

    @Override
    public List<SocialSimpleV> querySocial(SocialMQuery query) {
        return null;
    }
}
