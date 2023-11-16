package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //ciaooooo

    RetrofitProvider retrofitProvider = new RetrofitProvider();
    String sid = "ePzuGF55G6Z5ZRj6Vj7J";
    int uid = 1007;
    String name = "Lak12";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerSid();
            }
        });


        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNearbyObj();
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getObj();
            }
        });


        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateObj();
            }
        });

        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearByUsers();
            }
        });

        Button btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserById();
            }
        });

        Button btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsersRanking();
            }
        });

        Button btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUserDet();
            }
        });

    }

    private void registerSid() {

        Call<SignUpResponse> signUpCall = retrofitProvider.getApiInterface().register();
        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, retrofit2.Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                SignUpResponse result = response.body();
                Log.d("Lak", "SID: " + result.sid);
                TextView tv = findViewById(R.id.textView);
                tv.setText(result.sid);
            }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });

    }

    private void getNearbyObj() {

        Call<List<ObjectsResponse>> call = retrofitProvider.getApiInterface().getObjects(sid, 10, 10);
        call.enqueue(new Callback<List<ObjectsResponse>>() {
            @Override
            public void onResponse(Call<List<ObjectsResponse>> call, retrofit2.Response<List<ObjectsResponse>> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                List<ObjectsResponse> result = response.body();
                for (ObjectsResponse obj : result) {
                    Log.d("Lak", "ID: " + obj.id);
                    Log.d("Lak", "Lat: " + obj.lat);
                    Log.d("Lak", "Lon: " + obj.lon);
                }
            }
            @Override
            public void onFailure(Call<List<ObjectsResponse>> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });

    }

    private void getObj() {

        Call<ObjectsResponseId> call = retrofitProvider.getApiInterface().getObject(5, sid);
        call.enqueue(new Callback<ObjectsResponseId>() {
            @Override
            public void onResponse(Call<ObjectsResponseId> call, retrofit2.Response<ObjectsResponseId> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                ObjectsResponseId result = response.body();
                Log.d("Lak", "ID: " + result.id);
                Log.d("Lak", "Type: " + result.type);
                Log.d("Lak", "Name: " + result.name);
                Log.d("Lak", "Level: " + result.level);
                Log.d("Lak", "Image: " + result.image);
                Log.d("Lak", "Lat: " + result.lat);
                Log.d("Lak", "Lon: " + result.lon);
            }
            @Override
            public void onFailure(Call<ObjectsResponseId> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });
    }

    private void activateObj() {

        Call<ResponseUserData> call = retrofitProvider.getApiInterface().activateObject(5, sid);
        call.enqueue(new Callback<ResponseUserData>() {
            @Override
            public void onResponse(Call<ResponseUserData> call, retrofit2.Response<ResponseUserData> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                ResponseUserData result = response.body();
                Log.d("Lak", "Diend: " + result.died);
                Log.d("Lak", "Life: " + result.life);
                Log.d("Lak", "Exp: " + result.experience);
                Log.d("Lak", "Weapon: " + result.weapon);
                Log.d("Lak", "Armor: " + result.armor);
                Log.d("Lak", "Amulet: " + result.amulet);
            }
            @Override
            public void onFailure(Call<ResponseUserData> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });

    }

    private void nearByUsers() {

        Call<List<ResponseUsers>> call = retrofitProvider.getApiInterface().getUsers(sid, 10, 10);
        call.enqueue(new Callback<List<ResponseUsers>>() {
            @Override
            public void onResponse(Call<List<ResponseUsers>> call, retrofit2.Response<List<ResponseUsers>> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                List<ResponseUsers> result = response.body();
                for (ResponseUsers obj : result) {
                    Log.d("Lak", "UID: " + obj.uid);
                    Log.d("Lak", "Lat: " + obj.lat);
                    Log.d("Lak", "Lon: " + obj.lon);
                    Log.d("Lak", "Profile Version: " + obj.profileversion);
                    Log.d("Lak", "Life: " + obj.life);
                    Log.d("Lak", "Exp: " + obj.experience);
                    Log.d("Lak", "Time: " + obj.time);
                }
            }
            @Override
            public void onFailure(Call<List<ResponseUsers>> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });

    }

    private void getUserById() {
        Call<ResponseUsersId> call = retrofitProvider.getApiInterface().getUser(3, sid);
        call.enqueue(new Callback<ResponseUsersId>() {
            @Override
            public void onResponse(Call<ResponseUsersId> call, retrofit2.Response<ResponseUsersId> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                ResponseUsersId result = response.body();
                Log.d("Lak", "UID: " + result.uid);
                Log.d("Lak", "Name: " + result.name);
                Log.d("Lak", "Lat: " + result.lat);
                Log.d("Lak", "Lon: " + result.lon);
                Log.d("Lak", "Time: " + result.time);
                Log.d("Lak", "Life: " + result.life);
                Log.d("Lak", "Exp: " + result.experience);
                Log.d("Lak", "Weapon: " + result.weapon);
                Log.d("Lak", "Armor: " + result.armor);
                Log.d("Lak", "Amulet: " + result.amulet);
                Log.d("Lak", "Image: " + result.picture);
                Log.d("Lak", "Profile Version: " + result.profileversion);
                Log.d("Lak", "Position Share: " + result.positionshare);
            }
            @Override
            public void onFailure(Call<ResponseUsersId> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });
    }

    private void getUsersRanking() {
        Call<List<ResponseUsersRanking>> call = retrofitProvider.getApiInterface().getRanking(sid);
        call.enqueue(new Callback<List<ResponseUsersRanking>>() {
            @Override
            public void onResponse(Call<List<ResponseUsersRanking>> call, retrofit2.Response<List<ResponseUsersRanking>> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                List<ResponseUsersRanking> result = response.body();
                for (ResponseUsersRanking obj : result) {
                    Log.d("Lak", "UID: " + obj.uid);
                    Log.d("Lak", "Life: " + obj.life);
                    Log.d("Lak", "Exp: " + obj.experience);
                    Log.d("Lak", "Profile Version: " + obj.profileversion);
                }
            }
            @Override
            public void onFailure(Call<List<ResponseUsersRanking>> call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });
    }

    private void editUserDet() {
        Call<JsonElement> editUserCall = retrofitProvider.getApiInterface().editUSer(uid, sid, name, null, true);
        editUserCall.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, retrofit2.Response<JsonElement> response) {
                if (!response.isSuccessful()) {
                    Log.d("Lak", "Error: " + response.code());
                    return;
                }
                Log.d("Lak", "Success");
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("Lak", "Error: " + t.getMessage());
            }
        });
    }

}