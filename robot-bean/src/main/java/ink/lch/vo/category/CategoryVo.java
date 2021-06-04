package ink.lch.vo.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NotNull
public class CategoryVo {

    private String id;

    @NotEmpty(message = "当前登录用户为空")
    private String userId;

    @NotEmpty(message = "分类名不能为空")
    private String name;
}
