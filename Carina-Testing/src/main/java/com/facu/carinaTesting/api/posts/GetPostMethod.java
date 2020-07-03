package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetPostMethod extends AbstractApiMethodV2 implements IPostPaths{

    public GetPostMethod(String postId) {
        super(null, postGetRS);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", postId);
    }
}
