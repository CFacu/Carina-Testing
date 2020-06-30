package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutPostMethod extends AbstractApiMethodV2 {

    public PutPostMethod(String postId) {
        super("api\\posts\\_put\\rq.json", "api\\posts\\_put\\rs.json", "api\\posts\\posts.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", postId);
    }
}
