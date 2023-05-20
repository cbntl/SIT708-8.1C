package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

public class SignUp extends AppCompatActivity {
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    Button SignUpButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        SignUpButton = findViewById(R.id.SignUpButton);
        db = new DatabaseHelper(this);

        SignUpButton.setOnClickListener(view -> {
            System.out.println("Sign up button Pressed");
            handleSignup();
        });
    }

    private void handleSignup() {
        String name = editTextName.getText().toString();
        if (name.matches("")) {
            showToast("You did not enter name");
            return;
        }
        String username = editTextUsername.getText().toString();
        if (username.matches("")) {
            showToast("You did not enter username");
            return;
        }
        String password = editTextPassword.getText().toString();
        if (password.matches("")) {
            showToast("You did not enter password");
            return;
        }
        String confirmPassword = editTextConfirmPassword.getText().toString();
        if (confirmPassword.matches("")) {
            showToast("You did not enter confirm password");
            return;
        }
        if (!password.equals(confirmPassword)) {
            showToast("Password does not match. Try again!");
            return;
        }

        User user = new User(UUID.randomUUID().toString(), name, username, password);
        Boolean success = db.addUser(user);
        if (success) {
            showToast("Sign up success");
            this.finish();
        } else {
            showToast("Sign up failed");
        }

    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}