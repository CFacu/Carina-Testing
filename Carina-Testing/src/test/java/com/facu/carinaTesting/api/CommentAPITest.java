package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.comments.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;

public class CommentAPITest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Facundo")
    public void createPostTest(){
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        postCommentMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postCommentMethod.callAPI();
        postCommentMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getCommentTest(){
        GetCommentMethod getCommentMethod = new GetCommentMethod("50");
        getCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentMethod.callAPI();
        getCommentMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void getCommentsTest(){
        GetCommentsMethod getCommentsMethod = new GetCommentsMethod();
        getCommentsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentsMethod.callAPI();
        getCommentsMethod.validateResponseAgainstJSONSchema("api\\comments\\_get\\comments_schema.json");
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void deleteCommentTest(){
        DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod("2");
        deleteCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteCommentMethod.callAPI();
        deleteCommentMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Facundo")
    public void putCommentTest(){
        PutCommentMethod putCommentMethod = new PutCommentMethod("2");
        putCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putCommentMethod.callAPI();
        putCommentMethod.validateResponse();

    }
}
