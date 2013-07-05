package com.camilolopes.readerweb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLog {
	@Pointcut("execution(* *.*br.com.camilolopes.readerweb.dao.impl.UserDAOImpl.save*(..)")
	public void log(){
		System.out.println("Teste log AOP");
		
	}
}
