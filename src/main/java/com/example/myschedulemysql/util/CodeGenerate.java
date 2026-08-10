package com.example.myschedulemysql.util;

public class CodeGenerate {
    public static String getCode(String prefix, long code) {
        return prefix + String.format("%05d", code);
    }
}
