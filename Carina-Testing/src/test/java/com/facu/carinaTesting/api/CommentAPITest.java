package com.facu.carinaTesting.api;

import com.facu.carinaTesting.api.comments.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
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
        String deleteRs = deleteCommentMethod.callAPI().asString();
        String deletedId = JsonPath.from(deleteRs).getString("id");

        deleteCommentMethod.validateResponse();
        Assert.assertNull(deletedId);
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
        String putRs = putCommentMethod.callAPI().asString();
        String newId = JsonPath.from(putRs).getString("id");

        String oldName = JsonPath.from(getRs).getString("name");
        String newName = JsonPath.from(putRs).getString("name");

        putCommentMethod.validateResponse();
        Assert.assertEquals(id, newId);
        Assert.assertNotEquals(oldName, newName);
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
        String deleteRs = deleteCommentMethod.callAPI().asString();

        deleteCommentMethod.validateResponse();
        Assert.assertEquals(deleteRs, "{}");
    }
}
