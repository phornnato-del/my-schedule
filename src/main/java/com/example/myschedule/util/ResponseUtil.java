package com.example.myschedule.util;

import com.example.myschedule.dto.response.BaseWebResponse;

public class ResponseUtil {

    public static <T> BaseWebResponse<T> success(T data) {
        return BaseWebResponse.<T>builder()
                .status(200)
                .message("Success")
                .data(data)
                .build();
    }

    public static <T> BaseWebResponse<T> success(String message, T data) {
        return BaseWebResponse.<T>builder()
                .status(200)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseWebResponse<T> error(int status, String message) {
        return BaseWebResponse.<T>builder()
                .status(status)
                .message(message)
                .data(null)
                .build();
    }
}