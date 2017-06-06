/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.resources;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.BaseEntity;
import com.moviesdb.model.vo.ErrorMessageVo;
import com.moviesdb.model.vo.ErrorVo;
import com.moviesdb.web.service.intf.BaseWebServiceIntf;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.status;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseResource {

    @Autowired
    @Qualifier("mainControllerProperties")
    protected Properties appProperties;

    private static final Logger LOGGER = getLogger(BaseResource.class);
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String NOT_FOUND = "Not Found";
    public static final String ID_MISMATCH = "Id in url and Id in Payload don't match";
    public static final String SITE_ID_NOT_FOUND = "SiteID";
    public static final String BAD_REQUEST = "Bad Request";
    @Context
    private SecurityContext securityContext;

    public void buildErrorMsgvo(final Response.Status x, final String code, final String fieldType, final String fieldId, final String name, final String fieldName, final String message, final String emvos) throws WebApplicationException {
        List<ErrorVo> errors = new ArrayList<>();
        ErrorVo ev = new ErrorVo(code, fieldType, fieldId, name, fieldName, message);
        errors.add(ev);
        ErrorMessageVo emvo = new ErrorMessageVo(emvos, code, errors);
        throw new WebApplicationException(status(x).entity(emvo).build());

    }

    public BaseEntity get(Integer id, Class clazz, String errorCode, String resourceName, String errorMsg, String errorDetail, BaseWebServiceIntf baseService, BaseEntity be) {
        LOGGER.info("Enter GET {} for id {}", resourceName, id);

        try {
            be = (BaseEntity) baseService.read(clazz, id);
            if (be == null) {
                buildErrorMsgvo(Response.Status.NOT_FOUND, errorCode,
                        resourceName, id.toString(), "", "", "Not Found", errorMsg);
            }

        } catch (ApplicationException ex) {
            LOGGER.error(errorDetail, id, ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, errorCode,
                    resourceName, id.toString(), "", "", ex.getMessage(), errorMsg);
        }
        LOGGER.info("Exit GET {} for id {}", resourceName, id);
        return be;
    }
}
