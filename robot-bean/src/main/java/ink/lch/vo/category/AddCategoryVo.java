package ink.lch.vo.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NotNull
@Data
public class AddCategoryVo {

    @NotEmpty(message = "当前未登录")
    private String userId;

    @NotEmpty(message = "分类名不能为空")
    private String name;
}
