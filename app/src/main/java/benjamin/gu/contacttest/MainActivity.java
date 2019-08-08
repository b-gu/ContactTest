package benjamin.gu.contacttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CustomListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;

    Callback<ResultPojo> callback = new Callback<ResultPojo>() {
        @Override
        public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
            if(response.isSuccessful()){
                adapter = new CustomAdapter();
                adapter.setDataSet(response.body());
                adapter.setListener(MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ResultPojo> call, Throwable t) {
            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        initRetroFit();
    }

    public void initRetroFit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getContacts().enqueue(callback);
    }

    @Override
    public void onClick(ContactsPojo item) {
        Intent intent = new Intent(this, ContactInfoActivity.class);
        intent.putExtra("name", item.name);
        intent.putExtra("id", item.id);
        intent.putExtra("email", item.email);
        intent.putExtra("address", item.address);
        intent.putExtra("gender", item.gender);
        intent.putExtra("home phone", item.phone.home);
        intent.putExtra("mobile phone", item.phone.mobile);
        intent.putExtra("office phone", item.phone.office);
        setResult(RESULT_OK, intent);
        startActivity(intent);
    }
}
