/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bkuri000
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseVo {
    //TODO: Mark all these fields as Required and cannot be NULL

    private String status;

    private String msg = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Response getResponse200(BaseVo bvo) {
        return Response.status(200).entity(bvo).build();
    }

    public static Response getResponse500(BaseVo bvo) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(bvo).build();
    }

}
