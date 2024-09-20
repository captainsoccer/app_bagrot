package com.example.idk_tofes;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class TextValidator implements TextWatcher {
    int minLength;
    int maxLength;

    TextView errorTextView;
    boolean numberOnly;
    boolean textOnly;
    boolean email;
    public TextValidator(int minLength, int maxLength, TextView errorTextView,
                         boolean numberOnly, boolean textOnly, boolean email) {

        this.minLength = minLength;
        this.maxLength = maxLength;
        this.errorTextView = errorTextView;
        this.numberOnly = numberOnly;
        this.textOnly = textOnly;
        this.email = email;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        errorTextView.setVisibility(TextView.VISIBLE);
        if(charSequence.toString().isEmpty()) {
            errorTextView.setText("Cannot be empty");
        } else if(charSequence.toString().length() < minLength) {
            errorTextView.setText("needs to be at least " + minLength + " characters long");
        } else if(charSequence.toString().length() > maxLength) {
            errorTextView.setText("needs to be at most " + maxLength + " characters long");
        } else if (numberOnly && !charSequence.toString().matches("[0-9]+")) {
            errorTextView.setText("Only numbers are allowed");
        } else if (textOnly && !charSequence.toString().matches("[a-zA-Z ]+")) {
            errorTextView.setText("Only text is allowed");
        } else if (email && !charSequence.toString().matches("^(.+)@(.+)$")) {
            errorTextView.setText("Invalid email");
        } else {
            errorTextView.setText("");
            errorTextView.setVisibility(TextView.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
