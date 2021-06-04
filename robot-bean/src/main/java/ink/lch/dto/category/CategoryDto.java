package ink.lch.dto.category;

import ink.lch.dto.link.LinkDto;
import ink.lch.pojo.category.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class CategoryDto {

    private String categoryId;

    private String categoryName;

    private String categoryDetailName;

    private String categoryPublicity;

}
