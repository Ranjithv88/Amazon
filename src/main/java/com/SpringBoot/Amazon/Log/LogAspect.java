package com.SpringBoot.Amazon.Log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractEmail(..))")
    public void logExtractEmail () {
        log.info(" ExtractEmail SuccessFully ....! ");
    }

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.key(..))")
    public void logKey () {
        log.info(" Key Generate SuccessFully ....! ");
    }
    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractClaims(..))")
    public void logExtractClaims () {
        log.info(" ExtractClaims SuccessFully ....! ");
    }

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractRole(..))")
    public void logExtractRole () {
        log.info(" ExtractRole SuccessFully ....! ");
    }

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractRole(..))")
    public void logExtractRole () {
        log.info(" ExtractRole SuccessFully ....! ");
    }

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractRole(..))")
    public void logExtractRole () {
        log.info(" ExtractRole SuccessFully ....! ");
    }

    @After("execution(* com.SpringBoot.Amazon.Security.JwtUtils.extractRole(..))")
    public void logExtractRole () {
        log.info(" ExtractRole SuccessFully ....! ");
    }

}

