package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.posts.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
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
        deletePostMethod.callAPI();
        deletePostMethod.validateResponse();
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
        deletePostMethod.callAPI();
        deletePostMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getPostNegativeTest(){
        GetPostMethod getPostMethod = new GetPostMethod("-165");
        getPostMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getPostMethod.callAPI();
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
        putPostMethod.callAPI();
        putPostMethod.validateResponse();

    }
}
