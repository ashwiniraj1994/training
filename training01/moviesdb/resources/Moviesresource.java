package com.moviesdb.resources;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.MovieEntity;
import com.moviesdb.model.vo.ErrorMessageVo;
import com.moviesdb.web.service.intf.MovieWebServiceIntf;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by ashwinirajasekar on 5/23/17.
 */
@Path("Movie")
@Api(value = "Movie", description = "Operations about movies")
@Produces(APPLICATION_JSON)
public class Moviesresource extends BaseResource {


    private static final Logger LOGGER = getLogger(Moviesresource.class);
    private static final String MOVIE_ERROR_CODE = "100";
    private static final String MOVIE = "MOVIE";

    @Autowired
    private MovieWebServiceIntf movieWebService;

    /**
     * user details for a particular userId
     *
     * @param movieId
     * @return user will be returned as application/json response.
     */
    @GET
    @Path("/{movieId}")
    @Produces(APPLICATION_JSON)
    @ApiModelProperty(position = 1)
    @ApiOperation(value = "Find movie by id", notes = "get Movie Details", response = MovieEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for movie", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "movie not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "movie fetch error", response = ErrorMessageVo.class)
    })
    public MovieEntity getMovie(@PathParam("movieId") Integer movieId) {
        LOGGER.info("Enter GET lean movie for movie with id {}", movieId);
        MovieEntity movieEntity = null;

        return (MovieEntity) super.get(movieId, MovieEntity.class, "100",
                "MOVIE", "Error movie GET", "Error while GET details for movie with id {} ", movieWebService, movieEntity);

    }


    /**
     * Method handling HTTP POST requests. The returned object will be sent to
     * the client as "application/json" media type.Used to create a new site
     * object for the enterprise
     *
     * @param movieInsert
     * @return user that will be returned as a application/json response.
     */
    @POST
    @ApiOperation(value = "Create Sites", notes = "Create movie details", response = MovieEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Movie Creation error", response = ErrorMessageVo.class)
    })
    public MovieEntity post(MovieEntity movieInsert) {
        LOGGER.info("Enter POST on Movie {}", movieInsert);
        MovieEntity movieCreated = null;
        try {

            movieCreated = movieWebService.createMovie(movieInsert);
        } catch (ApplicationException ex) {
            LOGGER.error("Error while POST for Movie {}", ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, MOVIE_ERROR_CODE,
                    MOVIE, "", "", "", ex.getMessage(), "Error in POST Site");

        }
        LOGGER.info("Exit POST on movie ");
        return movieCreated;

    }


    /**
     * User update for a particular userId
     *
     * @param movieId
     */
    /**
     * Method handling HTTP PUT requests. The returned object will be sent to
     * the client as "application/json" media type.Used to update the Site
     *
     * @param movieId
     * @param movie
     * @return userVo that will be returned as a application/json response.
     */
    @PUT
    @Path("/{movieId}")
    @ApiOperation(value = "Update movie by ID", notes = "Update movie details", response = MovieEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for movie", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "movie not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "movie modify error", response = ErrorMessageVo.class)
    })
    public MovieEntity put(@PathParam("movieId") Integer movieId, MovieEntity movie) {
        LOGGER.info("Enter PUT Site for id {}", movieId);
        // Check if Url Id and the Entity Id in payload are the same.
        if (!movie.getId().equals(movieId)) {
            buildErrorMsgvo(Response.Status.PRECONDITION_FAILED, MOVIE_ERROR_CODE,
                    MOVIE, movieId.toString(), "", "", ID_MISMATCH, "Error in movie PUT");
        }
        MovieEntity movieUpdated = null;
        try {

            movieUpdated = movieWebService.update(movie, movieId);
        } catch (ApplicationException ex) {
            LOGGER.error("Error while PUT for movie with id {} {}", movieId, ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, MOVIE_ERROR_CODE,
                    MOVIE, movieId.toString(), "", "", ex.getMessage(), "Error PUT user");
        }
        LOGGER.info("Exit PUT movie for id {}", movieId);
        return movieUpdated;
    }

    /**
     * Method handling HTTP DELETE requests. The returned object will be sent to
     * the client as "application/json" media type.Used to delete the Site
     *
     * @param movieId
     * @return UserEntity that will be returned as a application/json response.
     */
    @DELETE
    @Path("/{sid}")
    @ApiOperation(value = "Delete movie by ID", notes = "Delete movie")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid id for movie", response = ErrorMessageVo.class),
            @ApiResponse(code = 404, message = "Movie not found", response = ErrorMessageVo.class),
            @ApiResponse(code = 500, message = "Movie Deletion error", response = ErrorMessageVo.class),
            @ApiResponse(code = 204, message = "Movie Deleted")
    })
    public void delete(@PathParam("sid") Integer movieId) {
        LOGGER.info("Enter DELETE Site for id {}", movieId);
        MovieEntity movieDeleted = null;
        try {
            movieDeleted = movieWebService.delete(movieId);
            if (movieDeleted == null) {
                buildErrorMsgvo(Response.Status.NOT_FOUND, appProperties.getProperty("site.error.code"),
                        "Site", movieId.toString(), "", "", NOT_FOUND, "Error in Site DELETE");
            }
        } catch (ApplicationException ex) {
            LOGGER.error("Error while DELETE of movie with id {} {}", movieId, ex);
            buildErrorMsgvo(Response.Status.INTERNAL_SERVER_ERROR, MOVIE_ERROR_CODE,
                    MOVIE, movieId.toString(), "", "", ex.getMessage(), "Error DELETE Site");

        }
        LOGGER.info("Exit DELETE Site for id {}", movieId);
    }


    @OPTIONS
    @ApiOperation(value = "get movie options", notes = "get movie options")
    public void getOptions() {

        ok().build();
    }
}
