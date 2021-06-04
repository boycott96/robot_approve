package ink.lch.pojo.category;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryUser {

    private String categoryId;

    private String userId;

    private Date createDate;

    public CategoryUser() {
    }

    public CategoryUser(String categoryId, String userId, Date createDate) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.createDate = createDate;
    }
}
