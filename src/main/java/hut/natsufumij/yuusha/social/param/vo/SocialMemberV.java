package hut.natsufumij.yuusha.social.param.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SocialMemberV {
    private Long id;
    private Long userId;
    private String nickName;
    private Byte role;
    private String shogo;
    private String info;
    private Date registerTime;
    private Byte memeberState;
}
