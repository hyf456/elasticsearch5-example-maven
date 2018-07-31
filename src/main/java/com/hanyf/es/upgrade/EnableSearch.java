package com.hanyf.es.upgrade;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hanyf on 2018/1/19 17:10.
 * 导入SearchConfig   Bean连接es
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({SearchConfig.class})
public @interface EnableSearch {
}
