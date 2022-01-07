package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.VotesDto;
import service.DogApiService;

import static org.junit.Assert.assertEquals;
import static verification.RequestSpec.requestSpecification;

public class VoteSteps {

    DogApiService dogApiService = new DogApiService();

    String imageId;
    Integer votesId;

    @Given("I check of votes for this {string}")
    public void i_check_of_votes_for_this(String sub_id) {
        dogApiService.getVotesBySubId(sub_id, requestSpecification());

    }


    @When("I will create one more vote with {string} and {string}")
    public void i_will_create_one_more_vote_with_and(String sub_id, String image_id) {

        VotesDto votesDto = VotesDto.builder()
                .sub_id(sub_id)
                .image_id(image_id)
                .build();

        votesId = dogApiService.createVoteAndGetVotesId(votesDto, requestSpecification());
        imageId = image_id;
    }

    @Then("I will check of my vote")
    public void i_will_check_of_my_vote() {

        Response response = dogApiService.getVotesByVotesId(votesId, requestSpecification());
        System.out.println("response.asPrettyString() = " + response.asPrettyString());
        String responseImageId = response.path("image_id");
        Integer responseVotesId = response.path("id");

        System.out.println(responseImageId + " == " + imageId);
        System.out.println(responseVotesId + " == " + votesId);

        assertEquals(responseImageId, imageId);
        assertEquals(responseVotesId, votesId);

    }
}
