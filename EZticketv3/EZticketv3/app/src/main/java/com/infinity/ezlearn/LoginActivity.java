package com.infinity.ezlearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    SharedPreferences mPreferences;

    private String sharePreFile = "com.example.android.hellosharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        login = findViewById(R.id.button_login);

        mPreferences = getSharedPreferences(sharePreFile, MODE_PRIVATE);
        email.setText(mPreferences.getString("mail", ""));
        password.setText(mPreferences.getString("pass", ""));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString("mail", email.getText().toString());
                preferencesEditor.putString("pass", password.getText().toString());
                preferencesEditor.apply();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                /*
                Untuk Clear

                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.clear();
                preferencesEditor.apply();

                user_name.setText("");
                password.setText("");
                 */
            }
        });
    }
}
