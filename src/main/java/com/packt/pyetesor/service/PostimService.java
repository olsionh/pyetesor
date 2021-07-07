package com.packt.pyetesor.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.packt.pyetesor.domain.Postim;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.dto.PostimDTO;

public interface PostimService {


    public ArrayList<Postim> postimeteMia(int userId);
    public void fshiPostim(int postimId);
    public ArrayList<Seminar> merrSeminarin(int postimId);
    public ArrayList<PostimDTO> listAllPostsPerUser(int idUseri);
    public ArrayList<PostimDTO> listAllPostsPerSeminar(int idSeminari);
    public String shtoPostim(String a);
    public String fshiPostim(String a);

}
