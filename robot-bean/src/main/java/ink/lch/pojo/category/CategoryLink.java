package ink.lch.pojo.category;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryLink {

    private String categoryId;

    private String linkId;

    private Date createDate;

    private String name;

    public CategoryLink() {
    }

    public CategoryLink(String categoryId, String linkId, Date createDate, String name) {
        this.categoryId = categoryId;
        this.linkId = linkId;
        this.createDate = createDate;
        this.name = name;
    }
}
