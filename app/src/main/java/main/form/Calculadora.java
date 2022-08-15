package main.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Calculadora extends AppCompatActivity {

    TextInputLayout producto, pUnitario,cantidad,recibido;
    TextInputLayout primo;
    EditText prim,nom,pre,can,give;
    TextView vPrimo,vPrimo2, vDescription,vRate,vQty,vSub, vsub2,vTotal, vCambio;
    Button btnFacturar, btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        /*****************DATOS QUE INGRESA******************/
        producto = (TextInputLayout) findViewById(R.id.txtProducto); //CONTAINER
        pUnitario = (TextInputLayout) findViewById(R.id.txtPrice);  //CONTAINER
        cantidad = (TextInputLayout) findViewById(R.id.txtCantidad);//CONTAINER
        recibido = (TextInputLayout) findViewById(R.id.txtRecibido);//CONTAINER

        prim = findViewById(R.id.edtPri);  //NUMS INPUT
        nom = findViewById(R.id.edtName); //NAME INPUT
        pre = findViewById(R.id.edtPr);   //PRECIO INPUT
        can = findViewById(R.id.edtCant); //QTY INPUT
        give = findViewById(R.id.edtGive);//CAMBIO INPUT

        /*****************************************************/

        /*****************CALCULO******************/
        primo = (TextInputLayout) findViewById(R.id.txtPrimo);
        //vPrimo = (TextView) findViewById(R.id.viewPrimo);
        //vPrimo2 = findViewById(R.id.viewPrimo2);
        /******************************************/

        /*****************DATOS QUE SE MUESTRAN******************/
        vDescription = (TextView) findViewById(R.id.viewDes);
        vRate = (TextView) findViewById(R.id.viewRate);
        vQty = (TextView) findViewById(R.id.viewQTY);
        vsub2 = (TextView) findViewById(R.id.viewSub2);
        vSub = (TextView) findViewById(R.id.viewSub);
        vTotal = (TextView) findViewById(R.id.viewTotal);
        vCambio = (TextView) findViewById(R.id.viewCambio);
        /*****************************************************/

        btnFacturar = (Button) findViewById(R.id.btnFacturar);
        btnCalcular = (Button) findViewById(R.id.btnCalc);

        /*FACTURAR*/
        btnFacturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facturar();
            }
        });

        /*CALCULAR
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }

        });*/


    }

    /*
    private void calcular(){
        int number = Integer.parseInt(prim.getText().toString());

        if ((number % 2) == 0){
            vPrimo.setText("Es par");
        }else {
            vPrimo.setText("Es impar");
        }
        //Comprueba si n es multiplo de 2
        if (number%2==0){
            vPrimo2.setText("No es primo");
        }
        //SINO REVISAMOS IMPARES
        for (int i=3; i*i<=number;i+=2){
            if (number%i==0){
                vPrimo2.setText("No es primo");
            }else{
                vPrimo2.setText("Es primo");
            }
        }

    }*/

    private void facturar(){
        try {
            String prod = nom.getText().toString();
            int pUnit = Integer.parseInt(pre.getText().toString());
            int cant = Integer.parseInt(can.getText().toString());
            int recib = Integer.parseInt(give.getText().toString());
            //int rate = Integer.parseInt(vRate.getText().toString());

            vDescription.setText(prod);
            vRate.setText("$ "+pUnit);
            vQty.setText(String.valueOf(cant));
            int subt = Integer.parseInt(String.valueOf(cant*pUnit));
            vSub.setText("$ "+subt);
            vsub2.setText("$ "+recib);
            int chang = Integer.parseInt(String.valueOf((recib-subt)));
            String total = String.valueOf(subt);
            vTotal.setText("$ "+total);

            vCambio.setText("$ "+chang);
        }catch (Exception e){
            Log.d("j",e.getLocalizedMessage());
        }

    }

}