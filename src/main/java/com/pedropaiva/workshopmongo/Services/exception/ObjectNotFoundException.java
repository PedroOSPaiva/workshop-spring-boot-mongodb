package com.pedropaiva.workshopmongo.Services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//sobrepondo a mensagem.
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
