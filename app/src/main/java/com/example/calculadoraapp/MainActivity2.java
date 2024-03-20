package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    String currentExpression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultTv = findViewById(R.id.result_Tv);
        solutionTv = findViewById(R.id.solution_Tv);

        findViewById(R.id.button_c).setOnClickListener(this);
        findViewById(R.id.button_ac).setOnClickListener(this);
        findViewById(R.id.button_open_bracket).setOnClickListener(this);
        findViewById(R.id.button_close_bracket).setOnClickListener(this);
        findViewById(R.id.button_divide).setOnClickListener(this);
        findViewById(R.id.button_multiply).setOnClickListener(this);
        findViewById(R.id.button_plus).setOnClickListener(this);
        findViewById(R.id.button_minus).setOnClickListener(this);
        findViewById(R.id.button_equals).setOnClickListener(this);
        findViewById(R.id.button_0).setOnClickListener(this);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
        findViewById(R.id.button_dot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_c) {
            clearLast();
        } else if (v.getId() == R.id.button_ac) {
            clearAll();
        } else if (v.getId() == R.id.button_equals) {
            calculate();
        } else {
            addToExpression(((TextView) v).getText().toString());
        }
    }

    private void addToExpression(String text) {
        currentExpression += text;
        solutionTv.setText(currentExpression);
    }

    private void clearLast() {
        if (!currentExpression.isEmpty()) {
            currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
            solutionTv.setText(currentExpression);
        }
    }

    private void clearAll() {
        currentExpression = "";
        solutionTv.setText("");
        resultTv.setText("");
    }

    private void calculate() {
        String expression = currentExpression.replaceAll(" ", ""); // Eliminar espacios en blanco

        // Resolver operaciones dentro de paréntesis primero
        while (expression.contains("(")) {
            int startIndex = expression.lastIndexOf("(");
            int endIndex = expression.indexOf(")", startIndex);
            String subExpression = expression.substring(startIndex + 1, endIndex);
            double subResult = evaluate(subExpression);
            expression = expression.substring(0, startIndex) + subResult + expression.substring(endIndex + 1);
        }

        double finalResult = evaluate(expression);
        displayResult(finalResult);
    }

    private double evaluate(String expression) {
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        } else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        } else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        } else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        } else {
            return Double.parseDouble(expression);
        }
    }

    private void displayResult(double result) {
        if (result % 1 == 0) {
            resultTv.setText(String.valueOf((int) result)); // Si es entero, mostrar como entero
        } else {
            resultTv.setText(String.valueOf(result)); // Si no, mostrar como decimal
        }
    }
}


