package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostPostMethod extends AbstractApiMethodV2 {

    public PostPostMethod() {
        super("api\\posts\\_post\\rq.json", "api\\posts\\_post\\rs.json", "api\\posts\\posts.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
