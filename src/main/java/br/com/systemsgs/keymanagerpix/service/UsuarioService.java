package br.com.systemsgs.keymanagerpix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.keymanagerpix.model.ModelUsuario;
import br.com.systemsgs.keymanagerpix.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public ModelUsuario salvaUsuario(ModelUsuario modelUsuario) {
		
		ModelUsuario usuarioSalvo = usuarioRepository.save(modelUsuario);
		
		return usuarioSalvo;
	}

}
