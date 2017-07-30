package com.jason.safe_service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记在方法的参数上
 * 用于为“参数为null的”方法创建对象，创建方式使用反射调用无参构造函数。
 * @author Administrator
 *
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NullCreate {

}
