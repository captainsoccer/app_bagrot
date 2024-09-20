package com.example.idk_tofes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Model model;
    private Button registerButton;
    private EditText nameEditText, emailEditText, passwordEditText, phoneEditText, userNameEditText;
    private TextValidator nameValidator, emailValidator, passwordValidator, phoneValidator, userNameValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        model = new Model(this);

        initializeWidgets();
        setValidators();
        setListeners();
    }

    private void initializeWidgets() {
        registerButton = findViewById(R.id.btn_create_user);
        nameEditText = findViewById(R.id.et_full_name);
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        phoneEditText = findViewById(R.id.et_phone_number);
        userNameEditText = findViewById(R.id.et_username);
    }

    private void setValidators() {
        nameValidator = new TextValidator(getResources().getInteger(R.integer.min_full_name_length),
                getResources().getInteger(R.integer.max_full_name_length),
                findViewById(R.id.tv_full_name_error), false, true, false);

        emailValidator = new TextValidator(getResources().getInteger(R.integer.min_email_length),
                getResources().getInteger(R.integer.max_email_length),
                findViewById(R.id.tv_email_error), false, false, true);

        passwordValidator = new TextValidator(getResources().getInteger(R.integer.min_password_length),
                getResources().getInteger(R.integer.max_password_length),
                findViewById(R.id.tv_password_error), false, false, false);

        phoneValidator = new TextValidator(getResources().getInteger(R.integer.min_phone_number_length),
                getResources().getInteger(R.integer.max_phone_number_length),
                findViewById(R.id.tv_phone_number_error), true, false, false);

        userNameValidator = new TextValidator(getResources().getInteger(R.integer.min_username_length),
                getResources().getInteger(R.integer.max_username_length),
                findViewById(R.id.tv_username_error), false, true, false);
    }

    private void setListeners() {
        nameEditText.addTextChangedListener(nameValidator);
        emailEditText.addTextChangedListener(emailValidator);
        passwordEditText.addTextChangedListener(passwordValidator);
        phoneEditText.addTextChangedListener(phoneValidator);
        userNameEditText.addTextChangedListener(userNameValidator);

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        try {
            User newUser = new User(
                    nameEditText.getText().toString(),
                    emailEditText.getText().toString(),
                    passwordEditText.getText().toString(),
                    phoneEditText.getText().toString(),
                    userNameEditText.getText().toString()
            );
            model.addUser(newUser);

            Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show();
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}