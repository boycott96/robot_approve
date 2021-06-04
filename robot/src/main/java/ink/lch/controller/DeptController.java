package ink.lch.controller;

import ink.lch.common.ResultBody;
import ink.lch.pojo.Dept;
import ink.lch.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/dept")
@RestController
public class DeptController {

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping()
    public ResultBody addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @PutMapping()
    public ResultBody editDept(@RequestBody Dept dept) {
        return deptService.editDept(dept);
    }

    @DeleteMapping()
    public ResultBody deleteDept(String id) {
        return deptService.deleteDept(id);
    }

    @GetMapping()
    public ResultBody search() {
        return deptService.search();
    }
}
