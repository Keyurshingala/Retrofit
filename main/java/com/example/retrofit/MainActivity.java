package com.example.retrofit;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.retrofit.adapter.MyAdapter;
import com.example.retrofit.databinding.ActivityMainBinding;
import com.example.retrofit.model.ApiResponse;
import com.example.retrofit.servise.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MainActivity mContext;
    ActivityMainBinding binding;
    MyAdapter adapter;
    ProgressDialog dialog;
    Call<ApiResponse> responseCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mContext = this;

        initView();
        getCall();
    }

    private void initView() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Please wait");
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
    }

    private void getCall() {
        dialog.show();
        responseCall = ApiClient.getClient().getResponse(2);
        responseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                dialog.dismiss();
                adapter = new MyAdapter(response.body().getUserList(), mContext, null);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                binding.recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }
}