package hut.natsufumij.yuusha.social.param.bo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SocialMRegister {
    @NotBlank
    @Length(max = 30)
    private String name;
    @NotNull
    private Long manageId;
    @NotBlank
    @Length(max = 255)
    private String moto;
}
