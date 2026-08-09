package com.example.myschedule.exception;

import com.example.myschedule.mapper.ErrorMapper;

public class ApiException extends RuntimeException {

    private final ErrorMapper errorMapper;

    public ApiException(ErrorMapper errorMapper) {
        super(errorMapper.getMessage());
        this.errorMapper=errorMapper;
    }

    public ErrorMapper getErrorMapper() {
        return errorMapper;
    }
}
