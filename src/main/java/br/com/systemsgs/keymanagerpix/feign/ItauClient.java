package br.com.systemsgs.keymanagerpix.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "contas-clientes", url = "http://localhost:9091")
public interface ItauClient {
	

}
