package com.example.myschedule.advice;
import com.example.myschedule.service.crypto.AesGcmCrypto;
import com.example.myschedule.service.crypto.Encrypted;
import com.example.myschedule.service.crypto.EncryptedPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@RestControllerAdvice
@RequiredArgsConstructor
public class EncryptResponseAdvice implements ResponseBodyAdvice<Object> {
    private final AesGcmCrypto crypto;
    private final ObjectMapper mapper;

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> conv) {
        return mp.getContainingClass().isAnnotationPresent(Encrypted.class)
                || mp.hasMethodAnnotation(Encrypted.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter mp, MediaType mt,
                                  Class<? extends HttpMessageConverter<?>> conv,
                                  ServerHttpRequest req, ServerHttpResponse res) {
        if (body == null) return null;
        try {
            return new EncryptedPayload(crypto.encrypt(mapper.writeValueAsString(body)));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }
}