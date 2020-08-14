package cn.edu.dgut.service.impl;

import cn.edu.dgut.dao.UserMapper;
import cn.edu.dgut.pojo.User;
import cn.edu.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小房子
 * @Package cn.edu.dgut.service.impl
 * @date 2020/8/12 19:03
 */
@Service
public class UserServiceImpl implements UserService {
    // 注入UserMapper
    @Autowired
    private UserMapper userMapper;

    // 根据用户名和密码查询用户
    @Override
    public User findUserByNameAndPwd(String username, String password) {
        List<User> users = userMapper.selectByNameAndPwd(username, password);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
