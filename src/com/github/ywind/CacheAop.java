package com.github.ywind;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
// for aop
@Component
// for auto scan
@Order(0)
// execute before @Transactional
public class CacheAop {
	static int MaxLengthForLRU = 100;
	private static Map<String, LRUListHashMap<Integer,Cache<Object>>> hashmap = new HashMap<String, LRUListHashMap<Integer,Cache<Object>>>();
	// @Around("execution(* Test.*(..))")

	@SuppressWarnings("unchecked")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("do cache");
		Object result = null;
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		if (method.getAnnotation(GetCache.class) != null) {
			Object[] values = pjp.getArgs();
			Integer integer = Integer.valueOf(values[0].toString());
			if (hashmap
					.containsKey(method.getAnnotation(GetCache.class).type())) {
				LRUListHashMap<Integer, Cache<Object>> lru = hashmap.get(method
						.getAnnotation(GetCache.class).type());

				if (lru.containsKey(integer)
						&& lru.get(integer).getTime() + 5000 < System
								.currentTimeMillis()) {
					result = lru.get(integer).getT();
					System.out.println("cache");
				} else {
					try {
						System.out.println("no cache");
						result = pjp.proceed();
						lru.put(integer, new Cache<Object>(
								(List<Object>) result));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			} else {
				
				LRUListHashMap<Integer, Cache<Object>> lru = new LRUListHashMap<Integer, Cache<Object>>(
						MaxLengthForLRU);
				System.out.println("first cache");
				try {
					result = pjp.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lru.put(integer, new Cache<Object>((List<Object>) result));
				hashmap.put(method.getAnnotation(GetCache.class).type(), lru);
			}
		} else {
			try {
				result = pjp.proceed();
				System.out.println("no annotation");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
