package com.example.variousobjects;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataActivity extends AppCompatActivity {

    TextView tvTitulo, tvInstrucciones;
    EditText acNombre, acTelefono;
    CalendarView cFechaDeNacimiento;
    RadioGroup rgSexo;
    RadioButton rbHombre, rbMujer;
    Spinner spNacionalidad;
    Button btnLimpiar, btnSiguiente;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    String[] nacionalidades = {"Selecciona alguno", "Mexican", "American", "Spanish", "Korean", "Italian"};

    EditText[] campos;
    FieldValidations fieldValidations;

    String nombre = null;
    String fechaDeNacimiento = null;
    int radioButtonId;
    String genero = null;
    String telefono = null;
    String nacionalidad = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // Se hace referencia a cada uno de los componentes del Activity.
        tvTitulo = findViewById(R.id.textView_title_data);
        tvInstrucciones = findViewById(R.id.textView_instructions_data);
        acNombre = findViewById(R.id.autoCompleteTextView_name_data);
        cFechaDeNacimiento = findViewById(R.id.calendarView_birthdate_data);
        rgSexo = findViewById(R.id.radioGroup_gender_data);
        rbHombre = findViewById(R.id.radioButton_hombre_data);
        rbMujer = findViewById(R.id.radioButton_mujer_data);
        acTelefono = findViewById(R.id.autoCompleteTextView_phone_data);
        spNacionalidad = findViewById(R.id.spinner_nacionality_data);
        btnLimpiar = findViewById(R.id.button_clear_data);
        btnSiguiente = findViewById(R.id.button_next_data);

        // Se modifican los valores iniciales de los campos.
        acNombre.setText(this.getString(R.string.omar_blanco));
        ArrayAdapter arrayAdapter_spinner_nacion = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                nacionalidades
        );
        fechaDeNacimiento = sdf.format(new Date(cFechaDeNacimiento.getDate()));
        acTelefono.setText(this.getString(R.string.my_phone));
        spNacionalidad.setAdapter(arrayAdapter_spinner_nacion);

        // Se cargan los campos del Activity en la clase de validaciones.
        campos = loadFields();
        fieldValidations = new FieldValidations(this, campos);

        // Se programa la lógica.
//        TODO: Falta validar los años que sean mayor a n años.
        cFechaDeNacimiento.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                if (day<10) {
                    if (month<9) {
                        fechaDeNacimiento = "0" + day + "/0" + (month+1) + "/" + year;
                    } else {
                        fechaDeNacimiento = "0" + day + "/" + (month+1) + "/" + year;
                    }
                } else {
                    if (month<9) {
                        fechaDeNacimiento = day + "/0" + (month+1) + "/" + year;
                    } else {
                        fechaDeNacimiento = day + "/" + (month+1) + "/" + year;
                    }
                }
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSiguiente.setEnabled(false);
                boolean validate = validateForm();
                if (validate) {
                    getValues();
                    Intent intent = new Intent(DataActivity.this, WelcomeActivity.class);
                    intent.putExtra("name", nombre);
                    intent.putExtra("birthdate", fechaDeNacimiento);
                    intent.putExtra("gender", genero);
                    intent.putExtra("phone", telefono);
                    intent.putExtra("nationality", nacionalidad);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(DataActivity.this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
                }
                btnSiguiente.setEnabled(true);
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearValues();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(DataActivity.this, MainActivity.class));
    }

    private EditText[] loadFields() {
        return new EditText[] {
                acNombre,
                acTelefono
        };
    }

    private boolean validateForm() {
        // Valida todos los campos EditText.
        boolean validate = fieldValidations.areNotEmpty();

        // Validaciones de EditText más específicas.
        if (validate) {
            validate = fieldValidations.isPhoneValid(acTelefono);
        }

        // Valida el RadioGroup género.
        radioButtonId = rgSexo.getCheckedRadioButtonId();
        if ((radioButtonId != R.id.radioButton_hombre_data) &&
                (radioButtonId != R.id.radioButton_mujer_data)) {
            validate = false;
        }

        // Valida el Spinner nacionalidad.
        if (spNacionalidad.getSelectedItemPosition() == 0) {
            validate = false;
        }

        return validate;
    }

    private void getValues() {
        nombre = acNombre.getText().toString();

        View radioButton = rgSexo.findViewById(radioButtonId);
        int indice = rgSexo.indexOfChild(radioButton);
        RadioButton button = (RadioButton) rgSexo.getChildAt(indice);
        genero = button.getText().toString();

        telefono = acTelefono.getText().toString();
        nacionalidad = spNacionalidad.getSelectedItem().toString();
    }

    private void clearValues() {
        acNombre.setText("");
        rbHombre.setChecked(false);
        rbMujer.setChecked(false);
        acTelefono.setText("");
        spNacionalidad.setSelection(0);
    }
}