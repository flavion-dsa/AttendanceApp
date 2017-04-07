package org.frcrce.attendanceapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.OsConstants;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText mUsername, mPassword;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (TextInputEditText) findViewById(R.id.username);
        mPassword = (TextInputEditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login_button);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
