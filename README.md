# safe_service
【aop切入】安全性方法处理

### 使用举例
```
@SafeMethod
public void testAopCreate(String nice,Integer count, @NullCreate Task task,String... stringArray) {

	System.out.println(task.getPrice());
}
```

像上方这块代码这样，方法前标记@SafeMethod注解，参数上标记@NullCreate注解，就会自动启用AOP切入处理。

### 目前支持的参数注解有：
@NullCreate：如果传入参数对象为null，则自动调用默认构造函数为其创建bean类，防止代码内部空指针异常。（适用于POJO类，传入条件Bean类等等。）
@NullRefuse：如果传入参数对象为null，则抛出NullParameterRefuseException异常。
