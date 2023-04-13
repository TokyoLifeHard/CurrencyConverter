package com.currencyconverter.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValutesControllerLoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(public * caclCurse(*))")
    public void beforeCalcValutes(){
        logger.info("exec calcCurse metod");
    }
}
