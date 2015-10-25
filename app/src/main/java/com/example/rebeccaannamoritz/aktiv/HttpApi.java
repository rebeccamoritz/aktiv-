package com.example.rebeccaannamoritz.aktiv;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import retrofit.*;
import retrofit.http.*;
import java.util.List;

import java.io.IOException;
import java.util.Map;
/**
 * Created by rebeccaannamoritz on 12.10.15.
 */
public class HttpApi {

    public static final String API_URL = "http://192.168.33.10";

    private static HttpApi instance = null;
    private Map<String, String> headers = new HashMap<String, String>();
    private AktiviteatenService service;


    /**
     * HttpBin.org service definition
     */
    public interface AktiviteatenService {
        @GET("/aktivitaeten.json")
        Call<List<Aktivitaet>> getAktivitaeten();
    }


    /**
     * Private constructor
     */
    private HttpApi() {
        // Http interceptor to add custom headers to every request
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.networkInterceptors().add(new Interceptor() {
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();

                System.out.println("Adding headers:" + headers);
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }

                return chain.proceed(builder.build());
            }
        });

        // Retrofit setup
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Service setup
        service = retrofit.create(AktiviteatenService.class);
    }

    /**
     * Get the HttpApi singleton instance
     */
    public static HttpApi getInstance() {
        if(instance == null) {
            instance = new HttpApi();
        }
        return instance;
    }

    /**
     * Get the API service to execute calls with
     */
    public AktiviteatenService getService() {
        return service;
    }
}


