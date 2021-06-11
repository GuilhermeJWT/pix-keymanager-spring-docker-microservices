package br.com.systemsgs.keymanagerpix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
