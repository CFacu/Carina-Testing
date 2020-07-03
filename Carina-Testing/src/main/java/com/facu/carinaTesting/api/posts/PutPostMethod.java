package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutPostMethod extends AbstractApiMethodV2 implements IPostPaths{

    public PutPostMethod(String postId) {
        super(postPutRQ, postPutRS, postProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", postId);
    }
}
