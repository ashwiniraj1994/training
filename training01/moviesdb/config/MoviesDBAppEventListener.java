/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.config;

import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;
import org.slf4j.Logger;

import java.net.MalformedURLException;

import static java.lang.System.currentTimeMillis;
import static org.slf4j.LoggerFactory.getLogger;


public class MoviesDBAppEventListener implements ApplicationEventListener {

    private static final Logger LOGGER = getLogger(MoviesDBAppEventListener.class);

    @Override
    public void onEvent(ApplicationEvent applicationEvent) {
        switch (applicationEvent.getType()) {
            case INITIALIZATION_FINISHED:
                LOGGER.info("Jersey application {} started.", applicationEvent.getResourceConfig().getApplicationName());
                break;
            case DESTROY_FINISHED:
                LOGGER.info("Jersey Application {} destroyed.", applicationEvent.getResourceConfig().getApplicationName());
                break;
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        return new MyRequestEventListener();
    }

    public static class MyRequestEventListener implements RequestEventListener {

        private volatile long methodStartTime;

        @Override
        public void onEvent(RequestEvent requestEvent) {
            switch (requestEvent.getType()) {
                case RESOURCE_METHOD_START:
                    methodStartTime = currentTimeMillis();
                    break;
                case RESOURCE_METHOD_FINISHED:
                    long methodExecution = currentTimeMillis() - methodStartTime;
                    final String methodName = requestEvent.getUriInfo().getMatchedResourceMethod().getHttpMethod();
                    final String path = requestEvent.getUriInfo().getPath();
                    String url = "";
                    try {
                        url = requestEvent.getUriInfo().getAbsolutePath().toURL().toString();
                    } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        LOGGER.error("Malformed error {}", e);
                    }
                    if (!path.contains("checkStatus")) {
                        Object[] paramArray = {url, path, methodName, methodExecution};

                        LOGGER.info("url |{}| path |{}| Method |{}| executed. Processing time: |{}| ms", paramArray);
                    }
                    break;
                default:

                    break;
            }
        }
    }
}
