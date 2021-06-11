package br.com.systemsgs.keymanagerpix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.systemsgs.keymanagerpix.dto.ModelUsuarioDTO;

@FeignClient(name = "contas-clientes", url = "http://localhost:9091")
public interface ItauClient {
	
	@GetMapping(value = "/api/v1/private/contas/todas")
	String retornaTodosClientesItau();
	
	@GetMapping(value = "/api/v1/clientes/{clienteId}/contas")
	ModelUsuarioDTO retornaClientePorIdItau();
	
}
