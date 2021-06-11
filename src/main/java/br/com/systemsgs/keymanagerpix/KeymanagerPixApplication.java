package br.com.systemsgs.keymanagerpix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KeymanagerPixApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeymanagerPixApplication.class, args);
	}

}
