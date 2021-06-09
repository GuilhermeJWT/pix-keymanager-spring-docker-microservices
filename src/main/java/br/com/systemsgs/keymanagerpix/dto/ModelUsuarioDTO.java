package br.com.systemsgs.keymanagerpix.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class ModelUsuarioDTO {
	
	@CPF(message = "Cpf Inválido, Informe outro!!!")
	@NotBlank(message = "O Cpf deve ser Informado para Pesquisar!!!")
	private String cpf;

	public String getCpf() {
		return cpf;
	}

}
