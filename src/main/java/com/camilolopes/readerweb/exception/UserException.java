package com.camilolopes.readerweb.exception;

public class UserException extends Exception {
	private static final long serialVersionUID = 1531482506680428558L;
	
	public UserException() {
	
	}
	public UserException(String mensagem){
		super(mensagem);
	}

}
