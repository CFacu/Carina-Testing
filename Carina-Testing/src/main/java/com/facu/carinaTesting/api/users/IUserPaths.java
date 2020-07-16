package com.facu.carinaTesting.api.users;

import java.io.File;

public interface IUserPaths {
    String userPostRS = String.format("api%susers%s_post%srs.json", File.separator, File.separator, File.separator);
    String userPostRQ = String.format("api%susers%s_post%srq.json", File.separator, File.separator, File.separator);

    String userGetRS = String.format("api%susers%s_get%srs.json", File.separator, File.separator, File.separator);

    String userDeleteRS = String.format("api%susers%s_delete%srs.json", File.separator, File.separator, File.separator);

    String userPutRS = String.format("api%susers%s_put%srs.json", File.separator, File.separator, File.separator);
    String userPutRQ = String.format("api%susers%s_put%srq.json", File.separator, File.separator, File.separator);

    String userProperties = String.format("api%susers%susers.properties", File.separator, File.separator);
}