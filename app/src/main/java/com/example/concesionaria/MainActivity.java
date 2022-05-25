package com.example.concesionaria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumeroCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentaje;
    private EditText txtPlazo;

    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnCerrar;

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
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        lblNumeroCotizacion = (TextView) findViewById(R.id.lblNumeroCotizacion);
        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        lblPorcentaje = (TextView) findViewById(R.id.lblPorcentajeInicial);
        lblPlazo = (TextView) findViewById(R.id.lblPlazo);
        lblPagoInicial = (TextView) findViewById(R.id.lblPagoInicial);
        lblTotalFin = (TextView) findViewById(R.id.lblTotalFin);
        lblPagoMensual = (TextView) findViewById(R.id.lblPagoMensual);

        Cotizacion concesionaria = new Cotizacion();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pagoInicial;
                double pagoMensual;
                double totalFin;

                if(txtNumeroCotizacion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dalto faltante: Numero de Cotizacion",Toast.LENGTH_SHORT).show();
                }
                else if(txtDescripcion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dalto faltante: Descripcion del automovil",Toast.LENGTH_SHORT).show();
                }
                else if(txtPrecio.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dalto faltante: Precio",Toast.LENGTH_SHORT).show();
                }
                else if(txtPorcentaje.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dalto faltante: Porcentaje",Toast.LENGTH_SHORT).show();
                }
                else if(txtPlazo.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dalto faltante: Plazo",Toast.LENGTH_SHORT).show();
                }
                else{
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

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar APP?");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                confirmar.show();
            }
        });

    }
}