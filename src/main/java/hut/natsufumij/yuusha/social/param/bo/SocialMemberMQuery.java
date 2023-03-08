package hut.natsufumij.yuusha.social.param.bo;

import hut.natsufumij.yuusha.util.bean.QueryMBase;

public class SocialMemberMQuery extends QueryMBase {
    private Long socialId;
    private String name;

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
