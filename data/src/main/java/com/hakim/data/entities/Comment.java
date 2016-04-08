package com.hakim.data.entities;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/4/8 22:16<br/>
 * Desc :
 */
@AVClassName("Comment")
public class Comment extends AVObject {
    /**
     * 被评论的post的ObjectId
     */
    private String postId;

    /**
     * 被评论者的userId
     */
    private String replyId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论者的userId
     */
    private String commId;

    public Comment(){
        super();
    }

    public static final Creator CREATOR = AVObjectCreator.instance;

}
