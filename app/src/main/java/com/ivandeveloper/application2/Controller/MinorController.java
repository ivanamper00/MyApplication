package com.ivandeveloper.application2.Controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ivandeveloper.application2.Database.BaseballApi;
import com.ivandeveloper.application2.Database.MlbApi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinorController {

    ProgressDialog pdLoading;
    Context context;


    public void NextIntent(Context context, Class toClass, String data) {
        Intent intent = new Intent(context, toClass);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }


    public void NextIntent(Context context, Class toClass) {
        NextIntent(context, toClass, "");
    }

    public BaseballApi RetrofitBuilder() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("x-rapidapi-host", "api-baseball.p.rapidapi.com")
                        .header("x-rapidapi-key", "07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f")
                        .header("useQueryString","true")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
//
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseballApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        BaseballApi api = retrofit.create(BaseballApi.class);
        return api;
    }

    public MlbApi RetrofitBuilder2() {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request original = chain.request();
//
//                Request request = original.newBuilder()
//                        .header("Ocp-Apim-Subscription-Key", "d40cdb544910484b9d4eb3f570e8a6a6")
//                        .method(original.method(), original.body())
//                        .build();
//
//                return chain.proceed(request);
//            }
//        });

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

//        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MlbApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
                .build();

        MlbApi api = retrofit.create(MlbApi.class);
        return api;
    }

/*

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getYear(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
       return Integer.parseInt(dtf.format(now));
    }
*/


    public void startLoading(Context context){
        this.context = context;
        pdLoading = new ProgressDialog(context);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
    }
    public void stopLoading(){
        pdLoading.dismiss();
    }
}



