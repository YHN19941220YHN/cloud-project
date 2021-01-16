package spring.cloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon的负载均衡机制,设置为随机
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/24 21:39
 * @company alibaba
 */
@Configuration
public class MyRibbon {
    @Bean
    public IRule myRule() {
        return new RandomRule(); // 定义为随机
    }
}
