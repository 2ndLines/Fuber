package com.hakim.data.lean;

import com.hakim.data.lean.operator.BatchArray;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/3/31 19:50<br/>
 * Desc :
 */
public interface DataApi {

    /**
     * 插入数据
     * @param table
     * @param object
     * @param <T>
     * @return
     */
    @POST("classes/{table}")
    <T> Observable<String> insert(@Path("table") String table, @Body T object);

    /**
     * 获取单条数据
     * @param table
     * @param id
     * @param <T>
     * @return
     */
    @GET("classes/{table}/{objectId}")
    <T> Observable<T> get(@Path("table") String table, @Path("objectId") String id);

    /**
     * 更新数据
     * @param table
     * @param objectId
     * @param operator
     * @return
     */
    @FormUrlEncoded
    @PUT("classes/{table}/{objectId}")
    Observable<Boolean> update(@Path("table") String table,
                               @Path("objectId") String objectId,
                               @FieldMap Map<String, Object> operator);

    /**
     * 对某个整型字段数值进行递增或递减操作
     * @param table
     * @param objectId
     * @param operator
     */
    @PUT("classes/{table}/{objectId}")
    void counter(@Path("table") String table,
                 @Path("objectId") String objectId,
                 @FieldMap Map<String, String> operator);

    /**
     * 对某个字段添加或删除关联关系
     * @param table
     * @param objectId
     * @param map
     */
    @PUT("classes/{table}/{objectId}")
    void relate(@Path("table") String table,
                @Path("objectId") String objectId,
                @FieldMap Map<String, String> map);

    /**
     * 删除某条记录
     *
     * @param table
     * @param objectId
     */
    @DELETE("classes/{table}/{objectId}")
    void delete(@Path("table")String table, @Path("objectId")String objectId);

    /**
     * 删除某个字段
     * @param table
     * @param objectId
     * @param operator
     */
    @PUT("classes/{table}/{objectId}")
    void deleteField(@Path("table") String table, @Path("objectId") String objectId,
                     @FieldMap Map<String, String> operator);

    @POST("batch")
    void batch(@Body BatchArray array);
}
