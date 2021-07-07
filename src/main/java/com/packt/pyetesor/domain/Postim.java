package com.packt.pyetesor.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Postim implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;
    private int postimId;
    private int seminarId;
    private String postim;
    private String seminar;
    private String pedagogu;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;
    private int lloji;

    public int getPostimId() {
        return postimId;
    }

    public void setPostimId(int postimId) {
        this.postimId = postimId;
    }

    public String getPostim() {
        return postim;
    }

    public void setPostim(String postim) {
        this.postim = postim;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSeminar() {
        return seminar;
    }

    public void setSeminar(String seminar) {
        this.seminar = seminar;
    }

    public String getPedagogu() {
        return pedagogu;
    }

    public void setPedagogu(String pedagogu) {
        this.pedagogu = pedagogu;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public int getLloji() {
        return lloji;
    }

    public void setLloji(int lloji) {
        this.lloji = lloji;
    }

    public Postim(int postimId, int seminarId, String postim, String seminar, String pedagogu, Date dateCreated, int lloji) {
        this.postimId = postimId;
        this.seminarId = seminarId;
        this.postim = postim;
        this.seminar=seminar;
        this.pedagogu=pedagogu;
        this.dateCreated=dateCreated;
        this.lloji=lloji;
    }

    public Postim() {
        super();
    }
}
