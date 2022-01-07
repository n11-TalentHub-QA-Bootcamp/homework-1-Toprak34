package verification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static String apiKey="8adf71fc-c27b-40ef-8662-19ab891129e3";

    private RequestSpec() {

    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().build()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(Url.DOG_API_URI)
                .header("x-api-key", apiKey);
    }
}
