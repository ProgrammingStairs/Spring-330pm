package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class AspectClass {
	
	@Pointcut("execution(* com.spring.service.*.*(..))")
	public void service() {}
	
	@Before("service()")
	public void runsBefore() {
		System.out.println("Runs Before");
	}

	@After("service()")
	public void runsAfter() {
		System.out.println("Runs After");
	}
	
	@AfterReturning("service()")
	public void runsAfterReturning() {
		System.out.println("Runs after returning");
	}

	@AfterThrowing("service()")
	public void runsAfterThrowing() {
		System.out.println("Runs after throwing");
	}

	@Around("service()")
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Before Proceeding");
			pjp.proceed();
		System.out.println("After Proceeding");
	}
	
}
/*
 as we do not write @around then my @before executes first but when i write @around then why control goes into around first and then on @before annotation ?
Great observation, Gaurav — this is exactly how Spring AOP’s advice chain works internally. Let’s unpack why @Around advice gets control before @Before advice.

🔎 Why @Around Runs First
Spring AOP is implemented using dynamic proxies (JDK proxies or CGLIB).

When a method in your target (com.spring.service.*) is called, the proxy intercepts it.

The proxy builds a chain of interceptors (each advice is wrapped as a MethodInterceptor).

The outermost interceptor is @Around.

That’s because @Around is the only advice type that can control whether the method executes at all (via pjp.proceed()).

So Spring must give it the first chance to run.

⚙️ Execution Order
Think of it like nested function calls:

text
Proxy intercepts call
   -> @Around (outer wrapper)
       -> @Before
          -> target method
       -> @AfterReturning / @AfterThrowing
       -> @After
   -> @Around (after proceed)
So:

Without @Around: the chain starts directly with @Before.

With @Around: the chain starts with @Around, which then invokes the rest of the chain by calling pjp.proceed().

🧠 Analogy
Imagine you’re entering a building:

@Around is the security guard at the gate — you can’t even reach the lobby unless he lets you in.

@Before is the receptionist inside — she greets you before you meet the actual person (the target method).

@AfterReturning / @AfterThrowing are like exit interviews — depending on whether your meeting went well or badly.

@After is the final door check — always happens when you leave.

@Around (after) is the guard again, noting you’ve left.

✅ Key Point
@Around advice is designed to wrap everything else. That’s why it executes first — it’s the outermost layer of the proxy chain. If you don’t define @Around, Spring just builds the chain starting with @Before.
 */





