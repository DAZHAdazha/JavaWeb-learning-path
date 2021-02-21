package cn.itcast.annotation;

//注解属性（抽象方法）需要赋值使用
//如果只有一个属性需要赋值，并且属性的名词为value，则value可以被省略，直接在括号里面赋值“@xxx(12)"
//数组赋值需要用大括号包裹，如果数组中只有一个值，则{}可以省略
@MyAnno3
@MyAnno(age = 12, name="Jon",per = Person.P1, anno2 = @MyAnno2, strs={"abc","bbb"})
public class Worker {

}
