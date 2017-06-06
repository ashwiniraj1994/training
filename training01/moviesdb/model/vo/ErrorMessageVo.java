/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bkuri000
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ErrorMessageVo {

    private String message;
    private String code;
    private List<ErrorVo> errors;

    public ErrorMessageVo(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ErrorMessageVo(String message, String code, List<ErrorVo> errors) {
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ErrorVo> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVo> errors) {
        this.errors = errors;
    }

}
