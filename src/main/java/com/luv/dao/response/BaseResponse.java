package com.luv.dao.response;

import com.luv.util.constant.StatusMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {

    private T data;
    private String statusMessage;

    public static <D> BaseResponse<D> success() {
        return new BaseResponse<>(null, StatusMessageConstants.SUCCESS);
    }
    public static <D> BaseResponse<D> success(D data) {
        return new BaseResponse<>(data, StatusMessageConstants.SUCCESS);
    }
    public static <D> BaseResponse<D> failure() {
        return new BaseResponse<>(null, StatusMessageConstants.FAILURE);
    }
    public static <D> BaseResponse<D> failure(D data) {
        return new BaseResponse<>(data, StatusMessageConstants.FAILURE);
    }
}