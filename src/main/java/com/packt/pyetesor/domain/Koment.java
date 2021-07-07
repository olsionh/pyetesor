package com.packt.pyetesor.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Koment implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;
    private int komentId;
    private String koment;
    private String username;
    private String emri;
    private String mbiemri;
    private String role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;


    public int getKomentId() {
        return komentId;
    }

    public void setKomentId(int komentId) {
        this.komentId = komentId;
    }

    public String getKoment() {
        return koment;
    }

    public void setKoment(String koment) {
        this.koment = koment;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Koment(int komentId, String koment, String username, String emri, String mbiemri, Date dateCreated, String role) {
        this.komentId = komentId;
        this.koment = koment;
        this.dateCreated=dateCreated;
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.username=username;
        this.role=role;
    }
    public Koment(){
        super();
    }
}
