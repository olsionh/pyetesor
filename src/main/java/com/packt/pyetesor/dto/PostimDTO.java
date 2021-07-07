package com.packt.pyetesor.dto;

import java.util.ArrayList;

import com.packt.pyetesor.domain.*;

public class PostimDTO {

    public Postim postimi;
    public ArrayList<Koment> koments;

    public Postim getPostimi() {
        return postimi;
    }

    public void setPostimi(Postim postimi) {
        this.postimi = postimi;
    }

    public ArrayList<Koment> getKoments() {
        return koments;
    }

    public void setKoments(ArrayList<Koment> koments) {
        this.koments = koments;
    }

    public PostimDTO(Postim postimi, ArrayList<Koment> koments) {
        this.postimi = postimi;
        this.koments = koments;
    }
}


