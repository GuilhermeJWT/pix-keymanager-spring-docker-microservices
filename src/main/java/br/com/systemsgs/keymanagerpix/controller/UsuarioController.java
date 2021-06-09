package br.com.systemsgs.keymanagerpix.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.systemsgs.keymanagerpix.model.ModelUsuario;
import br.com.systemsgs.keymanagerpix.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/salvar")
	@Transactional
	public ResponseEntity<?> salvaUsuarioTeste(@RequestBody @Valid ModelUsuario modelUsuario, UriComponentsBuilder builder){
		
		ModelUsuario usuarioSalvo = usuarioService.salvaUsuario(modelUsuario);
		URI uriRedireciona = builder.path("/api/usuario/salvar").build(usuarioSalvo.getCpf());
		
		return ResponseEntity.created(uriRedireciona).build();
	}

}
