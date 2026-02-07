package com.example.simplecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        Button add = findViewById(R.id.btnAdd);
        Button sub = findViewById(R.id.btnSub);
        Button mul = findViewById(R.id.btnMul);
        Button div = findViewById(R.id.btnDiv);

        add.setOnClickListener(v -> calculate("+"));
        sub.setOnClickListener(v -> calculate("-"));
        mul.setOnClickListener(v -> calculate("*"));
        div.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String op) {
        if (num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());
        double res = 0;

        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = a / b;
                break;
        }

        result.setText("Result: " + res);
    }
}
