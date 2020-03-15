package org.luna.permission.exception;


import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 * <p>
 * 规范：流程跳转尽量避免使用抛 BizException 来做控制。
 *
 * @author daoshenzzg@163.com
 * @date 2019-09-06 18:02
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public org.alvin.code.gen.beans.RestfullResp handleBizException(BizException ex) {
        log.error(ex.getMessage(), ex);
        org.alvin.code.gen.beans.RestfullResp  result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(ex.getCode());
        if (Strings.isNullOrEmpty(ex.getErrMsg())) {
            result.setErrorMsg(ex.getErrMsg());
        }
        return result ;
    }

    /**
     * 参数绑定错误
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public org.alvin.code.gen.beans.RestfullResp handleBindException(BindException ex) {
        log.error(ex.getMessage(), ex);
        String msg = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(";"));
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg(msg);
        return result;
    }

    /**
     * 参数校验错误
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidationException.class)
    public org.alvin.code.gen.beans.RestfullResp handleValidationException(ValidationException ex) {
        log.error(ex.getMessage(), ex);
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg(ex.getCause().getMessage());
        return result;
    }

    /**
     * 字段校验不通过异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public org.alvin.code.gen.beans.RestfullResp handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        String msg = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(";"));
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg(msg);
        return result;
    }

    /**
     * Controller参数绑定错误
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public org.alvin.code.gen.beans.RestfullResp handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error(ex.getMessage(), ex);
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg(ex.getCause().getMessage());
        return result;
    }

    /**
     * 处理方法不支持异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public org.alvin.code.gen.beans.RestfullResp handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error(ex.getMessage(), ex);
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg("服务器错误");
        return result;
    }

    /**
     * 其他未知异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public org.alvin.code.gen.beans.RestfullResp handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        org.alvin.code.gen.beans.RestfullResp result = new org.alvin.code.gen.beans.RestfullResp();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setErrorMsg("服务器错误");
        return result;
    }

}