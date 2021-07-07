package com.packt.pyetesor.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Rezultat {

    private String emri;
    private String mbiemri;
    private String kursi;
    private int rezultati;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getKursi() {
        return kursi;
    }

    public void setKursi(String kursi) {
        this.kursi = kursi;
    }

    public int getRezultati() {
        return rezultati;
    }

    public void setRezultati(int rezultati) {
        this.rezultati = rezultati;
    }

    public Rezultat(){};

    public Rezultat(String emri, String mbiemri, String kursi, int rezultati, Date data) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.kursi = kursi;
        this.rezultati = rezultati;
        this.data=data;
    }
}
