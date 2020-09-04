package com.example.picassoveretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.picassoveretrofit.Adapters.BilgiAdapter;
import com.example.picassoveretrofit.Models.Bilgi;
import com.example.picassoveretrofit.RestAPI.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    public void tanimla() {
        listView = (ListView)findViewById(R.id.list_view);
    }

    public void istek() {
        list = new ArrayList<>();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Veriler Ekranı");
        progressDialog.setMessage("Veriler Çekiliyor, Lütfen Bekleyiniz...");
        progressDialog.setCancelable(false);
        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();
        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    BilgiAdapter adapter = new BilgiAdapter(list, getApplicationContext());
                    listView.setAdapter(adapter);
                }
                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }

}