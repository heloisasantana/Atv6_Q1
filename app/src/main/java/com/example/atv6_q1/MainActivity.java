package com.example.atv6_q1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextAnosInstituicao, editTextSalarioBase;
    private EditText editTextHorasAula, editTextValorHoraAula;
    private TextView textViewSalarioTitular, textViewSalarioHorista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAnosInstituicao = findViewById(R.id.editTextAnosInstituicao);
        editTextSalarioBase = findViewById(R.id.editTextSalarioBase);
        editTextHorasAula = findViewById(R.id.editTextHorasAula);
        editTextValorHoraAula = findViewById(R.id.editTextValorHoraAula);
        textViewSalarioTitular = findViewById(R.id.textViewSalarioTitular);
        textViewSalarioHorista = findViewById(R.id.textViewSalarioHorista);

        Button buttonCalcularSalarioTitular = findViewById(R.id.buttonCalcularSalarioTitular);
        Button buttonCalcularSalarioHorista = findViewById(R.id.buttonCalcularSalarioHorista);

        buttonCalcularSalarioTitular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anosInstituicao = Integer.parseInt(editTextAnosInstituicao.getText().toString());
                double salarioBase = Double.parseDouble(editTextSalarioBase.getText().toString());

                ProfessorTitular titular = new ProfessorTitular("Titular", "123", 40, anosInstituicao, salarioBase);
                double salarioCalculado = titular.calcSalario();

                textViewSalarioTitular.setText("Salário Titular: R$ " + String.format("%.2f", salarioCalculado));
            }
        });

        buttonCalcularSalarioHorista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horasAula = Integer.parseInt(editTextHorasAula.getText().toString());
                double valorHoraAula = Double.parseDouble(editTextValorHoraAula.getText().toString());

                ProfessorHorista horista = new ProfessorHorista("Horista", "456", 30, horasAula, valorHoraAula);
                double salarioCalculado = horista.calcSalario();

                textViewSalarioHorista.setText("Salário Horista: R$ " + String.format("%.2f", salarioCalculado));
            }
        });
    }
}