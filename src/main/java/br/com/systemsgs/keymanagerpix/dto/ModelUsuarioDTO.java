package br.com.systemsgs.keymanagerpix.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.systemsgs.keymanagerpix.enums.StatusTipoChave;
import br.com.systemsgs.keymanagerpix.enums.StatusTipoConta;

public class ModelUsuarioDTO {

	@CPF(message = "Chave Inválida, Informe outra!!!")
	@NotBlank(message = "A Chave deve ser Informada!!!")
	private String chave;

	@NotBlank(message = "O ID Cliente deve ser Informado!!!")
	private String clienteId;

	@Enumerated(EnumType.STRING)
	private StatusTipoChave tipoChave;

	@Enumerated(EnumType.STRING)
	private StatusTipoConta statusConta;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public StatusTipoChave getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(StatusTipoChave tipoChave) {
		this.tipoChave = tipoChave;
	}

	public StatusTipoConta getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(StatusTipoConta statusConta) {
		this.statusConta = statusConta;
	}

}
