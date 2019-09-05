package com.ggave.labcal1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText teo1,teo2,lab1,lab2,lab3,lab4;
    private TextView prom1,prom2,prom_total,mensaje;
    private Button calcular;
    private Spinner sistema;
    private Double total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sistema = (Spinner)findViewById(R.id.sistema);

        mensaje = (TextView)findViewById(R.id.message_view);

        teo1 = (EditText)findViewById(R.id.p_teo1);
        teo2 = (EditText)findViewById(R.id.p_teo2);
        lab1 = (EditText)findViewById(R.id.p_lab1);
        lab2 = (EditText)findViewById(R.id.p_lab2);
        lab3 = (EditText)findViewById(R.id.p_lab3);
        lab4 = (EditText)findViewById(R.id.p_lab4);

        calcular =  (Button)findViewById(R.id.calcular);

        prom1 = (TextView)findViewById(R.id.prom_teo);
        prom2 = (TextView)findViewById(R.id.prom_lab);

        prom_total = (TextView)findViewById(R.id.prom_total);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calculo_total();
            }
        });
    }
    public void calculo_total(){
        int pos = sistema.getSelectedItemPosition();
        Double teoria1 = Double.parseDouble(teo1.getText().toString());
        Double teoria2 = Double.parseDouble(teo2.getText().toString());
        Double nota_teoria = (teoria1+teoria2)/2;

        if (teoria1>teoria2){
            prom1.setText("Prom: "+teoria1);
        }else{
            prom1.setText("Prom: "+teoria2);
        }
        Double labo1 = Double.parseDouble(lab1.getText().toString());
        Double labo2 = Double.parseDouble(lab2.getText().toString());
        Double labo3 = Double.parseDouble(lab3.getText().toString());
        Double labo4 = Double.parseDouble(lab4.getText().toString());

        Double nota_lab = (labo1+labo2+labo3+labo4)/4;
        prom2.setText("Prom: "+nota_lab);

        if (pos == 0){
            Double prom_teo1 = nota_teoria*0.3;
            Double prom_lab1 = nota_lab*0.7;
            total = prom_teo1+prom_lab1;
            prom_total.setText("Promedio: "+total);
            if(total>=13){
                mensaje.setText("Aprobado!!!");
            }else{
                mensaje.setText("Desaprobado!!!");
            }

        }else if(pos == 1){
            Double prom_teo1 = nota_teoria*0.4;
            Double prom_lab1 = nota_lab*0.6;
            total = prom_teo1+prom_lab1;
            prom_total.setText("Promedio: "+total);
            if(total>=13){
                mensaje.setText("Aprobado!!!");
            }else{
                mensaje.setText("Desaprobado!!!");
            }
        }else{
            Double prom_teo1 = nota_teoria*0.2;
            Double prom_lab1 = nota_lab*0.8;
            total = prom_teo1 + prom_lab1;
            prom_total.setText("Promedio: "+total);
            if(total>=13){
                mensaje.setText("Aprobado!!!");
            }else{
                mensaje.setText("Desaprobado!!!");
            }
        }
    }
}
