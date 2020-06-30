package com.facu.carinaTesting.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetUsersMethod extends AbstractApiMethodV2 {

    public GetUsersMethod() {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
