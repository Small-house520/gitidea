package cn.edu.dgut.web;

import cn.edu.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 小房子
 * @Package cn.edu.dgut.web
 * @date 2020/8/12 17:16
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String toLogin() {
        // 跳转到登录页面
        return "login";
    }

    @RequestMapping("/login.action")
    public String loginCheck(HttpSession session, String username, String password) {
        if (username != null && password != null && !"".equals(username) && !"".equals(password)
                && userService.findUserByNameAndPwd(username, password) != null) {
            session.setAttribute("user", username);
            return "redirect:/product";
        }
        return "login";
    }
}
