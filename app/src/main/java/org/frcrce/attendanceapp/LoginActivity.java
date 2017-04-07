package org.frcrce.attendanceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.input_username) EditText mUsernameText;
    @BindView(R.id.input_password) EditText mPasswordText;
    @BindView(R.id.btn_login) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    protected void login() {
        Log.d(TAG,"Login");

        if(!validateLogin()) {
            onLoginFailed();
            return;
        }
        mLoginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String username = mUsernameText.getText().toString().trim();
        String password = mPasswordText.getText().toString().trim();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSuccess();
                progressDialog.dismiss();
            }
        },3000);
    }

    protected boolean validateLogin() {
        return true;
    }

    protected void onLoginSuccess() {
        mLoginButton.setEnabled(true);

        Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
        intent.putExtra("username",mUsernameText.getText().toString());
        startActivity(intent);
        this.finish();
    }

    protected void onLoginFailed() {

    }


}
