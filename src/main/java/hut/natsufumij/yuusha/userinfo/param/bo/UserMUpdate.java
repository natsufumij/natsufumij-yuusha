package hut.natsufumij.yuusha.userinfo.param.bo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserMUpdate {
    @NotNull
    private Long id;
    private String nickName;
    private Byte sex;
    private Date birthday;
    private String moto;
    private String address;
    private String phone;
    @Email
    private String email;
    private String avatar;
}
