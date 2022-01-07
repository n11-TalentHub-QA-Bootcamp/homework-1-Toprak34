package models;

import lombok.Builder;
import lombok.Data;

import static helper.HelperMethods.getRandomString;

@Builder
public @Data class VotesDto{

	@Builder.Default
	private String sub_id = "my-user-1234";

	@Builder.Default
	private String image_id = getRandomString();

	@Builder.Default
	private int value = 1;
}