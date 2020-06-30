package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.users.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;

public class UsersAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createUserTest(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postUserMethod.callAPI();
        postUserMethod.validateResponse();
    }

//    @Test
//    @MethodOwner(owner = "Facundo")
//    public void createUserNegativeTest(){
//        PostUserMethod postUserMethod = new PostUserMethod();
//        postUserMethod.removeProperty("id");
//        postUserMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
//        postUserMethod.callAPI();
//        postUserMethod.validateResponse();
//    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getUserTest(){
        GetUserMethod getUserMethod = new GetUserMethod("4");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethod.callAPI();
        getUserMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getUserNegativeTest(){
        GetUserMethod getUserMethod = new GetUserMethod("165168");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getUserMethod.callAPI();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getUsersTest(){
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethod.callAPI();
        getUsersMethod.validateResponseAgainstJSONSchema("api\\users\\_get\\posts_schema.json");
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void deleteUserTest() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod("3");
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void putUserTest() {
        PutUserMethod putUserMethod = new PutUserMethod("2");
        putUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUserMethod.callAPI();
        putUserMethod.validateResponse();
    }
}
