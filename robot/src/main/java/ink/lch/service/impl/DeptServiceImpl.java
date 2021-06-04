package ink.lch.service.impl;

import ink.lch.common.CodeEnum;
import ink.lch.common.ResultBody;
import ink.lch.config.util.TreeUtils;
import ink.lch.dao.DeptMapper;
import ink.lch.dto.DeptDto;
import ink.lch.pojo.Dept;
import ink.lch.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public ResultBody addDept(Dept dept) {
        if (StringUtils.isEmpty(dept.getName())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        if (StringUtils.isEmpty(dept.getDepartmentId())) {
            dept.setDepartmentId(UUID.randomUUID().toString().replace("-", ""));
        }
        int insert = deptMapper.insert(dept);
        if (insert > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }

    @Override
    public ResultBody editDept(Dept dept) {

        if (StringUtils.isEmpty(dept.getDepartmentId())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        int edit = deptMapper.updateByPrimaryKey(dept);
        if (edit > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }

    @Override
    public ResultBody deleteDept(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        int delete = deptMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }

    @Override
    public ResultBody search() {
        List<DeptDto> deptList = deptMapper.selectDepartments();
        List<DeptDto> depts = TreeUtils.buildTree(deptList, "departmentId", "parentDepartmentId", "children");
        ResultBody result = ResultBody.success();
        result.setResult(depts);
        return result;
    }
}
