package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.posts.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostsAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createAndDeletePostTest(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String postRs = postPostMethod.callAPI().asString();
        postPostMethod.validateResponse();

        String id = JsonPath.from(postRs).getString("id");

        DeletePostMethod deletePostMethod = new DeletePostMethod(id);
        deletePostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteRs = deletePostMethod.callAPI().asString();
        String deletedId = JsonPath.from(deleteRs).getString("id");

        deletePostMethod.validateResponse();
        Assert.assertNull(deletedId);
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndDeletePostTest(){
        GetPostMethod getPostMethod = new GetPostMethod("2");
        getPostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getPostMethod.callAPI().asString();
        getPostMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        DeletePostMethod deletePostMethod = new DeletePostMethod(id);
        deletePostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteRs = deletePostMethod.callAPI().asString();
        String deletedId = JsonPath.from(deleteRs).getString("id");

        deletePostMethod.validateResponse();
        Assert.assertNull(deletedId);
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getPostNegativeTest(){
        GetPostMethod getPostMethod = new GetPostMethod("-165");
        getPostMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        String getRs = getPostMethod.callAPI().asString();

        Assert.assertEquals(getRs, "{}");
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndUpdatePostTest(){
        GetPostMethod getPostMethod = new GetPostMethod("2");
        getPostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getPostMethod.callAPI().asString();
        getPostMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        PutPostMethod putPostMethod = new PutPostMethod(id);
        putPostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String putRs = putPostMethod.callAPI().asString();
        String newId = JsonPath.from(putRs).getString("id");

        String oldTitle = JsonPath.from(getRs).getString("title");
        String newTitle = JsonPath.from(putRs).getString("title");

        putPostMethod.validateResponse();
        Assert.assertEquals(id, newId);
        Assert.assertNotEquals(oldTitle, newTitle);
    }
}
