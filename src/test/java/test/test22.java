package test;

import io.restassured.response.Response;
import models.VotesDto;
import org.junit.Assert;
import org.junit.Test;
import service.DogApiService;


import static helper.HelperMethods.getRandomString;
import static verification.RequestSpec.requestSpecification;

public class test22 {

    DogApiService dogApiService = new DogApiService();

    String sub_id = "my-user-1234";

    @Test
    public void test(){
        Response response = dogApiService.getVotesBySubId(sub_id, requestSpecification());
        System.out.println("response.asPrettyString() = " + response.asPrettyString());

    }

    @Test
    public void test1(){
        String imageId = getRandomString();

        VotesDto votesDto = VotesDto.builder()
                .image_id(imageId)
                .build();

        Response response = dogApiService.createVoteBySubIdAndImageId(votesDto, requestSpecification());

        Integer  votesId = response.path("id");
        System.out.println("votesId = " + votesId);

        Response votesBySubIdAndVotesId = dogApiService.getVotesByVotesId(votesId, requestSpecification());

        System.out.println("votesBySubId.asPrettyString() = " + votesBySubIdAndVotesId.asPrettyString());

        String responseImageId = votesBySubIdAndVotesId.path("image_id");

        System.out.println(responseImageId+ " == " +imageId);

        Assert.assertEquals(responseImageId,imageId);


    }

    @Test
    public void te12st1(){
        String imageId = getRandomString();

        VotesDto votesDto = VotesDto.builder()
                .image_id(imageId)
                .build();

        Integer votesId = dogApiService.createVoteAndGetVotesId(votesDto, requestSpecification());

        System.out.println("votesId = " + votesId);


        Response votesByVotesId = dogApiService.getVotesByVotesId(votesId, requestSpecification());

        System.out.println("votesByVotesId = " + votesByVotesId.asPrettyString());

        String responseImageId = votesByVotesId.path("image_id");

        System.out.println(responseImageId+ " == " +imageId);

        Assert.assertEquals(responseImageId,imageId);


    }

}
