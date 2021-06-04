package ink.lch.pojo.link;

import lombok.Data;

import java.util.Date;

@Data
public class Link {

    private String id;

    private String url;

    private Date createDate;

    private String createUser;

    private byte[] ico;

    public Link() {
    }

    public Link(String id, String url, Date createDate, String createUser) {
        this.id = id;
        this.url = url;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Link(String id, String url, Date createDate, String createUser, byte[] ico) {
        this.id = id;
        this.url = url;
        this.createDate = createDate;
        this.createUser = createUser;
        this.ico = ico;
    }
}
