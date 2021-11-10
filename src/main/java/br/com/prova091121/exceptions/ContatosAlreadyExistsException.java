package br.com.prova091121.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContatosAlreadyExistsException extends ServiceException{

    public ContatosAlreadyExistsException(String message) { super(message); }
}
