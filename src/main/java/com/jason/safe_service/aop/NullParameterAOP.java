package com.jason.safe_service.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jason.safe_service.annotation.NullCreate;
import com.jason.safe_service.annotation.NullRefuse;
import com.jason.safe_service.bean.ArgumentAndParameter;
import com.jason.safe_service.exception.NullParameterRefuseException;


@Aspect			//去掉这两个注解，让使用者在XML中定义bean即可。
@Component		//去掉这两个注解，让使用者在XML中定义bean即可。
public class NullParameterAOP{
	
	
	/**
	 * 持有SafeMethod注解的方法才生效
	 * 方法签名中参数：
	 * 		有标记NullCreate则为null传入创建新对象
	 * 		有标记NullRefuse则为null传入抛出异常
	 * 这些注解使用可以自行扩展
	 */
	@Around("execution(@com.jason.safe_service.annotation.SafeMethod * *(..,@("
			+ "com.jason.safe_service.annotation.NullCreate"
			+ " || com.jason.safe_service.annotation.NullRefuse"
			+ ") (*),..))")
	public Object serviceAOP(ProceedingJoinPoint pjp) throws Throwable {
		
		//打包在一起
		List<ArgumentAndParameter> aaps = wrapArgsAndAnnos(pjp);
		
		//安全性处理
		for (ArgumentAndParameter aap : aaps) {
			
			NullRefuse nullRefuse = aap.getParameter().getAnnotation(NullRefuse.class);
			if (Objects.nonNull(nullRefuse)) {
				throw new NullParameterRefuseException();
			}
			
			NullCreate nullCreate = aap.getParameter().getAnnotation(NullCreate.class);
			if (Objects.nonNull(nullCreate)) {
				Object newArgument = aap.getParameter().getType().newInstance();
				aap.setArgument(newArgument);
				continue;
			}
		}
		
		//取出args对象数组作为参数
		List<Object> arguments = new ArrayList<>();
		
		for (ArgumentAndParameter aap : aaps) {
			arguments.add(aap.getArgument());
		}
			
		
		//方法正常执行
		Object result = null;
		
		try {
			result = pjp.proceed(arguments.toArray());
		} catch (Throwable e) {
			throw e;
		}
		
		return result;
	}


	/**
	 * 为了方便，把签名中的参数定义、具体的传入参数打包在一起。
	 * @param pjp
	 * @return
	 */
	private List<ArgumentAndParameter> wrapArgsAndAnnos(ProceedingJoinPoint pjp) {
		List<ArgumentAndParameter> aaas = new ArrayList<>();
		
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature)signature;
		Method method = methodSignature.getMethod();
		Parameter[] parameters = method.getParameters();
		Object[] args = pjp.getArgs();
		
		for (int i = 0; i < parameters.length; i++) {
			aaas.add(new ArgumentAndParameter(parameters[i],args[i]));
		}
		return aaas;
	}
	

	
}
