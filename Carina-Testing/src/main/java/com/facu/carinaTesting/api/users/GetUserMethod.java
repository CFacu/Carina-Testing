package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetUserMethod extends AbstractApiMethodV2 implements IUserPaths{

    public GetUserMethod(String userId) {
        super(null, userGetRS);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", userId);
    }
}
