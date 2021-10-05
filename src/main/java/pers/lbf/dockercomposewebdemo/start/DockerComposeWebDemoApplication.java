package pers.lbf.dockercomposewebdemo.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laibf
 */
@SpringBootApplication(scanBasePackages = "pers.lbf.dockercomposewebdemo")
public class DockerComposeWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerComposeWebDemoApplication.class, args);
    }

}
