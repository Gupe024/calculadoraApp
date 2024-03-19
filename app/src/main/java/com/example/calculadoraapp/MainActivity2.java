package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    TextView resultTv, solutionTv;
    MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
    MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        resultTv=findViewById(R.id.result_Tv);
        solutionTv=findViewById(R.id.solution_Tv);

        assingId(buttonC,R.id.button_c);
        assingId(buttonBrackOpen,R.id.button_open_bracket);
        assingId(buttonBrackClose,R.id.button_close_bracket);
        assingId(buttonDivide,R.id.button_divide);
        assingId(buttonMultiply,R.id.button_multiply);
        assingId(buttonPlus,R.id.button_plus);
        assingId(buttonMinus,R.id.button_minus);
        assingId(buttonEquals,R.id.button_equals);
        assingId(button0,R.id.button_0);
        assingId(button1,R.id.button_1);
        assingId(button2,R.id.button_2);
        assingId(button3,R.id.button_3);
        assingId(button4,R.id.button_4);
        assingId(button5,R.id.button_5);
        assingId(button6,R.id.button_6);
        assingId(button7,R.id.button_7);
        assingId(button8,R.id.button_8);
        assingId(button9,R.id.button_9);
        assingId(buttonAC,R.id.button_ac);
        assingId(buttonDot,R.id.button_dot);

    }

    void assingId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        MaterialButton button=(MaterialButton) v;
        String buttonText = button.getText().toString();
        String dataCalculate = solutionTv.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("C")){
            dataCalculate = dataCalculate.substring(0,dataCalculate.length()-1);
        }else{
            dataCalculate = dataCalculate+buttonText;
        }
        solutionTv.setText(dataCalculate);

    }

    String getResult(String data){
        return "calculated";
    }
}