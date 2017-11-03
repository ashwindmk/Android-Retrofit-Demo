package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofitdemo.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        startLoad();
    }

    private void initViews() {
        mTextView = (TextView) findViewById(R.id.textView);
    }

    private void startLoad() {
        RetrofitInterface apiService = RetrofitClient.getClient().create(RetrofitInterface.class);

        Call<List<User>> call = apiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>call, Response<List<User>> response) {
                List<User> users = response.body();
                //Log.d(TAG, "Number of users received: " + users.size());
                String userStr = "";
                for (User user : users) {
                    //Log.d(TAG, "user " + user.getId() + " : " + user.getName());
                    userStr += "user " + user.getId() + " : " + user.getName() + "\n\n";
                }

                mTextView.setText(userStr);
            }

            @Override
            public void onFailure(Call<List<User>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                mTextView.setText("Error!");
            }
        });
    }
}
