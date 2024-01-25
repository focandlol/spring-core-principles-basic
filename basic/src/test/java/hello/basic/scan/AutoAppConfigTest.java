package hello.basic.scan;

import hello.basic.AutoAppConfig;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.order.OrderService;
import hello.basic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);


        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
