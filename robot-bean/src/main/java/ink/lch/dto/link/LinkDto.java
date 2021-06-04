package ink.lch.dto.link;

import ink.lch.pojo.link.Link;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LinkDto extends Link {

    private int favorite;

    private String name;

    private String icon;
}
