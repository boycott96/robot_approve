package ink.lch.pojo.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;

    private String domain;

    private String email;

    private String password;

    private Date createTime;

    private Date updateTime;

    public User() {
    }

    public User(String id, String domain, String email, String password, Date createTime, Date updateTime) {
        this.id = id;
        this.domain = domain;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
