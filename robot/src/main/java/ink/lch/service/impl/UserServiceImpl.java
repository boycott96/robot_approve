package ink.lch.service.impl;

import ink.lch.api.LarkApi;
import ink.lch.common.CodeEnum;
import ink.lch.common.ResultBody;
import ink.lch.dao.UserMapper;
import ink.lch.pojo.User;
import ink.lch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final LarkApi larkApi;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, LarkApi larkApi) {
        this.userMapper = userMapper;
        this.larkApi = larkApi;
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
        ResultBody resultBody = larkApi.deleteUser(id);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int i = userMapper.deleteByPrimaryKey(id);
            if (i > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
    }

    @Override
    public ResultBody editUser(User user) {
        if (StringUtils.isEmpty(user.getUserId())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        ResultBody resultBody = larkApi.updateUser(user);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int i = userMapper.updateByPrimaryKey(user);
            if (i > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
    }

    @Override
    public ResultBody addUser(User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return ResultBody.error(CodeEnum.NOT_EMPTY);
        }
        if (StringUtils.isEmpty(user.getUserId())) {
            user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        }
        ResultBody resultBody = larkApi.createUser(user);
        if (resultBody.getCode().equals(CodeEnum.SUCCESS.getResultCode())) {
            int i = userMapper.insert(user);
            if (i > 0) {
                return ResultBody.success();
            } else {
                return ResultBody.error(CodeEnum.SQL_ERROR);
            }
        }
        return resultBody;
    }
}
