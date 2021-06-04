package ink.lch.pojo.link;

import lombok.Data;

import java.util.Date;

@Data
public class LinkUser {

    private String linkId;

    private String userId;

    private Date createDate;

    private String name;

    public LinkUser() {
    }

    public LinkUser(String linkId, String userId, Date createDate, String name) {
        this.linkId = linkId;
        this.userId = userId;
        this.createDate = createDate;
        this.name = name;
    }
}
