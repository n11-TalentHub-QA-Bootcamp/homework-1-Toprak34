package service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.VotesDto;

import static io.restassured.RestAssured.given;

public class DogApiService {

    public static final String VOTE_BASE_PATH="/votes";

    public Response getVotesBySubId(String sub_id, RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(VOTE_BASE_PATH)
                .queryParam("sub_id", sub_id)
                .when()
                .get()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response createVoteBySubIdAndImageId(VotesDto votesDto, RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(VOTE_BASE_PATH)
                .body(votesDto)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response getVotesByVotesId(Integer votesId, RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(VOTE_BASE_PATH)
                .pathParam("votesId",votesId)
                .when()
                .get("/{votesId}")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Integer createVoteAndGetVotesId(VotesDto votesDto, RequestSpecification requestSpec){

        return given()
                .spec(requestSpec)
                .basePath(VOTE_BASE_PATH)
                .body(votesDto)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response().path("id");

    }
}
