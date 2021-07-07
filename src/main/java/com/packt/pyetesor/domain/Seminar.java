package com.packt.pyetesor.domain;

import java.io.Serializable;

public class Seminar implements Serializable {


    private static final long serialVersionUID = 3678107792576131001L;
    private int seminarId;
    private String seminar;
    private String pedagogu;
    private String sesioni;

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
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

    public String getSesioni() {
        return sesioni;
    }

    public void setSesioni(String sesioni) {
        this.sesioni = sesioni;
    }

    public Seminar(int seminarId, String seminar, String pedagogu, String sesioni)
    {
        this.seminarId=seminarId;
        this.seminar=seminar;
        this.pedagogu=pedagogu;
        this.sesioni=sesioni;
    }

    public Seminar()
    {
        super();
    }
}
