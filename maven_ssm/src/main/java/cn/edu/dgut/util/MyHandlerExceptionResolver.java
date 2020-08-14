package cn.edu.dgut.util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小房子
 * @Package cn.edu.dgut.util
 * @date 2020/8/12 14:50
 */

/**
 * 全局异常类，异常处理器
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 定义一个ModelAndView
        ModelAndView view = new ModelAndView("error");
        // 异常信息
        String errorMsg = "出错了，，，";
        if (e instanceof MyException) {
            errorMsg = ((MyException) e).getMsg();
        }
        view.addObject("errorMsg", errorMsg);

        return view;
    }
}
