package com.gemini.mqapp.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Data
@Builder
public class QMResponse<T> {

    private String message;
    private boolean result;
    private T data;

    public static QMResponse defaultSuccess(){
        return QMResponse.builder().data(new ArrayList<>()).message("Successful").result(true).build();
    }

    public static QMResponse defaultError(){
        return QMResponse.builder().data(new ArrayList<>()).message("Error").result(false).build();
    }

    public static QMResponse defaultError(String msg){
        return QMResponse.builder().data(new ArrayList<>()).message(msg).result(false).build();
    }

    public static <T> QMResponse defaultSuccess(T data){
        return QMResponse.builder().data(data).message("Successful").result(true).build();
    }
}
