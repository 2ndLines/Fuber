package com.hakim.data.lean;


import com.hakim.fuber.domain.entities.User;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;


/**
 * OKLine(ShenZhen) co.,Ltd.<br/>
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/3/29 21:35<br/>
 * Desc :
 */
public interface UserApi {

    @FormUrlEncoded
    @POST(Config.CLASS_USER)
    Observable<User> signin(@Field("username") String username,
                            @Field("password") String password);

    @FormUrlEncoded
    @GET("login")
    Observable<User> signup(@Field("username") String username,
                            @Field("password") String password);

    @GET("users/{objectId}")
    Observable<User> getUser(@Path("objectId") String objectId);

    @FormUrlEncoded
    @POST("users/{objectId}")
    Observable<Boolean> updateUser(@Path("objectId") String objectId, @FieldMap Map<String,
            Object> map);

    @FormUrlEncoded
    @POST("users/{objectId}/updatePassword")
    Observable<Boolean> modifyPassword(@Path("objectId") String objectId,
                                       @Field("oldPassword") String oldPassword,
                                       @Field("newPassword") String newPassword);

    @FormUrlEncoded
    @POST("requestSmsCode")
    Observable<Boolean> requestSmsCode(@Field("mobilePhoneNumber") String phoneNumber,
                                       @Field("ttl") String ttl,
                                       @Field("op") String opType);

    @FormUrlEncoded
    @POST("verifySmsCode/{smsCode}")
    Observable<Boolean> verifySmsCode(@Path("smsCode") String smsCode,
                                      @Field("mobilePhoneNumber") String phoneNumber);

    @FormUrlEncoded
    @POST("usersByMobilePhone")
    Observable<User> createAndLoginByPhone(@Field("mobilePhoneNumber") String phoneNumber,
                                           @Field("smsCode") String smsCode);
}
