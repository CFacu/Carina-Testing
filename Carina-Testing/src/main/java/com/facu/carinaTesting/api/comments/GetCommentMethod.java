package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommentMethod extends AbstractApiMethodV2 {

    public GetCommentMethod(String commentId) {
        super(null, "api\\comments\\_get\\rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
