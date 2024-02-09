package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Proceso, Resultado;
    MaterialButton buttonAC, buttonFactorial, buttonOtro, buttonDividir, buttonMultiplicar,
            buttonRestar, buttonSumar, buttonIgual, buttonPunto;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resultado = findViewById(R.id.tResultado);
        Proceso = findViewById((R.id.tProceso));

        asignarId(button0, R.id.btcero);
        asignarId(button1, R.id.btuno);
        asignarId(button2, R.id.btdos);
        asignarId(button3, R.id.bttres);
        asignarId(button4, R.id.btcuatro);
        asignarId(button5, R.id.btcinco);
        asignarId(button6, R.id.btseis);
        asignarId(button7, R.id.btsiete);
        asignarId(button8, R.id.btocho);
        asignarId(button9, R.id.btnueve);
        asignarId(buttonFactorial, R.id.btfactorial);
        asignarId(buttonOtro, R.id.btfibo);
        asignarId(buttonSumar, R.id.btsuma);
        asignarId(buttonRestar, R.id.btresta);
        asignarId(buttonMultiplicar, R.id.btmulti);
        asignarId(buttonDividir, R.id.btdivicion);
        asignarId(buttonPunto, R.id.btpunto);
        asignarId(buttonIgual, R.id.btresultado);
        asignarId(buttonAC, R.id.btAC);


    }

    void asignarId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = Proceso.getText().toString();

        if (buttonText.equals("AC")) {
            Resultado.setText("");
            Proceso.setText("");

            return;
        }

        if (buttonText.equals("=")) {
            Proceso.setText(Resultado.getText());
            return;
        }

        if (buttonText.equals("!")) {
            String Numero = Proceso.getText().toString();
            int numero = Integer.parseInt(Numero);

            int Factorial = calcularfactorial(numero);

            Resultado.setText(Factorial + "");
            Proceso.setText(Numero + "!");
            return;
        }

        if (buttonText.equals("Φ")) {
            String Numero = Proceso.getText().toString();
            int numero = Integer.parseInt(Numero);

            int Fibonaci = calcularfibonaci(numero);

            Resultado.setText(Fibonaci + "");
            Proceso.setText(Numero + "Φ");
            return;
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }

        Proceso.setText(dataToCalculate);

        Calculadora calculadora = new Calculadora();
        String finalResult = calculadora.getResult(dataToCalculate);

        if (!finalResult.equals("Error")) {
            Resultado.setText(finalResult);
        }
    }

    static int calcularfibonaci(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            int fiboAnterior = 0;
            int fiboActual = 1;
            int resultado = 0;

            for (int i = 2; i <= numero; i++) {
                resultado = fiboAnterior + fiboActual;
                fiboAnterior = fiboActual;
                fiboActual = resultado;
            }
            return resultado;
        }
    }

    static int calcularfactorial(int numero) {
        if (numero == 1 || numero == 0) {
            return 1;
        } else {
            int factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    public static class Calculadora {
        String getResult(String data) {

            try {
                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initStandardObjects();
                String finalResult = context.evaluateString(scriptable, data, "JavaScript", 1, null).toString();
                if (finalResult.endsWith(".0")) {
                    finalResult = finalResult.replace(".0", "");
                }
                return finalResult;
            } catch (Exception e) {
                return "Error";
            }
        }
    }
}
