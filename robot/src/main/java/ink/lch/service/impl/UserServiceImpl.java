package ink.lch.service.impl;

import ink.lch.common.CodeEnum;
import ink.lch.common.ResultBody;
import ink.lch.dao.UserMapper;
import ink.lch.pojo.User;
import ink.lch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ResultBody searchByDeptId(String id) {
        ResultBody result = ResultBody.success();
        result.setResult(userMapper.searchByDeptId(id));
        return result;
    }

    @Override
    public ResultBody deleteUser(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        int i = userMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }

    @Override
    public ResultBody editUser(User user) {
        if (StringUtils.isEmpty(user.getUserId())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        int i = userMapper.updateByPrimaryKey(user);
        if (i > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }

    @Override
    public ResultBody addUser(User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        int i = userMapper.insert(user);
        if (i > 0) {
            return ResultBody.success();
        }
        return ResultBody.error(CodeEnum.SQL_ERROR);
    }
}
