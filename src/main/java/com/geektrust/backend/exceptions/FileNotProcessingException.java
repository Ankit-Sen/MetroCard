package com.geektrust.backend.exceptions;

public class FileNotProcessingException extends RuntimeException {

    public FileNotProcessingException(){
        super();
    }

    public FileNotProcessingException(String msg){
        super(msg);
    }
}
