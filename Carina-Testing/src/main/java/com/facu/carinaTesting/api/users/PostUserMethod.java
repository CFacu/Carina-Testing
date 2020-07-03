package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUserMethod extends AbstractApiMethodV2 implements IUserPaths {

    public PostUserMethod() {
        super(userPostRQ, userPostRS, userProperties);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
