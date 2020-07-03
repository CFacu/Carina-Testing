package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.users.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class UsersAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createAndDeleteUserTest(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String postRs = postUserMethod.callAPI().asString();
        postUserMethod.validateResponse();

        String id = JsonPath.from(postRs).getString("id");

        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(id);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndUpdateUserTest(){
        GetUserMethod getUserMethod = new GetUserMethod("4");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getUserMethod.callAPI().asString();
        getUserMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        PutUserMethod putUserMethod = new PutUserMethod(id);
        putUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUserMethod.callAPI();
        putUserMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndDeleteUserTest(){
        GetUserMethod getUserMethod = new GetUserMethod("4");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getUserMethod.callAPI().asString();
        getUserMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(id);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getUserNegativeTest(){
        GetUserMethod getUserMethod = new GetUserMethod("1899823");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getUserMethod.callAPI();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAllUsersTest(){
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethod.callAPI();
        getUsersMethod.validateResponseAgainstJSONSchema("api\\users\\_get\\users_schema.json");
    }

}
