package br.com.systemsgs.keymanagerpix.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.keymanagerpix.model.ModelUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<ModelUsuario, Long>{
	
	boolean existsByChave(String chave);
	
	void deleteByPixIdAndClienteId(UUID pixId, String clienteId);

}
