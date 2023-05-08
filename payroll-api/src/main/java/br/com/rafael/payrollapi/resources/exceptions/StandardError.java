package br.com.rafael.payrollapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
public class StandardError {

    private LocalDateTime timeStamp;
    private  String error;
    private Integer status;
    private String path;

}
