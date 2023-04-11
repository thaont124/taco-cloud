package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "tacos.data")
@EntityScan("tacos")
public class TacosCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacosCloudApplication.class, args);
    }


}
