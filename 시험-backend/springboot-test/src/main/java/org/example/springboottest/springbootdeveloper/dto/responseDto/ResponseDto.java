package org.example.springboottest.springbootdeveloper.dto.responseDto;

import lombok.Getter;

@Getter
public class ResponseDto<T> {
    private boolean success;
    private String message;
    private T data;

    private ResponseDto(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseDto<T> setSuccess(T data) {
        return new ResponseDto<>(true, "성공", data);
    }

    public static <T> ResponseDto<T> setFailure(String message) {
        return new ResponseDto<>(false, message, null);
    }
}
