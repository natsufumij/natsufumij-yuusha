package hut.natsufumij.yuusha.userinfo.param.vo;

import lombok.Data;

@Data
public class UserInfoVSimple {

    private Long id;
    private String userName;
    private Byte sex;
    private String nickName;
    private String avatar;
}
