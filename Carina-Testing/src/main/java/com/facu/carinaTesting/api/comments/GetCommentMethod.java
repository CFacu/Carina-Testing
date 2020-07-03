package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommentMethod extends AbstractApiMethodV2 implements ICommentPaths{

    public GetCommentMethod(String commentId) {
        super(null, commentGetRS);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
