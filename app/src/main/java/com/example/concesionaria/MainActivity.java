package com.example.concesionaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumeroCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentaje;
    private EditText txtPlazo;

    private Button btnCalcular;
    private Button btnLimpiar;

    private TextView lblNumeroCotizacion;
    private TextView lblDescripcion;
    private TextView lblPrecio;
    private TextView lblPorcentaje;
    private TextView lblPlazo;

    private TextView lblPagoInicial;
    private TextView lblTotalFin;
    private TextView lblPagoMensual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumeroCotizacion = (EditText) findViewById(R.id.txtNumeroCotizacion);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPorcentaje = (EditText) findViewById(R.id.txtPorcentaje);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        lblNumeroCotizacion = (TextView) findViewById(R.id.lblNumeroCotizacion);
        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        lblPorcentaje = (TextView) findViewById(R.id.lblPorcentajeInicial);
        lblPlazo = (TextView) findViewById(R.id.lblPlazo);
        lblPagoInicial = (TextView) findViewById(R.id.lblPagoInicial);
        lblTotalFin = (TextView) findViewById(R.id.lblTotalFin);
        lblPagoMensual = (TextView) findViewById(R.id.lblPagoMensual);

        Concesionaria concesionaria = new Concesionaria();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pagoInicial;
                double pagoMensual;
                double totalFin;

                String numeroCotizacion = txtNumeroCotizacion.getText().toString();
                concesionaria.setNumeroCotizacion(Integer.parseInt(numeroCotizacion));

                String descripcion = txtDescripcion.getText().toString();
                concesionaria.setDescripcionAuto(descripcion);

                String precio = txtPrecio.getText().toString();
                concesionaria.setPrecio(Double.parseDouble(precio));

                String porcentaje = txtPorcentaje.getText().toString();
                concesionaria.setPorcentajeInicial(Double.parseDouble(porcentaje));

                String plazo = txtPlazo.getText().toString();
                concesionaria.setPlazo(Integer.parseInt(plazo));

                pagoInicial = concesionaria.obtenerPagoInicial();

                totalFin = concesionaria.obtenerTotalFin();

                pagoMensual = concesionaria.obtenerPagoMensual();


                //Mostrar datos

                lblNumeroCotizacion.setText("# "+ concesionaria.getNumeroCotizacion());
                lblDescripcion.setText("Descripción del automovil: "+concesionaria.getDescripcionAuto());
                lblPrecio.setText("Precio del auto: "+ concesionaria.getPrecio());
                lblPorcentaje.setText("Porcentaje: " +concesionaria.getPorcentajeInicial()+"%");
                lblPlazo.setText("Plazo: "+ concesionaria.getPlazo());

                lblPagoInicial.setText("Pago incial: "+pagoInicial);
                lblPagoMensual.setText("Pago mensual "+pagoMensual);
                lblTotalFin.setText("Total a financiar: "+totalFin);

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblNumeroCotizacion.setText("");
                lblDescripcion.setText("");
                lblPrecio.setText("");
                lblPorcentaje.setText("");
                lblPlazo.setText("");

                lblPagoInicial.setText("");
                lblPagoMensual.setText("");
                lblTotalFin.setText("");

                txtNumeroCotizacion.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPorcentaje.setText("");
                txtPlazo.setText("");

            }
        });

    }
}