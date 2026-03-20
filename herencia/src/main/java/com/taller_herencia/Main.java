package com.taller_herencia;

public class Main {
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 12);
        cuentaAhorros.consignar(5000);
        cuentaAhorros.retirar(2000);
        cuentaAhorros.extractoMensual();
        cuentaAhorros.imprimir();

        System.out.println("------------------------");

        CuentaCorriente cuentaCorriente = new CuentaCorriente(5000, 10);
        cuentaCorriente.retirar(7000);
        cuentaCorriente.consignar(3000);
        cuentaCorriente.extractoMensual();
        cuentaCorriente.imprimir();
    }
}