package jeevankumar.com.controller;

import jeevankumar.com.service.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/v1/api/circuit")
public class CircuitBreakerController {
    private final SampleService sampleService;

    public CircuitBreakerController(SampleService sampleService) {
        this.sampleService = sampleService;
    }
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<String> callExternalService(){
        return sampleService.callExternalService();
    }
}
