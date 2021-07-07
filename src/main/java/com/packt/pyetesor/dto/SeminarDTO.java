package com.packt.pyetesor.dto;

import java.util.ArrayList;

import com.packt.pyetesor.domain.*;

public class SeminarDTO {

    public Seminar seminari;
    public ArrayList<Postim> postims;

    public Seminar getSeminari() {
        return seminari;
    }

    public void setSeminari(Seminar seminari) {
        this.seminari = seminari;
    }

    public void setPostims(ArrayList<Postim> postims){
        this.postims=postims;
    }
    public ArrayList<Postim> getPostims(){
        return postims;
    }

    public SeminarDTO(){
        super();
    }
    public SeminarDTO(Seminar seminari,ArrayList<Postim> postims){
        this.seminari=seminari;
        this.postims=postims;

    }
}
