package cl.martinez.puppychopvet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PuppychopvetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PuppychopvetApplication.class, args);
        System.out.println("\n🐕 PuppyChopVet Backend corriendo en http://localhost:8080\n");
    }

}
