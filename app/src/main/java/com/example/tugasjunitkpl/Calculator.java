package com.example.tugasjunitkpl;
public class Calculator {
    public static final int OPERATION_ADD = 0;
    public static final int OPERATION_SUBTRACT = 1;
    public static final int OPERATION_MULTIPLY = 2;
    public static final int OPERATION_DIVIDE = 3;

    /**
     * Menjumlahkan dua angka
     * @param a angka pertama
     * @param b angka kedua
     * @return hasil penjumlahan a + b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Mengurangkan dua angka
     * @param a angka pertama
     * @param b angka kedua
     * @return hasil pengurangan a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Mengalikan dua angka
     * @param a angka pertama
     * @param b angka kedua
     * @return hasil perkalian a * b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Membagi dua angka
     * @param a angka pembilang
     * @param b angka penyebut
     * @return hasil pembagian a / b
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Tidak dapat dibagi dengan nol");
        }
        return a / b;
    }
}