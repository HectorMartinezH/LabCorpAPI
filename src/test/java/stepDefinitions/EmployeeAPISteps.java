package stepDefinitions;

import beans.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import utils.ConfigAPI;

import java.util.List;




public class EmployeeAPISteps {

    private Response response;
    private ResponseBody responseBody;

    @When("User sends a GET request to get Users")
    public void sendRequestToUsersEndpoint() {
        RequestInformation request = new RequestInformation(ConfigAPI.GET_USERS);
        response = FactoryRequest.make(FactoryRequest.GET).send(request);
        response.then()
                .assertThat()
                .statusCode(200);
        responseBody = response.body();
    }

    @Then("^the response should have \"([^\"]*)\" user$")
    public void theResponseShouldHaveUser(String userName) throws JsonProcessingException {
        List<String> employeeFirstnames = response.jsonPath().getList("employee_firstname");
        Assert.assertTrue(employeeFirstnames.contains(userName));

        String employees = response.body().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = mapper.readValue(employees, new TypeReference<>() {});
        Employee employeeExpectedResult = new Employee();
        employeeExpectedResult.setEmployee_firstname("employee_firstname 24");
        employeeExpectedResult.setEmployee_lastname("employee_lastname 24");
        employeeExpectedResult.setEmployee_phonenumbe("773-792-0188");
        employeeExpectedResult.setAdemployee_emaildress("ademployee_emaildress 24");
        employeeExpectedResult.setCitemployee_addressy("citemployee_addressy 24");
        employeeExpectedResult.setStateemployee_dev_level("stateemployee_dev_level 24");
        employeeExpectedResult.setEmployee_gender("employee_gender 24");
        employeeExpectedResult.setEmployee_hire_date("2028-05-10T21:29:00.015Z");

        employeeList.forEach(
                employee -> {
                    if (employee.getEmployee_firstname().equals(userName)) {
                        //Assert.assertTrue(employee.equals(employeeExpectedResult));
                        Assert.assertEquals(employee,employeeExpectedResult);
                    }
                }
        );
    }
}

