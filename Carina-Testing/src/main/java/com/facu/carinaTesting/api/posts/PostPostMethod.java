package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostPostMethod extends AbstractApiMethodV2 implements IPostPaths{

    public PostPostMethod() {
        super(postPostRQ, postPostRS, postProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
