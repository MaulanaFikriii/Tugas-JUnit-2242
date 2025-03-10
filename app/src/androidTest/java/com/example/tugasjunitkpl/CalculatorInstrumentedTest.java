package com.example.tugasjunitkpl;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumental test untuk aplikasi Kalkulator Sederhana
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test Case 1: Pengujian Context
     * Memastikan bahwa context aplikasi sesuai dengan yang diharapkan
     * Ini memverifikasi bahwa lingkungan pengujian telah diatur dengan benar
     */
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.tugasjunitkpl", appContext.getPackageName());
    }

    /**
     * Test Case 2: Pengujian Operasi Penjumlahan di UI
     * Menguji fungsionalitas UI untuk operasi penjumlahan:
     * - Memasukkan dua angka ke dalam input fields
     * - Menekan tombol tambah (+)
     * - Memverifikasi bahwa hasil yang ditampilkan sesuai dengan yang diharapkan
     * Ini memastikan bahwa integrasi antara UI dan logika bisnis berjalan dengan benar
     */
    @Test
    public void additionUI_isCorrect() {
        // Masukkan angka pertama
        onView(withId(R.id.etFirstNumber))
                .perform(typeText("5"), closeSoftKeyboard());

        // Masukkan angka kedua
        onView(withId(R.id.etSecondNumber))
                .perform(typeText("3"), closeSoftKeyboard());

        // Klik tombol tambah
        onView(withId(R.id.btnAdd)).perform(click());

        // Verifikasi hasil
        onView(withId(R.id.tvResult)).check(matches(withText("8.0")));
    }

    /**
     * Test Case 3: Pengujian Operasi Pembagian di UI
     * Menguji fungsionalitas UI untuk operasi pembagian:
     * - Memasukkan dua angka ke dalam input fields
     * - Menekan tombol bagi (÷)
     * - Memverifikasi bahwa hasil yang ditampilkan sesuai dengan yang diharapkan
     * Ini memastikan bahwa operasi pembagian berfungsi dengan benar pada UI
     */
    @Test
    public void divisionUI_isCorrect() {
        // Masukkan angka pertama
        onView(withId(R.id.etFirstNumber))
                .perform(typeText("10"), closeSoftKeyboard());

        // Masukkan angka kedua
        onView(withId(R.id.etSecondNumber))
                .perform(typeText("2"), closeSoftKeyboard());

        // Klik tombol bagi
        onView(withId(R.id.btnDivide)).perform(click());

        // Verifikasi hasil
        onView(withId(R.id.tvResult)).check(matches(withText("5.0")));
    }

    /**
     * Test Case 4: Pengujian Validasi Pembagian dengan Nol
     * Menguji penanganan kesalahan untuk pembagian dengan nol:
     * - Memasukkan angka pertama dan angka kedua (nol) ke dalam input fields
     * - Menekan tombol bagi (÷)
     * - Memverifikasi bahwa pesan error yang sesuai ditampilkan
     * Ini memastikan bahwa aplikasi menangani kasus khusus dengan benar
     */
    @Test
    public void divisionByZeroUI_showsError() {
        // Masukkan angka pertama
        onView(withId(R.id.etFirstNumber))
                .perform(typeText("10"), closeSoftKeyboard());

        // Masukkan nol sebagai angka kedua
        onView(withId(R.id.etSecondNumber))
                .perform(typeText("0"), closeSoftKeyboard());

        // Klik tombol bagi
        onView(withId(R.id.btnDivide)).perform(click());

        // Verifikasi pesan error
        onView(withId(R.id.tvResult)).check(matches(withText("Tidak bisa dibagi dengan nol")));
    }
}
