package com.cskaoyan.work;

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class ReflectionUtils {

    private static final String PREFIX = "set";

    /**
     * 将第二个参数map里面的值封装到第一个参数对象中
     * @param o
     * @param parameterMap
     */
    public static void toBean(Object o, Map<String, String[]> parameterMap) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> aClass = o.getClass();
        //入口是利用set方法来完成赋值
        //比如 属性username----> setUsername setPassword
        //username  password其实是和参数的key值相同的
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            String[] values = parameterMap.get(key);
            Field field = aClass.getDeclaredField(key);
            //其中第二个参数表示的是该方法传递的参数的类型，该类型和成员变量的类型是一致的
            Method method = aClass.getDeclaredMethod(PREFIX + StringUtils.capitalize(key), field.getType());
            //如果是String[]强转成Object
            String simpleName = field.getType().getSimpleName();

            if("String".equals(simpleName)){
                method.invoke(o, values[0]);
            }else if("String[]".equals(simpleName)){
                method.invoke(o, (Object) values);
            }else if("Integer".equals(simpleName)){
                method.invoke(o, Integer.parseInt(values[0]));
            }else {
                throw new IllegalArgumentException("暂不支持除了简单数据类型以外的数据封装");
            }

        }
    }
}
