package cn.edu.dgut.util;

/**
 * @author 小房子
 * @Package cn.edu.dgut.util
 * @date 2020/8/12 15:29
 */

/**
 * 自定义异常类
 */
public class MyException extends Exception {
    private String msg; // 异常信息

    public MyException() {
    }

    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
