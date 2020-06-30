package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutCommentMethod extends AbstractApiMethodV2 {

    public PutCommentMethod(String commentId) {
        super("api\\comments\\_put\\rq.json", "api\\comments\\_put\\rs.json", "api\\comments\\comments.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
