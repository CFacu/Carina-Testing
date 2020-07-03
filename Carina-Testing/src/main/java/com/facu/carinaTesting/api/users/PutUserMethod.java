package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutUserMethod extends AbstractApiMethodV2 implements IUserPaths{

    public PutUserMethod(String userId) {
        super(userPutRQ, userPutRS, userProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", userId);
    }
}
