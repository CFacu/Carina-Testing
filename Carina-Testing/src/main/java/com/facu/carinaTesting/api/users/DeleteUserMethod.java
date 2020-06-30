package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUserMethod extends AbstractApiMethodV2 {

    public DeleteUserMethod(String userId) {
        super(null, "api\\users\\_delete\\rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", userId);
    }
}
