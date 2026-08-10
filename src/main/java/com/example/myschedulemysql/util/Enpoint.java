package com.example.myschedulemysql.util;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class Enpoint {
    public static String url = "http://localhost:8080";
}
