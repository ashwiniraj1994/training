/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.config;

import com.wordnik.swagger.converter.ModelConverters;
import com.wordnik.swagger.converter.OverrideConverter;
import com.wordnik.swagger.jaxrs.config.BeanConfig;
import com.wordnik.swagger.jersey.JerseyApiReader;
import java.io.FileInputStream;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/application.properties")

//@Service
public class SwaggerConfig implements ServletContextListener {

    private static final Logger LOGGER = getLogger(SwaggerConfig.class);

    private String apiPath;
    private String defaultApiBasePath = "http://localhost:8080/moviesdb/rest";

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Properties properties = new Properties();
        try {
            properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/spring/application.properties"));

        } catch (Exception e) {
            LOGGER.error("Property reading error from application.properties file", e);
        }
        String apiVersion = properties.getProperty("moviesdb.version");
        String apiBasePath = properties.getProperty("app.moviesdb.swagger.api.base.path");

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion(apiVersion);
        beanConfig.setResourcePackage("com.moviesdb.resources");
        beanConfig.setBasePath(apiBasePath);
        beanConfig.setTitle("Service Configuration Platform API");
        beanConfig.setDescription("These Rest api's are for Service Configuration Platform");
        beanConfig.setScan(Boolean.TRUE);
        beanConfig.setApiReader(JerseyApiReader.class.getName());

        String jsonString = "{"
                + "  \"id\": \"Timestamp\","
                + "  \"properties\": {"
                + "    \"value\": {"
                + "      \"required\": true,"
                + "      \"description\": \"Date in unix timestamp format\","
                + "      \"notes\": \"Date in unix timestamp format\","
                + "      \"type\": \"string\","
                + "      \"format\": \"timestamp\""
                + "    }"
                + "  }"
                + "}";
        OverrideConverter converter = new OverrideConverter();
        converter.add("java.sql.Timestamp", jsonString);
        ModelConverters.addConverter(converter, true);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Swagger context destroyed");
    }
}
