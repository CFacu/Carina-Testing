package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.comments.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class CommentAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createAndDeletePostTest(){
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        postCommentMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String postRs = postCommentMethod.callAPI().asString();
        postCommentMethod.validateResponse();

        String id = JsonPath.from(postRs).getString("id");

        DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod(id);
        deleteCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteCommentMethod.callAPI();
        deleteCommentMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndUpdateCommentTest(){
        GetCommentMethod getCommentMethod = new GetCommentMethod("50");
        getCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getCommentMethod.callAPI().asString();
        getCommentMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        PutCommentMethod putCommentMethod = new PutCommentMethod(id);
        putCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putCommentMethod.callAPI();
        putCommentMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAllCommentsTest(){
        GetCommentsMethod getCommentsMethod = new GetCommentsMethod();
        getCommentsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentsMethod.callAPI();
        getCommentsMethod.validateResponseAgainstJSONSchema("api\\comments\\_get\\comments_schema.json");
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getAndDeleteCommentTest(){
        GetCommentMethod getCommentMethod = new GetCommentMethod("50");
        getCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String getRs = getCommentMethod.callAPI().asString();
        getCommentMethod.validateResponse();

        String id = JsonPath.from(getRs).getString("id");

        DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod(id);
        deleteCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteCommentMethod.callAPI();
        deleteCommentMethod.validateResponse();
    }
}
