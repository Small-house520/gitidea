package cn.edu.dgut.util;

/**
 * @author 小房子
 * @Package cn.edu.dgut.util
 * @date 2020/8/12 16:38
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 */
public class UserHandlerInterceptor implements HandlerInterceptor {
    /**
     * controller执行前调用此方法
     * 返回true表示继续执行，返回false中止执行
     * 这里可以加入登录校验、权限拦截等
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("login")) {
            return true;
        }
        if (httpServletRequest.getSession().getAttribute("user") != null) {
            return true;
        }
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest,
                httpServletResponse);
        return false;
    }

    /**
     * controller执行后但未返回视图前调用此方法
     * 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * controller执行后且视图返回后调用此方法
     * 这里可得到执行controller时的异常信息
     * 这里可记录操作日志，资源清理等
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
