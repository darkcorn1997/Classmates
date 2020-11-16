package corn.ironman.jay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("corn.ironman.jay.dao") //扫描Mapper接口
public class JayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JayApplication.class, args);
    }

}
