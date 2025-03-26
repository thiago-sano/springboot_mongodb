package br.com.educandoweb.springbootmongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private final static long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
