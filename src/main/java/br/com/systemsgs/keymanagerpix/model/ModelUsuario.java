package br.com.systemsgs.keymanagerpix.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.systemsgs.keymanagerpix.enums.StatusTipoChave;
import br.com.systemsgs.keymanagerpix.enums.StatusTipoConta;

@Entity
@Table(name = "usuario")
public class ModelUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clienteId;

	private String chave;

	@Enumerated(EnumType.STRING)
	private StatusTipoChave tipoChave;

	@Enumerated(EnumType.STRING)
	private StatusTipoConta statusConta;

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelUsuario other = (ModelUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
