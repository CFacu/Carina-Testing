package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteCommentMethod extends AbstractApiMethodV2 {

    public DeleteCommentMethod(String commentId) {
        super(null, "api\\comments\\_delete\\rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
