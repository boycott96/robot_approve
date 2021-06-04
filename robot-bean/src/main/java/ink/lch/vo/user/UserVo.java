package ink.lch.vo.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NotNull
public class UserVo {

    @NotEmpty
    private String domain;

    private String email;

    private String code;

    @NotEmpty
    private String password;
}
