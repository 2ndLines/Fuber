package com.hakim.data.lean;

import okhttp3.RequestBody;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/4/5 20:04<br/>
 * Desc :
 */
public interface FileApi {
    @POST("files/{fileName}")
    @Headers("Content-Type: image/png")
    Observable<String> uploadImage(@Path("fileName")String fileName,
                                   @Part("photo")RequestBody photo);
}
