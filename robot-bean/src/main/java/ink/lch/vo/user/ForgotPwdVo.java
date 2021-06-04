package ink.lch.vo.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NotNull
public class ForgotPwdVo {
    @NotEmpty
    private String email;

    private String code;

    @NotEmpty
    private String password;
}
