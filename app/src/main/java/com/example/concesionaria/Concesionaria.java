package com.example.concesionaria;

public class Concesionaria {
    //Variables
    private int numeroCotizacion;
    private String descripcionAuto;
    private double precio;
    private double porcentajeInicial;
    private int plazo;

    private double pagoInicial;
    private double totalFin;
    private double pagoMensual;

    //Constructores
    Concesionaria(){
        this.numeroCotizacion = 0;
        this.descripcionAuto = "";
        this.precio = 0.0;
        this.porcentajeInicial = 0.0;
        this.plazo = 0;
    }

    Concesionaria(int numeroCotizacion, String descripcionAuto, double precio, double porcentajeInicial, int plazo){
        this.numeroCotizacion = numeroCotizacion;
        this.descripcionAuto = descripcionAuto;
        this.precio = precio;
        this.porcentajeInicial = porcentajeInicial;
        this.plazo = plazo;
    }

    Concesionaria(Concesionaria cotizacion){
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

    //funciones

    public double obtenerPagoInicial(){
        pagoInicial = precio * (porcentajeInicial/100);
        return  pagoInicial;
    }

    public double obtenerTotalFin(){
        totalFin = precio - pagoInicial;
        return totalFin;
    }

    public double obtenerPagoMensual(){
        pagoMensual = totalFin/plazo;
        return pagoMensual;
    }

}

