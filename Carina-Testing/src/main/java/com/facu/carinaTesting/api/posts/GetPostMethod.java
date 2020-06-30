package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetPostMethod extends AbstractApiMethodV2 {

    public GetPostMethod(String postId) {
        super(null, "api\\posts\\_get\\rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", postId);
    }
}
