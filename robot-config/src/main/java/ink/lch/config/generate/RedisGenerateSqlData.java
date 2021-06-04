package ink.lch.config.generate;

import ink.lch.config.util.Tools;
import ink.lch.pojo.user.User;
import ink.lch.redis.common.RedisEnum;
import ink.lch.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

@Component
@Slf4j
public class RedisGenerateSqlData implements InitializingBean, ServletContextAware {

    private final RedisUtil redisUtil;
    private final UserMapper userMapper;

    @Autowired
    public RedisGenerateSqlData(RedisUtil redisUtil, UserMapper userMapper) {
        this.redisUtil = redisUtil;
        this.userMapper = userMapper;
    }

    private void setRedisWithUser() {
        log.info("开始转载数据库中的用户数据到 REDIS缓存");
        // 获取已经注册完成的所有数据
        List<User> users = userMapper.selectAll();

        users.forEach(item -> {
            try {
                redisUtil.hmset(item.getDomain(), Tools.objectToMap(item));
                redisUtil.sSet(RedisEnum.MYSQL_NAME.getName(), item.getDomain());
                redisUtil.sSet(RedisEnum.MYSQL_EMAIL.getName(), item.getEmail());
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        });
        log.info("用户数据转载完成");
    }

    @Override
    public void afterPropertiesSet() {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
//        this.setRedisWithUser();
    }
}
