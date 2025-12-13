package com.devicedatadisplayplatform.common.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Author UESAKAYUUICHI
 * Message 转换工具类
 * Time 2025/12/10
 */
public class ConvertUtil {
    /**
     * 将源对象转换为目标对象
     * @param source 源对象
     * @param targetClass 目标类
     * @param <T> 源对象类型
     * @param <R> 目标对象类型
     * @return 转换后的目标对象
     */
    public static <T, R> R convert(T source, Class<R> targetClass) {
        if (source == null) {
            return null;
        }

        try {
            R target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("对象转换失败", e);
        }
    }
    
    /**
     * 将源对象转换为目标对象，只复制目标对象中存在且类型匹配的字段
     * @param source 源对象
     * @param targetClass 目标类
     * @param <T> 源对象类型
     * @param <R> 目标对象类型
     * @return 转换后的目标对象
     */
    public static <T, R> R convertIgnoreExtraFields(T source, Class<R> targetClass) {
        if (source == null) {
            return null;
        }

        try {
            R target = targetClass.getDeclaredConstructor().newInstance();
            // 使用BeanUtils的标准方法，它会自动忽略目标类中不存在的属性
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("对象转换失败", e);
        }
    }
}