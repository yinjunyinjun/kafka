package com.mycompany.kafka.util;

/**
 * 封装API的错误码
 * Created by binginx on 2019/10/30.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
