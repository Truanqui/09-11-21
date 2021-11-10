package br.com.prova091121.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatosNotFoundException extends ServiceException {

    public ContatosNotFoundException(String message) { super(message);}
}
