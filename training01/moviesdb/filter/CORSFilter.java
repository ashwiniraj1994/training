package com.moviesdb.filter;

import java.io.IOException;
import java.util.Properties;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Autowired
    @Qualifier("mainControllerProperties")
    public Properties appProperties;

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crespl) throws IOException {

        String[] originArray = appProperties.getProperty("app.cors.Access-Control-Allow-Origin").split(",");
        for (String retval : originArray) {
            crespl.getHeaders().add("Access-Control-Allow-Origin", retval);
        }

        crespl.getHeaders().add("Access-Control-Allow-Credentials", appProperties.getProperty("app.cors.Access-Control-Allow-Credentials"));
        crespl.getHeaders().add("Access-Control-Allow-Methods", appProperties.getProperty("app.cors.Access-Control-Allow-Methods"));
        crespl.getHeaders().add("Access-Control-Allow-Headers", appProperties.getProperty("app.cors.Access-Control-Allow-Headers"));

    }

}
