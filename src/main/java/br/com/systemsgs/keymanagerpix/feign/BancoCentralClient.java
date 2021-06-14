package br.com.systemsgs.keymanagerpix.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "banco-central-pix", url = "http://localhost:8082/")
public interface BancoCentralClient {
	
}
