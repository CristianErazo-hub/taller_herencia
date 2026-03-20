package com.taller_herencia;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        actualizarEstado();
        if (activa) {
            super.consignar(cantidad);
        } else {
            throw new IllegalStateException("La cuenta de ahorros está inactiva y no permite consignaciones.");
        }
        actualizarEstado();
    }

    @Override
    public void retirar(float cantidad) {
        actualizarEstado();
        if (activa) {
            super.retirar(cantidad);
        } else {
            throw new IllegalStateException("La cuenta de ahorros está inactiva y no permite retiros.");
        }
        actualizarEstado();
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        actualizarEstado();
    }

    public void imprimir() {
        System.out.println("Cuenta de ahorros");
        super.imprimir();
        System.out.println("Activa = " + activa);
    }

    private void actualizarEstado() {
        activa = saldo >= 10000;
    }
}