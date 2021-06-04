package ink.lch.dto;

import ink.lch.pojo.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DeptDto extends Dept {

    private List<DeptDto> children;
}
