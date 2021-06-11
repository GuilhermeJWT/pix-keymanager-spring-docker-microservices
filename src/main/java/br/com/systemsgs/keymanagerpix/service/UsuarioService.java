package br.com.systemsgs.keymanagerpix.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.keymanagerpix.converter.DozerConverter;
import br.com.systemsgs.keymanagerpix.dto.ModelUsuarioDTO;
import br.com.systemsgs.keymanagerpix.model.ModelUsuario;
import br.com.systemsgs.keymanagerpix.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public ModelUsuarioDTO salvaUsuario(ModelUsuarioDTO modelUsuarioDTO) {
		
		var modelUsuario = DozerConverter.converteEntidade(modelUsuarioDTO, ModelUsuario.class);
		var entidadeConvertida = DozerConverter.converteEntidade(usuarioRepository.save(modelUsuario), ModelUsuarioDTO.class);
		
		return entidadeConvertida;
	}
	
	@Transactional
	public void removeChavePiv(UUID pixId, String clienteId) {
		usuarioRepository.deleteByPixIdAndClienteId(pixId, clienteId);
		System.out.println("Removendo id: " + pixId);
	}
	
}
