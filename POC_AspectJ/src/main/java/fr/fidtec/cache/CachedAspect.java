package fr.fidtec.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import fr.fidtec.service.Log;

@Aspect
public class CachedAspect {

	private static final Log log = new Log();
	
	// Attention aux goals compile et test-compile doublent les messages
	@Around("@annotation(fr.fidtec.cache.Cached)")
	public Object cacheResult(ProceedingJoinPoint joinPoint) throws Throwable {
	
		Cached cached = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Cached.class);
						
		log.info("Args Length : " + joinPoint.getArgs().length);
		
		log.info("Arg0 Type : " + ((MethodSignature) joinPoint.getSignature()).getParameterTypes()[0].getName());
		
		log.info("Arg0 Name : " + ((MethodSignature) joinPoint.getSignature()).getParameterNames()[0]);
		
		log.info("Arg0 value : " + joinPoint.getArgs()[0]);
		
		log.info("Nom Cache : " + cached.cacheName() + " annotée sur la méthode " + ((MethodSignature) joinPoint.getSignature()).getMethod().getName());
		
		Object proceed = (String) joinPoint.proceed() + " en majuscules !!!!";
		
		return proceed;
	
	}
}
