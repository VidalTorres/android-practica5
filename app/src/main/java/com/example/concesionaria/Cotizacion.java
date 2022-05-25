package com.example.concesionaria;

public class Cotizacion {
    //Variables
    private int numeroCotizacion;
    private String descripcionAuto;
    private double precio;
    private double porcentajeInicial;
    private int plazo;

    //Constructores
    Cotizacion(){
        this.numeroCotizacion = 0;
        this.descripcionAuto = "";
        this.precio = 0.0;
        this.porcentajeInicial = 0.0;
        this.plazo = 0;
    }

    Cotizacion(int numeroCotizacion, String descripcionAuto, double precio, double porcentajeInicial, int plazo){
        this.numeroCotizacion = numeroCotizacion;
        this.descripcionAuto = descripcionAuto;
        this.precio = precio;
        this.porcentajeInicial = porcentajeInicial;
        this.plazo = plazo;
    }

    Cotizacion(Cotizacion cotizacion){
        this.numeroCotizacion = cotizacion.numeroCotizacion;
        this.descripcionAuto = cotizacion.descripcionAuto;
        this.precio = cotizacion.precio;
        this.porcentajeInicial = cotizacion.porcentajeInicial;
        this.plazo = cotizacion.plazo;
    }

    //Encapsulamiento

    /**
     * @return the numeroCotizacion
     */
    public int getNumeroCotizacion() {
        return numeroCotizacion;
    }

    /**
     * @param numeroCotizacion the numeroCotizacion to set
     */
    public void setNumeroCotizacion(int numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    /**
     * @return the descripcionAuto
     */
    public String getDescripcionAuto() {
        return descripcionAuto;
    }

    /**
     * @param descripcionAuto the descripcionAuto to set
     */
    public void setDescripcionAuto(String descripcionAuto) {
        this.descripcionAuto = descripcionAuto;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the porcentajeInicial
     */
    public double getPorcentajeInicial() {
        return porcentajeInicial;
    }

    /**
     * @param porcentajeInicial the porcentajeInicial to set
     */
    public void setPorcentajeInicial(double porcentajeInicial) {
        this.porcentajeInicial = porcentajeInicial;
    }

    /**
     * @return the plazo
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    //Funciones

    public double obtenerPagoInicial(){
        double pagoInicial;
        pagoInicial = precio * (porcentajeInicial/100);
        return  pagoInicial;
    }

    public double obtenerTotalFin(){
        double totalFin;
        totalFin = precio - obtenerPagoInicial();
        return totalFin;
    }

    public double obtenerPagoMensual(){
        double pagoMensual;
        pagoMensual = obtenerTotalFin()/plazo;
        return pagoMensual;
    }

}

