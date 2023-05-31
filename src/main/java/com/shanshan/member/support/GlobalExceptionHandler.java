package com.shanshan.member.support;

import com.shanshan.tools.exception.GlobalException;
import com.shanshan.tools.response.ApiResponse;
import com.shanshan.tools.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tengzhihao
 * @since 2020-06-29 15:46
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(GlobalException e) {
        log.error("程序异常", e);
        ApiResponse r = new ApiResponse();
        r.setErrmsg(e.getMessage());
        r.setErrcode(e.getCode() == 0 ? 402 : e.getCode());
        r.setData(null);
        return r;
    }

    /**
     * 系统异常处理，比如：404,500
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse defaultErrorHandler(Exception e) {
        log.error("系统异常", e);
        ApiResponse r = new ApiResponse();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            r.setErrcode(ResponseCode.NOT_FOUND.getCode());
            r.setErrmsg(e.getMessage());
        } else {
            r.setErrcode(ResponseCode.SERVER_ERROR.getCode());
            r.setErrmsg(ResponseCode.SERVER_ERROR.getMsg());
        }
        r.setData(null);
        return r;
    }

}
