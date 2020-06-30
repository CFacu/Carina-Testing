package com.facu.carinaTesting.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetPostsMethod extends AbstractApiMethodV2 {

    public GetPostsMethod() {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
