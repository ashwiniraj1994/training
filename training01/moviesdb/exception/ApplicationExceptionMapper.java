package com.moviesdb.exception;

import com.moviesdb.model.vo.BaseVo;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ApplicationException appEx = new ApplicationException(ex.getMessage(), ex);
        BaseVo bvo = new BaseVo();
        bvo.setMsg(appEx.getMessage());
        bvo.setStatus(com.moviesdb.exception.ExceptionMessages.APP_ERROR);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(bvo).type(MediaType.APPLICATION_JSON).build();
    }
}
