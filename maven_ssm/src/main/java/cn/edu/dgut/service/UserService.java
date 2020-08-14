package cn.edu.dgut.service;

import cn.edu.dgut.pojo.User;

/**
 * @author 小房子
 * @Package cn.edu.dgut.service
 * @date 2020/8/12 19:01
 */
public interface UserService {
    // 根据用户名和密码查询用户
    User findUserByNameAndPwd(String username, String password);
}
