package com.trello.api.Test;

import com.trello.api.models.Lable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface LabelsService {


    @POST("lables")
    Call<Lable> createLable(@Query("idList") String idLable, @Query("idBoard") String idBoard, @Query("color") String color);

    @GET("lables/{id}")
    Call<Lable> getLable(@Path("id") String id);

    @DELETE("lables/{id}")
    Call<ResponseBody> deleteLable(@Path("id") String id);

    @PUT("lables/{id}")
    Call<Lable> updateLable(@Path("id") String id);



}
