package com.taller_herencia;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar tiene que ser mayor que cero.");
        }

        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            float faltante = cantidad - saldo;
            if (saldo > 0) {
                super.retirar(saldo);
            }
            sobregiro += faltante;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a consignar tiene que ser mayor que cero.");
        }

        numeroConsignaciones++;

        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                float restante = cantidad - sobregiro;
                sobregiro = 0;
                saldo += restante;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            saldo += cantidad;
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Cuenta corriente");
        super.imprimir();
        System.out.println("Sobregiro = " + sobregiro);
    }
}