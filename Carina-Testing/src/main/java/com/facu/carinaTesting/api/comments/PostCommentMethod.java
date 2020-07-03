package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCommentMethod extends AbstractApiMethodV2 implements ICommentPaths{

    public PostCommentMethod() {
        super(commentPostRQ, commentPostRS, commentProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
