package cn.edu.dgut.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 小房子
 * @Package cn.edu.dgut.util
 * @date 2020/8/11 12:36
 */

/**
 * 字符串时间格式转Date日期格式
 */
public class StrDateConveter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
