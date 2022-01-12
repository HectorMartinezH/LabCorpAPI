package factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest{

    @Override
    public Response send(RequestInformation information) {
        Response response=given()
                .request()
                .get(information.getUrl());

        response.then()
                .log()
                .all();

        return response;
    }
}

