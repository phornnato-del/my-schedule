package com.example.myschedule.enums;


import lombok.Getter;

@Getter
public enum StatusEnum {

    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    UNKNOWN(0, "Unknown Error");

    private final int code;
    private final String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


}