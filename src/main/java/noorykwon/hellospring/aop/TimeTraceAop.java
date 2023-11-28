package noorykwon.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    /*
    AOP(Aspect Oriented Programming) 관점지향 프로그래밍
    : 모든 매서드에 실행되는 로직을 별도로 관리할 수 있음
     */

    @Around("excecution(* noorykwon.hellospring..*(..))") // 공통사항을 타게팅하는 어노테이션.. 사용법 별도 실무에서 쓰던거만 쓰는 경향이 있으니 참고. 현재는 패키지 전체 적용
    public Object exceute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
