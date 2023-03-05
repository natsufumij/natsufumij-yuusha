package hut.natsufumij;

import hut.natsufumij.util.EnableTools;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hut.natsufumij.**.dao")
@EnableTools
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}