package bacarotech.serie.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(fixedDelay = 5000)
    public void printSomething() {
        System.out.println("Print: " + new Date().getTime());
    }

    @Scheduled(cron = "0 0 2 * * *", zone = "Europe/Rome")
    public void printSomethingAt2AM() {
        System.out.println("Print: " + new Date());
    }
}
