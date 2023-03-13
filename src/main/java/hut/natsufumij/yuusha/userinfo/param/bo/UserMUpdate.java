package hut.natsufumij.yuusha.userinfo.param.bo;

import hut.natsufumij.yuusha.userinfo.enums.UserSex;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserMUpdate {
    @NotNull
    private Long id;
    @NotBlank
    @Length(max = 30)
    private String nickName;
    @NotNull
    private UserSex sex;
    @NotBlank
    private Date birthday;
    @NotBlank
    @Length(max = 255)
    private String moto;
    @NotBlank
    @Length(max = 255)
    private String address;
    @Length(max = 30)
    private String phone;
    @NotBlank
    @Length(max = 30)
    @Email
    private String email;
    @NotBlank
    @Length(max = 255)
    private String avatar;
}
