package com.example.day1basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.edtUserEmail)
    EditText edtUserEmail;
    @BindView(R.id.edtUserPassword)
    EditText edtUserPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void initView() {
        edtUserEmail = (EditText) findViewById(R.id.edtUserEmail);
        edtUserPassword = (EditText) findViewById(R.id.edtUserPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

    }

    private void login() {
        String email = edtUserEmail.getText().toString();
        String password = edtUserPassword.getText().toString();
        if (email.isEmpty() || email.trim().length() == 0) {

            edtUserEmail.setError("Enter Email ID");
        }

        if (email.equals("Guri") && password.equals("1234")) {
            //Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
            i.putExtra("email", email);

//                Bundle mBundle = new Bundle();
//                mBundle.putInt("id",100);
//                mBundle.putString("email",email);
//                i.putExtra("all",mBundle);
            startActivity(i);
            //finish();
        } else {
            Toast.makeText(getApplicationContext(), "Error Wrong Email or Password", Toast.LENGTH_SHORT).show();
        }

    }
}
