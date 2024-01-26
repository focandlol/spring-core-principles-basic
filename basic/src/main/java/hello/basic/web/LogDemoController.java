package hello.basic.web;

import hello.basic.common.MyLogger;
import jakarta.inject.Provider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
   // private final ObjectProvider<MyLogger> myLoggerProvider; // provider<T> 사용
    private final MyLogger myLogger;
    private int num;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        
        System.out.println("myLogger = " + myLogger.getClass());
        //System.out.println("myLogger = " + myLogger); //여기서 진짜 mylogger 만듬
        System.out.println("request = " + request);
        String requestURL = request.getRequestURL().toString();

        //MyLogger myLogger = myLoggerProvider.getObject();


        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        System.out.println("myLogger = " + myLogger.getClass());
        logDemoService.logic("testId");
        return "ok";
    }
}
