# safe_service
【aop切入】安全性方法处理

### 使用举例
```
@SafeMethod
public void testAopCreate(String nice,Integer count, @NullCreate Task task,String... stringArray) {

	System.out.println(task.getPrice());
}
```
