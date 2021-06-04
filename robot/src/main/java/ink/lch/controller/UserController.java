package ink.lch.controller;

import ink.lch.common.ResultBody;
import ink.lch.pojo.User;
import ink.lch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResultBody addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping()
    public ResultBody editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @DeleteMapping()
    public ResultBody deleteUser(String id) {
        return userService.deleteUser(id);
    }

    @GetMapping()
    public ResultBody searchByDeptId(String id) {
        return userService.searchByDeptId(id);
    }
}
