package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutUserMethod extends AbstractApiMethodV2 {

    public PutUserMethod(String userId) {
        super("api\\users\\_put\\rq.json", "api\\users\\_put\\rs.json", "api\\users\\users.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", userId);
    }
}
