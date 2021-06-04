package ink.lch.service;

import ink.lch.common.ResultBody;
import ink.lch.pojo.User;

public interface UserService {
    ResultBody searchByDeptId(String id);

    ResultBody deleteUser(String id);

    ResultBody editUser(User user);

    ResultBody addUser(User user);
}
