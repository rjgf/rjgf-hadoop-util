package com.rjgf.hadoop.config;

import java.lang.annotation.*;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/12
 * @time: 16:03
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface HadoopMapper {
}
