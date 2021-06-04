package ink.lch.vo.category;

import ink.lch.vo.link.LinkVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryLinkVo extends LinkVo {

    private String categoryId;

    private String ids;
}
