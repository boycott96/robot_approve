package ink.lch.vo.category;

import lombok.Data;

@Data
public class CategoryDomainVo {

    /**
     * 绑定域名
     */
    private String domain;

    /**
     * 进行分类名称的排序
     */
    private String order;

    /**
     * 进行模糊搜索分类
     */
    private String name;
}
