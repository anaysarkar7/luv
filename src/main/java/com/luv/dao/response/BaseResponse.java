package com.luv.dao.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.luv.util.constant.StatusMessageConstants.FAILURE;
import static com.luv.util.constant.StatusMessageConstants.SUCCESS;

@Data
@AllArgsConstructor
public class BaseResponse<T> {

    private T data;
    private String statusMessage;

    public static <D> BaseResponse<D> success() {
        return new BaseResponse<>(null, SUCCESS);
    }
    public static <D> BaseResponse<D> success(D data) {
        return new BaseResponse<>(data, SUCCESS);
    }
    public static <D> BaseResponse<D> failure() {
        return new BaseResponse<>(null, FAILURE);
    }
    public static <D> BaseResponse<D> failure(D data) {
        return new BaseResponse<>(data, FAILURE);
    }
}