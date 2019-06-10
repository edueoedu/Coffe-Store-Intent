package com.example.coffestore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import org.w3c.dom.Text;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {
    public int TlCoffe;
    public double valorC;
    public double totalCafe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TlCoffe = 0;
        valorC = 0;
        totalCafe = 0;


    }


    @SuppressLint("WrongConstant")
    public void SelecionarCafe(View view) {

        RadioButton ex = (RadioButton) findViewById(R.id.c1);
        RadioButton ca = (RadioButton) findViewById(R.id.c2);
        RadioButton mo = (RadioButton) findViewById(R.id.c3);
        Button button = findViewById(R.id.Go);



            if(ex.isChecked()){
              valorC = 3;
            }
            if(ca.isChecked()){
                valorC = 5;
            }
            if(mo.isChecked()){
                valorC = 6;
            }


        TextView o = (TextView) findViewById(R.id.Uni);
        o.setText(Double.toString(valorC));

        Button bt = (Button) view;
        String Texto = bt.getText().toString();
        if(Texto.equalsIgnoreCase("-")){
             if(TlCoffe > 0){
                 TlCoffe = TlCoffe - 1;
             }
        }else{

            TlCoffe = TlCoffe + 1;

        }

        totalCafe = TlCoffe * valorC;

        TextView tot = (TextView) findViewById(R.id.quant);
        tot.setText(Integer.toString(TlCoffe));

        TextView tv = (TextView) findViewById(R.id.Total);
        tv.setText(Double.toString(totalCafe));

        if(TlCoffe == 0){
            TextView g = (TextView) findViewById(R.id.text);
            g.setText(" ");
        }else if(TlCoffe == 1) {
            TextView g = (TextView) findViewById(R.id.text);
            g.setText("Gostaria de " + Integer.toString(TlCoffe) + " café, por favor. O valor total será R$ " + Double.toString(totalCafe) + ".Obrigado!");
        }else{
            TextView g = (TextView) findViewById(R.id.text);
            g.setText("Gostaria de " + Integer.toString(TlCoffe) + " cafés, por favor. O valor total será R$ " + Double.toString(totalCafe) + ".Obrigado!");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("*/*");
                sendEmail.putExtra(Intent.EXTRA_EMAIL,"cafe.do.ifc.concordia@gmail.com");
                sendEmail.putExtra(Intent.EXTRA_TEXT,"Gostaria de \" + Integer.toString(TlCoffe) + \" cafés, por favor. O valor total será R$ \" + Double.toString(totalCafe) + \".Obrigado!");
                sendEmail.putExtra(Intent.EXTRA_SUBJECT,"Café");

                if(sendEmail.resolveActivity(getPackageManager())   != null){
                    startActivity(sendEmail);
                    //alteração
                    Log.i("OnClick", "Enviei o intent!");
                }

                Log.i("OnClick", "Botão Pressionado!");


            }
        });
        //Toast.makeText(this,Texto, 1).show();


    }

}
