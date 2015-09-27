package lifecycle;

import net.bull.javamelody.MonitoringSpringInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * Created by Administrator on 2015/9/26.
 */
class PerformanceMonitoringSpringInterceptor extends MonitoringSpringInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        final String requestName = getRequestName(invocation);
        StopWatch stopWatch = new StopWatch(requestName);
        stopWatch.start(requestName);
        try {
            Object obj = super.invoke(invocation);
            long endTimeMillis = System.currentTimeMillis();
            System.out.println("how much time is " + (endTimeMillis - startTimeMillis));
            return obj;
        } finally {

            stopWatch.stop();

        }
    }


}
