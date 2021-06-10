package br.com.systemsgs.keymanagerpix.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.systemsgs.keymanagerpix.dto.ModelUsuarioDTO;
import br.com.systemsgs.keymanagerpix.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/salvar")
	@Transactional
	public ResponseEntity<?> salvaUsuarioTeste(@RequestBody @Valid ModelUsuarioDTO modelUsuarioDTO, UriComponentsBuilder builder){
		
	   ModelUsuarioDTO usuarioSalvoDTO =  usuarioService.salvaUsuario(modelUsuarioDTO);
	   URI uriRedireciona = builder.path("/api/usuario/salvar").build(usuarioSalvoDTO.getCpf());
		
		return ResponseEntity.created(uriRedireciona).build();
	}

}
