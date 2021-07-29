package com.terabytesoft.mynaturaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(Long id) {
        super("Client not found with id: " + id);
    }
}
