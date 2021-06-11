package br.com.systemsgs.keymanagerpix.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.keymanagerpix.dto.ModelUsuarioDTO;
import br.com.systemsgs.keymanagerpix.feign.ItauClient;
import br.com.systemsgs.keymanagerpix.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ItauClient itauClient;
	
	@PostMapping(value = "/salvar")
	@Transactional
	public String salvaUsuarioTeste(@RequestBody @Valid ModelUsuarioDTO modelUsuarioDTO){
	   ModelUsuarioDTO usuarioSalvoDTO =  usuarioService.salvaUsuario(modelUsuarioDTO);
	   
		return usuarioSalvoDTO.getChave();
	}
	
	@GetMapping(value = "/pesquisaUsuariosItau")
	public List<ModelUsuarioDTO> retornaTodosClientesItau() {
		return itauClient.retornaTodosClientesItau();
	}
	
	@DeleteMapping(value = "/removeChave/{pixId}/{clienteId}")
	public void removeChavePix(@PathVariable UUID pixId, @PathVariable String clienteId){
		usuarioService.removeChavePiv(pixId, clienteId);
	}
	
}
