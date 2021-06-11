package ink.lch.service.impl;

import ink.lch.api.LarkApi;
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

import java.util.List;
import java.util.UUID;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;
    private final LarkApi larkApi;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper, LarkApi larkApi) {
        this.deptMapper = deptMapper;
        this.larkApi = larkApi;
    }

    @Override
    public ResultBody addDept(Dept dept) {
        if (StringUtils.isEmpty(dept.getName())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        if (StringUtils.isEmpty(dept.getParentDepartmentId())) {
            dept.setParentDepartmentId("0");
        }
        if (StringUtils.isEmpty(dept.getDepartmentId())) {
            dept.setDepartmentId(UUID.randomUUID().toString().replace("-", ""));
        }
        ResultBody resultBody = larkApi.createDept(dept);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int insert = deptMapper.insert(dept);
            if (insert > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
    }

    @Override
    public ResultBody editDept(Dept dept) {

        if (StringUtils.isEmpty(dept.getDepartmentId())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        ResultBody resultBody = larkApi.updateDept(dept);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int edit = deptMapper.updateByPrimaryKey(dept);
            if (edit > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
    }

    @Override
    public ResultBody deleteDept(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        ResultBody resultBody = larkApi.deleteDept(id);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int delete = deptMapper.deleteByPrimaryKey(id);
            if (delete > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
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
