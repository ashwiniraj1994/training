package com.moviesdb.resources;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.UserEntity;
import com.moviesdb.model.vo.ErrorMessageVo;
import com.moviesdb.web.service.intf.UserWebServiceIntf;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;
import static org.slf4j.LoggerFactory.getLogger;

@Path("users")
@Api(value = "users", description = "Operations about users")
@Produces(APPLICATION_JSON)
public class UsersResource extends BaseResource {

    private static final Logger LOGGER = getLogger(UsersResource.class);
    private static final String USER_ERROR_CODE="100";
    private static final String USER="USER";

    @Autowired
    private UserWebServiceIntf userWebService;

    /**
     * user details for a particular userId
     *
     * @param userId
     * @return user will be returned as application/json response.
     */
    @GET
    @Path("/{userId}")
    @Produces(APPLICATION_JSON)
    @ApiModelProperty(position = 1)
    @ApiOperation(value = "Find user by id", notes = "get User Details", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for user", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "user not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "user fetch error", response = ErrorMessageVo.class)
    })
    public UserEntity getUser(@PathParam("userId") Integer userId) {
        LOGGER.info("Enter GET lean user for user with id {}", userId);
        UserEntity userEntity = null;

        return (UserEntity) super.get(userId, UserEntity.class, "100",
                "USER", "Error user GET", "Error while GET details for user with id {} ", userWebService, userEntity);

    }


    /**
     * Method handling HTTP POST requests. The returned object will be sent to
     * the client as "application/json" media type.Used to create a new site
     * object for the enterprise
     *
     * @param userInsert
     * @return user that will be returned as a application/json response.
     */
    @POST
    @ApiOperation(value = "Create Sites", notes = "Create user details", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "User Creation error", response = ErrorMessageVo.class)
    })
    public UserEntity post(UserEntity userInsert) {
        LOGGER.info("Enter POST on User {}", userInsert);
        UserEntity userCreated = null;
        try {

            userCreated = userWebService.createUser(userInsert);
        } catch (ApplicationException ex) {
            LOGGER.error("Error while POST for User {}", ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, USER_ERROR_CODE,
                    USER, "", "", "", ex.getMessage(), "Error in POST Site");

        }
        LOGGER.info("Exit POST on user ");
        return userCreated;

    }


    /**
     * User update for a particular userId
     *
     * @param userId
     */
    /**
     * Method handling HTTP PUT requests. The returned object will be sent to
     * the client as "application/json" media type.Used to update the Site
     *
     * @param userId
     * @param user
     * @return userVo that will be returned as a application/json response.
     */
    @PUT
    @Path("/{userId}")
    @ApiOperation(value = "Update user by ID", notes = "Update user details", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for user", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "user not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "user modify error", response = ErrorMessageVo.class)
    })
    public UserEntity put(@PathParam("userId") Integer userId, UserEntity user) {
        LOGGER.info("Enter PUT Site for id {}", userId);
        // Check if Url Id and the Entity Id in payload are the same.
        if (!user.getId().equals(userId)) {
            buildErrorMsgvo(Response.Status.PRECONDITION_FAILED, USER_ERROR_CODE,
                    USER, userId.toString(), "", "", ID_MISMATCH, "Error in user PUT");
        }
        UserEntity userUpdated = null;
        try {

            userUpdated = userWebService.update(user, userId);
        } catch (ApplicationException ex) {
            LOGGER.error("Error while PUT for user with id {} {}", userId, ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, USER_ERROR_CODE,
                    USER, userId.toString(), "", "", ex.getMessage(), "Error PUT user");
        }
        LOGGER.info("Exit PUT user for id {}", userId);
        return userUpdated;
    }

    /**
     * Method handling HTTP DELETE requests. The returned object will be sent to
     * the client as "application/json" media type.Used to delete the Site
     *
     * @param userId
     * @return UserEntity that will be returned as a application/json response.
     */
    @DELETE
    @Path("/{sid}")
    @ApiOperation(value = "Delete user by ID", notes = "Delete users")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for user", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "User not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "User Deletion error", response = ErrorMessageVo.class),
            @ApiResponse(code = 204, message = "User Deleted")
    })
    public void delete(@PathParam("sid") Integer userId) {
        LOGGER.info("Enter DELETE Site for id {}", userId);
        UserEntity userDeleted = null;
        try {
            userDeleted = userWebService.delete(userId);
            if (userDeleted == null) {
                buildErrorMsgvo(Response.Status.NOT_FOUND, appProperties.getProperty("site.error.code"),
                        "Site", userId.toString(), "", "", NOT_FOUND, "Error in Site DELETE");
            }
        } catch (ApplicationException ex) {
            LOGGER.error("Error while DELETE of user with id {} {}", userId, ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, USER_ERROR_CODE,
                    USER, userId.toString(), "", "", ex.getMessage(), "Error DELETE Site");

        }
        LOGGER.info("Exit DELETE Site for id {}", userId);
    }



    @OPTIONS
    @ApiOperation(value = "get user options", notes = "get user options")
    public void getOptions() {

        ok().build();
    }
}
