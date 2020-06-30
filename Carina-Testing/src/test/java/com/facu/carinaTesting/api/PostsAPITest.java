package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.posts.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;

public class PostsAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createPostTest(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postPostMethod.callAPI();
        postPostMethod.validateResponse();
    }

//    @Test
//    @MethodOwner(owner = "Facundo")
//    public void createPostNegativeTest(){
//        PostPostMethod postPostMethod = new PostPostMethod();
//        postPostMethod.removeProperty("id");
//        postPostMethod.removeProperty("userId");
//        postPostMethod.removeProperty("title");
//        postPostMethod.removeProperty("body");
//        postPostMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
//        postPostMethod.callAPI();
//        postPostMethod.validateResponse();
//    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void deletePostTest(){
        DeletePostMethod deletePostMethod = new DeletePostMethod("1");
        deletePostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePostMethod.callAPI();
        deletePostMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getPostTest(){
        GetPostMethod getPostMethod = new GetPostMethod("2");
        getPostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPostMethod.callAPI();
        getPostMethod.validateResponse();
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
    public void getPostsTest(){
        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPostsMethod.callAPI();
        getPostsMethod.validateResponseAgainstJSONSchema("api\\posts\\_get\\posts_schema.json");
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void putPostTest(){
        PutPostMethod putPostMethod = new PutPostMethod("5");
        putPostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPostMethod.callAPI();
        putPostMethod.validateResponse();

    }
}
