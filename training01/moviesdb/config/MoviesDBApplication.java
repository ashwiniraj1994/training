package com.moviesdb.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * Created by shanvini on 5/20/17.
 */
public class MoviesDBApplication extends ResourceConfig {

    public MoviesDBApplication() {
        packages("com.moviesdb.resources", "com.moviesdb.filter"
                , "com.moviesdb.exception");
        register(MultiPartFeature.class);
        register(JacksonFeature.class);
        // for logging register(LoggingFilter.class);
        register(MoviesDBAppEventListener.class);
        // Propagate validation errors to client
        setApplicationName("MoviesDB");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
        register(com.wordnik.swagger.jaxrs.JaxrsApiReader.class);
        register(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
        register(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
        register(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
        register(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);

    }

}
