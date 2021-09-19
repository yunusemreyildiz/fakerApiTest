package network;

import io.restassured.response.Response;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class Network {
    private static Network instance = new Network();

    private Network(){}
    public static Network getInstance(){
        return instance;
    }

    public  Response getList(String addUrl) {
            String url = Constants.BASE_URL+ addUrl;
            Response response = given()
                    .contentType("application/json")
                    .when()
                    .get(url)
                    .then()
                    .extract().response();
            return response;

    }
}
