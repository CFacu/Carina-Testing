package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteCommentMethod extends AbstractApiMethodV2 implements ICommentPaths{

    public DeleteCommentMethod(String commentId) {
        super(null, commentDeleteRS);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
