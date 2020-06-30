package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeletePostMethod extends AbstractApiMethodV2 {

    public DeletePostMethod(String postId) {
        super(null, "api\\posts\\_delete\\rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", postId);
    }
}
