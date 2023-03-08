package hut.natsufumij.yuusha.social.param.vo;

import lombok.Data;

@Data
public class SocialSimpleV {
    private Long id;

    private String name;

    private Long manageId;

    private String moto;
    private Byte socialState;

    private String avatar;
}
