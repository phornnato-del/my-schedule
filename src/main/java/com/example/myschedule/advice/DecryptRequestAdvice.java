package com.example.myschedule.advice;

import com.example.myschedule.service.crypto.AesGcmCrypto;
import com.example.myschedule.service.crypto.Encrypted;
import com.example.myschedule.service.crypto.EncryptedPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice
@RequiredArgsConstructor
public class DecryptRequestAdvice extends RequestBodyAdviceAdapter {
    private final AesGcmCrypto crypto;
    private final ObjectMapper mapper;

    @Override
    public boolean supports(MethodParameter mp, Type type,
                            Class<? extends HttpMessageConverter<?>> conv) {
        return mp.getContainingClass().isAnnotationPresent(Encrypted.class)
                || mp.hasMethodAnnotation(Encrypted.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage in, MethodParameter mp,
                                           Type type, Class<? extends HttpMessageConverter<?>> conv) throws IOException {
        EncryptedPayload payload = mapper.readValue(in.getBody(), EncryptedPayload.class);
        byte[] plain = crypto.decrypt(payload.data()).getBytes(StandardCharsets.UTF_8);

        return new HttpInputMessage() {
            @Override public InputStream getBody() { return new ByteArrayInputStream(plain); }
            @Override public HttpHeaders getHeaders() { return in.getHeaders(); }
        };
    }
}