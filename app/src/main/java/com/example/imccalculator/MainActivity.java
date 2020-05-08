package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextAltura;
    EditText editTextPeso;
    TextView textViewResult;
    TextView textViewIMCIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura   = findViewById(R.id.editText_altura);
        editTextPeso     = findViewById(R.id.editText_peso);
        textViewResult   = findViewById(R.id.textView_result);
        textViewIMCIndex = findViewById(R.id.textView_imc_index);
    }

    public void calcular(View view) {
        float alturaPessoa = 0;
        float pesoPessoa = 0;
        float result;

        String editTextAlturaContent;
        String editTextPesoContent;

        editTextAlturaContent = editTextAltura.getText().toString();
        editTextPesoContent = editTextPeso.getText().toString();

        if(editTextAlturaContent.isEmpty()) {
            Toast.makeText(this, "Altura vazia.", Toast.LENGTH_LONG).show();

        } else if (editTextPesoContent.isEmpty()) {
            Toast.makeText(this, "Peso vazia.", Toast.LENGTH_LONG).show();
        } else {
            alturaPessoa = Float.parseFloat(editTextAlturaContent);
            pesoPessoa = Float.parseFloat(editTextPesoContent);
            result = (float)(pesoPessoa / Math.pow(alturaPessoa, 2.f));

            if(result < 25) {
                textViewIMCIndex.setText("Bom");
            } else if (result < 30) {
                textViewIMCIndex.setText("Acima");
            } else
                textViewIMCIndex.setText("Cuidado");

            textViewResult.setText(String.valueOf(result));
        }

        hideKeyBoard(view);

    }

    private void hideKeyBoard(View view){
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
