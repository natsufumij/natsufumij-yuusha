package hut.natsufumij.yuusha;

import hut.natsufumij.common.EnableTools;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hut.natsufumij.yuusha.**.mapper")
@EnableTools
public class YuushaMain {
    public static void main(String[] args) {
        SpringApplication.run(YuushaMain.class,args);
    }
}
