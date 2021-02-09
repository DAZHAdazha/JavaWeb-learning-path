package cn.itcast.annotation;

import java.lang.annotation.*;

/**
 * 元注解：用于描述注解的注解
 * @Target
 * @Retention
 * @Documented
 * @Inherited
 */

//@Target(value={ElementType.TYPE})//TYPE表示该MyAnno3注解只能作用于类上(方法METHOD，成员FIELD变量不能加）
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//数组可以添加多个值
@Retention(value = RetentionPolicy.RUNTIME)//通常自定义会使用RUNTIME当前被描述的注解会保留到Class字节码中并被JVM读取，还有SOURCE,CLASS两个值
@Documented
@Inherited
public @interface MyAnno3 {

}
