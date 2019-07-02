package com.hgh.spidernewcode.config;

import com.hgh.spidernewcode.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration          //证明这个类是一个配置文件
@EnableScheduling       //打开quartz定时器总开关
public class TimerConfiguration {



    @Scheduled(cron = "0 0 8 ? * *")
    public void timer(){
        new SpiderService().getLotsOfArticle("https://www.nowcoder.com/discuss");
    }

}
