package ink.lch.vo.user;

import lombok.Data;

@Data
public class ActiveVo {

    private String email;

    private String firstToken;

    private String secondToken;
}
