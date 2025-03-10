package com.example.tugasjunitkpl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test lokal untuk kelas Calculator
 */
public class CalculatorUnitTest {

    /**
     * Test Case 1: Pengujian operasi penjumlahan
     * Menguji fungsi add() dengan berbagai input untuk memastikan:
     * - Penjumlahan dua bilangan positif berfungsi dengan benar
     * - Penjumlahan dengan angka nol menghasilkan nilai yang benar
     * - Penjumlahan dengan bilangan negatif berfungsi dengan benar
     */
    @Test
    public void addition_isCorrect() {
        Calculator calculator = new Calculator();

        // Test penjumlahan dasar
        assertEquals(4.0, calculator.add(2.0, 2.0), 0.001);

        // Test penjumlahan dengan nol
        assertEquals(5.0, calculator.add(5.0, 0.0), 0.001);

        // Test penjumlahan dengan bilangan negatif
        assertEquals(-3.0, calculator.add(2.0, -5.0), 0.001);

        // Test penjumlahan bilangan desimal
        assertEquals(5.5, calculator.add(2.5, 3.0), 0.001);
    }

    /**
     * Test Case 2: Pengujian operasi pembagian
     * Menguji fungsi divide() untuk memastikan:
     * - Pembagian normal berfungsi dengan benar
     * - Pembagian dengan angka negatif menghasilkan nilai yang benar
     * - Pembagian dengan nol melempar exception yang sesuai
     * - Presisi pembagian akurat untuk bilangan desimal
     */
    @Test
    public void division_isCorrect() {
        Calculator calculator = new Calculator();

        // Test pembagian dasar
        assertEquals(2.0, calculator.divide(4.0, 2.0), 0.001);

        // Test pembagian dengan bilangan negatif
        assertEquals(-2.0, calculator.divide(4.0, -2.0), 0.001);

        // Test pembagian dengan bilangan desimal
        assertEquals(2.5, calculator.divide(5.0, 2.0), 0.001);

        // Test pembagian dengan nol sebagai pembilang
        assertEquals(0.0, calculator.divide(0.0, 5.0), 0.001);

        // Test pembagian dengan nol sebagai penyebut harus melempar exception
        try {
            calculator.divide(5.0, 0.0);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Tidak dapat dibagi dengan nol", e.getMessage());
        }
    }
}