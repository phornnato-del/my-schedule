package com.example.myschedule.exception;

import com.example.myschedule.mapper.ErrorMapper;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorMapper errorMapper;

    public ApiException(ErrorMapper errorMapper) {
        super(errorMapper.getMessage());
        this.errorMapper=errorMapper;
    }

    public ApiException(int code, String message) {
        super(message);
        this.errorMapper = new ErrorMapper(code, message);
    }

}
