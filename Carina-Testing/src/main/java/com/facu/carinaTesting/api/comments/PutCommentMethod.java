package com.facu.carinaTesting.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutCommentMethod extends AbstractApiMethodV2 implements ICommentPaths{

    public PutCommentMethod(String commentId) {
        super(commentPutRQ, commentPutRS, commentProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", commentId);
    }
}
