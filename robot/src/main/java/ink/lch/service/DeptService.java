package ink.lch.service;

import ink.lch.common.ResultBody;
import ink.lch.pojo.Dept;

public interface DeptService {

    ResultBody addDept(Dept dept);

    ResultBody editDept(Dept dept);

    ResultBody deleteDept(String id);

    ResultBody search();
}
