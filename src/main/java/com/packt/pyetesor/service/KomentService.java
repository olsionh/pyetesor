package com.packt.pyetesor.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.packt.pyetesor.domain.Koment;
import com.packt.pyetesor.domain.Postim;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.User;

public interface KomentService {

    public ArrayList<Koment> shfaqKomentet(String a);
    public String fshiKoment(String a);
    public String shtoKoment(String a, int userId);
}
