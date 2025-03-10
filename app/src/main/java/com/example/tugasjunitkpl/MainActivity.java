package com.example.tugasjunitkpl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etFirstNumber, etSecondNumber;
    private TextView tvResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Inisialisasi kalkulator
        calculator = new Calculator();

        // Set listener untuk operasi penjumlahan
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Calculator.OPERATION_ADD);
            }
        });

        // Set listener untuk operasi pengurangan
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Calculator.OPERATION_SUBTRACT);
            }
        });

        // Set listener untuk operasi perkalian
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Calculator.OPERATION_MULTIPLY);
            }
        });

        // Set listener untuk operasi pembagian
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Calculator.OPERATION_DIVIDE);
            }
        });
    }

    private void calculate(int operation) {
        String firstNumberStr = etFirstNumber.getText().toString();
        String secondNumberStr = etSecondNumber.getText().toString();

        // Validasi input
        if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
            tvResult.setText("Masukkan dua angka");
            return;
        }

        try {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = 0;

            switch (operation) {
                case Calculator.OPERATION_ADD:
                    result = calculator.add(firstNumber, secondNumber);
                    break;
                case Calculator.OPERATION_SUBTRACT:
                    result = calculator.subtract(firstNumber, secondNumber);
                    break;
                case Calculator.OPERATION_MULTIPLY:
                    result = calculator.multiply(firstNumber, secondNumber);
                    break;
                case Calculator.OPERATION_DIVIDE:
                    if (secondNumber == 0) {
                        tvResult.setText("Tidak bisa dibagi dengan nol");
                        return;
                    }
                    result = calculator.divide(firstNumber, secondNumber);
                    break;
            }

            // Tampilkan hasil
            tvResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            tvResult.setText("Input tidak valid");
        }
    }
}