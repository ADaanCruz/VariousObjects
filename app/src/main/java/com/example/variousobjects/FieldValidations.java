package com.example.variousobjects;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

class FieldValidations {

    private Context context = null;
    private EditText[] fields = null;
    private View focusView = null;

    FieldValidations(Context context, EditText[] fields){
        this.setContext(context);
        this.setFields(fields);
    }

    boolean areNotEmpty() {
        boolean validate = true;
        focusView = null;
        for (EditText field : getFields()) {
            if (field.getText().toString().isEmpty()) {
                field.setError("Campo requerido");
                focusView = field;
                validate = false;
            }
        }
        if (focusView != null) {
            focusView.requestFocus();
        }

        return validate;
    }

    boolean isPhoneValid(EditText phone) {
        if (phone.length() < 10) {
            phone.setError("Télefono inválido");
            focusView = phone;
            focusView.requestFocus();
            return false;
        }
        return true;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public EditText[] getFields() {
        return fields;
    }

    public void setFields(EditText[] campos) {
        this.fields = campos;
    }
}
