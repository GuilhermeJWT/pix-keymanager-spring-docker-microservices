package br.com.systemsgs.keymanagerpix.exception;

public class RecursoNaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException() {
        super("PixId ou ClienteId não Encontrado!!! - 404");
    }

}
