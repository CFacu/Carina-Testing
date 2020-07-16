package com.facu.carinaTesting.api.posts;

import java.io.File;

public interface IPostPaths {
    String postPostRS = String.format("api%sposts%s_post%srs.json", File.separator, File.separator, File.separator);
    String postPostRQ = String.format("api%sposts%s_post%srq.json", File.separator, File.separator, File.separator);

    String postGetRS = String.format("api%sposts%s_get%srs.json", File.separator, File.separator, File.separator);

    String postDeleteRS = String.format("api%sposts%s_delete%srs.json", File.separator, File.separator, File.separator);

    String postPutRS = String.format("api%sposts%s_put%srs.json", File.separator, File.separator, File.separator);
    String postPutRQ = String.format("api%sposts%s_put%srq.json", File.separator, File.separator, File.separator);

    String postProperties = String.format("api%sposts%sposts.properties", File.separator, File.separator);
}