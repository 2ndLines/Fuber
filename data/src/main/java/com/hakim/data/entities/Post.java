package com.hakim.data.entities;

import android.os.Parcelable;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/4/8 21:39<br/>
 * Desc :
 */
@AVClassName("Post")
public class Post extends AVObject{

    /**
     * 编辑的文本
     */
    private String text;
    /**
     * 附加的图片
     */
    private String[] images;
    /**
     * 录制的语言
     */
    private String voice;
    /**
     * 承载方式
     */
    private int carrier;
    /**
     * 发送的起点
     */
    private float[] start;
    /**
     * 发送的目的地
     */
    private float[] dest;
    /**
     * 阅读的次数
     */
    private int read;
    /**
     * 点赞的次数
     */
    private int like;

    private int accusation;

    private boolean spam;

    public Post(){
        super();
    }

    public String getText() {
        return getString("text");
    }

    public void setText(String text) {
        put("text",text);
    }

    public String[] getImages() {
        return (String[]) get("images");
    }

    public void setImages(String[] images) {
        put("images",images);
    }

    public String getVoice() {
        return getString("voice");
    }

    public void setVoice(String voice) {
        put("voice",voice);
    }

    public int getCarrier() {
        return getInt("carrier");
    }

    public void setCarrier(int carrier) {
        put("carrier", carrier);
    }

    public float[] getStart() {
        return (float[]) get("start");
    }

    public void setStart(float[] start) {
        put("start", start);
    }

    public float[] getDest() {
        return (float[]) get("dest");
    }

    public void setDest(float[] dest) {
        put("dest", dest);
    }

    public int getRead() {
        return getInt("read");
    }

    public void incrementRead() {
        increment("read");
    }

    public int getLike() {
        return getInt("like");
    }

    public void incrementLike() {
        increment("like");
    }

    public void setSpam(boolean spam){
        put("spam",spam);
    }

    public boolean isSpam(){
        return getBoolean("spam");
    }

    public int getAccusation() {
        return getInt("accusation");
    }

    public void takeAccusation() {
        increment("accusation");
        if(getAccusation() > 50){
            setSpam(true);
        }
    }

    public static final Parcelable.Creator CREATOR = AVObject.AVObjectCreator.instance;

}
