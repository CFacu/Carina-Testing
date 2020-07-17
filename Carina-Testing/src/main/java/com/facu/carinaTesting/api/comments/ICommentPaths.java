package com.facu.carinaTesting.api.comments;

import java.io.File;

public interface ICommentPaths {
    String commentPostRS = String.format("api%scomments%s_post%srs.json", File.separator, File.separator, File.separator);
    String commentPostRQ = String.format("api%scomments%s_post%srq.json", File.separator, File.separator, File.separator);

    String commentGetRS = String.format("api%scomments%s_get%srs.json", File.separator, File.separator, File.separator);

    String commentDeleteRS = String.format("api%scomments%s_delete%srs.json", File.separator, File.separator, File.separator);

    String commentPutRS = String.format("api%scomments%s_put%srs.json", File.separator, File.separator, File.separator);
    String commentPutRQ = String.format("api%scomments%s_put%srq.json", File.separator, File.separator, File.separator);

    String commentProperties = String.format("api%scomments%scomments.properties", File.separator, File.separator);
}