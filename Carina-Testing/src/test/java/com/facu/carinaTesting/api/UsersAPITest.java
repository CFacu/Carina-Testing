package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.users.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createAndDeleteUserTest(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String postRs = postUserMethod.callAPI().asString();
        postUserMethod.validateResponse();

        String postId = JsonPath.from(postRs).getString("id");

        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(postId);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteRs = deleteUserMethod.callAPI().asString();
        String deleteId = JsonPath.from(deleteRs).getString("id");

        deleteUserMethod.validateResponse();
        Assert.assertNotEquals(postId, deleteId);
        Assert.assertNull(deleteId);
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndUpdateUserTest(){
        String id = "4";
        GetUserMethod getUserMethod = new GetUserMethod(id);
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getUserMethod.callAPI().asString();
        getUserMethod.validateResponse();

        PutUserMethod putUserMethod = new PutUserMethod(id);
        putUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String putRs = putUserMethod.callAPI().asString();
        String newId = JsonPath.from(putRs).getString("id");

        String oldName = JsonPath.from(getRs).getString("name");
        String newName = JsonPath.from(putRs).getString("name");

        putUserMethod.validateResponse();
        Assert.assertEquals(id, newId);
        Assert.assertNotEquals(oldName, newName);
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
        String deleteRs = deleteUserMethod.callAPI().asString();
        String deletedId = JsonPath.from(deleteRs).getString("id");

        deleteUserMethod.validateResponse();
        Assert.assertNull(deletedId);
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getUserNegativeTest(){
        GetUserMethod getUserMethod = new GetUserMethod("1899823");
        getUserMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        String getRs = getUserMethod.callAPI().asString();

        Assert.assertEquals(getRs, "{}");
    }

}
