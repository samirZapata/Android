package main.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout code,nom,ap,primo;
    EditText codigo, nombre, apellido, pr;

    TextView cod, vPrimo,vPi;
    Button btnEnviar, btnCalc, btnPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = (TextInputLayout) findViewById(R.id.txtCodigo);
        nom = (TextInputLayout) findViewById(R.id.txtNombre);
        ap = (TextInputLayout) findViewById(R.id.txtApellido);
        primo = (TextInputLayout) findViewById(R.id.txtPrimo);

        codigo = findViewById(R.id.edtCodigo);
        nombre = findViewById(R.id.edtName);
        apellido = findViewById(R.id.edtLasname);
        pr = findViewById(R.id.edtPri);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnPI = findViewById(R.id.btnPI);

        cod = (TextView) findViewById(R.id.viewCodigo);
        vPrimo = findViewById(R.id.vPrimo);
        vPi = findViewById(R.id.vPrimo2);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createData();
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Calculadora.class);
                startActivity(i);
            }
        });

        btnPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

    }


    private void calcular(){
        int n = Integer.parseInt(pr.getText().toString());

        if ((n % 2) == 0){
            vPrimo.setText("Es par");
        }else {
            vPrimo.setText("Es impar");
        }
        //PRIMOS
        if (n == 0 || n == 1 || n == 4){
            vPi.setText("No es primo");
        }

            for (int i = 2; i < n / 2; i++) {
                if (n % i == 0) {
                    vPi.setText("No es primo");
                }else {
                    vPi.setText("Es primo");
                }
            }


    }

    private void createData(){
        String id = String.valueOf(codigo.getText());
        String name = String.valueOf(nombre.getText());
        String lName = String.valueOf(apellido.getText());

        cod.setText(id + " " + name +" " + lName);

    }

}