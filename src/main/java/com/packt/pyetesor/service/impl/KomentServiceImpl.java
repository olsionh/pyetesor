package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.packt.pyetesor.domain.*;
import com.packt.pyetesor.service.KomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.dto.TestDTO;
import com.packt.pyetesor.service.TestService;

@Service
public class KomentServiceImpl implements KomentService {
    @Autowired
    private Database databaz;


    public ArrayList<Koment> shfaqKomentet(String a){
        Connection c = null;
        String sql1 = "";
        ArrayList<Koment> komentet = new ArrayList<Koment>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Postim obj = mapper.readValue(a, Postim.class);
            c = databaz.estamblishConnection();

            sql1="SELECT * FROM users, koment WHERE postimId_FK='"+obj.getPostimId()+"' AND users.userId=koment.userId_FK" ;


            System.out.println(sql1);
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();

            while (result1.next()){
                komentet.add(new Koment(result1.getInt("komentId"),result1.getString("koment"), result1.getString("username"), result1.getString("firstName"), result1.getString("lastName"),result1.getDate("dateCreated"), result1.getString("role")));
            }


        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        return komentet;
    }

    public String fshiKoment(String a){
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Koment obj = mapper.readValue(a, Koment.class);
            c = databaz.estamblishConnection();
            String sql1="DELETE FROM koment WHERE komentId ='"+obj.getKomentId()+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            pstmt1.executeUpdate();
            databaz.closeConnection(c);
            return "ok";

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String shtoKoment(String a, int userId){
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Koment obj = mapper.readValue(a, Koment.class);
            c = databaz.estamblishConnection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            System.out.println(formatted); //2016/11/16 12:08:43
            String sql1="INSERT INTO koment(koment,dateCreated,postimId_FK,userId_FK) VALUES('"+obj.getKoment()+"','"+formatted+"','"+obj.getKomentId()+"','"+userId+"')";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            pstmt1.executeUpdate();
            databaz.closeConnection(c);
            return "ok";

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}