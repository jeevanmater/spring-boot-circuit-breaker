package jeevankumar.com.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class SampleService {

    public static final String SAMPLE_SERVICE = "sampleService";


    @CircuitBreaker(name = SAMPLE_SERVICE, fallbackMethod = "fallbackResponse")
    @Retry(name = SAMPLE_SERVICE,fallbackMethod = "fallbackResponse")
    @TimeLimiter(name = SAMPLE_SERVICE,fallbackMethod = "fallbackResponse")
    @Async
    public CompletableFuture<String> callExternalService(){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(2);
            if (Math.random() > 0.5){
                throw new RuntimeException("external service failed....!!!");
            }
            return CompletableFuture.completedFuture("External call succeeded...");
        }catch (InterruptedException interruptedException){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Service interrupted....");
        }
        finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (endTime -startTime) + "ms");
        }


    }
    public CompletableFuture<String> fallbackResponse(Exception exception){
        return CompletableFuture.completedFuture("Fallback Response: " + exception.getMessage());
    }
}
