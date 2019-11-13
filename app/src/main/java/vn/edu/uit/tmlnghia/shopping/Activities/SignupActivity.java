package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.uit.tmlnghia.shopping.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        getSupportActionBar().setTitle("Đăng ký");

    }
}
