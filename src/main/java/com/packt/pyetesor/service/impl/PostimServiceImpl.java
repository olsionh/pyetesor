package com.packt.pyetesor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.*;
import com.packt.pyetesor.dto.PostimDTO;
import com.packt.pyetesor.dto.SeminarDTO;
import com.packt.pyetesor.service.PostimService;
import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PostimServiceImpl implements PostimService {
    @Autowired
    private Database databaz;

    private List<Seminar> listaime;

   public List<Postim> shfaqPostimetSeminar(int seminarId)
   {return new ArrayList<Postim>(); };
   /*{
        Connection c = null;
        int semId, kodi;
        String sem, ped, ses;
        List<Seminar> seminaret = new ArrayList<Seminar>();
        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM seminar";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            while (result.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                semId=result.getInt(1);
                sem=result.getString(2);
                ped=result.getString(3);
                ses=result.getString(4);
                seminaret.add(new Seminar(semId, sem, ped, ses));
                System.out.println("U hodh nje seminar");
            }
        } catch (Exception e) {
            System.out.println("Te dhenat nuk u hodhen!");

        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println("Databaza nuk u mbyll");

        }

        return seminaret;

    }
*/

    public ArrayList<Seminar> merrSeminarin(int postimId)
    {
        Connection c = null;
        ArrayList<Seminar> seminars = new ArrayList<>();
        try
        {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT seminarId_FK FROM postim WHERE userId_FK ='"+postimId+"'";
            PreparedStatement pstm1 = c.prepareStatement(sql1);
            ResultSet result = pstm1.executeQuery();
            result.next();
            String seminarIdFK = result.getString("seminarId_FK");
            String sql2 = "SELECT * FROM seminar WHERE seminarId ='"+seminarIdFK+"'";
            PreparedStatement pstm2 = c.prepareStatement(sql2);
            ResultSet result2 = pstm2.executeQuery();
            seminars.add(new Seminar(result2.getInt("seminarId"), result2.getString("seminar"), result2.getString("pedagogu"), result2.getString("sesioni")));
        }
        catch (Exception e)
        {
            return null;
        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println("Gabim ne mbylljen e db");
            return null;
        }

        return seminars;
    }
    public ArrayList<Postim> postimeteMia(int userId){
        Connection c = null;
        ArrayList<Postim> postimeteMia = new ArrayList<Postim>();
        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM seminar, postim, userseminar WHERE userseminar.userId_FK ='"+userId+"' AND postim.seminarId_FK=userseminar.seminarId_FK AND seminar.seminarId=postim.seminarId_FK ORDER BY postim.dateCreated DESC";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result2 = pstmt1.executeQuery();

            while (result2.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                /*sql1 = "SELECT * FROM postim WHERE seminarId_FK='"+result.getInt("seminarId_FK")+"' ORDER BY dateCreated DESC";
                pstmt1 = c.prepareStatement(sql1);
                ResultSet result2 = pstmt1.executeQuery();
                System.out.println("Para next-it");
                while (result2.next()) */
                postimeteMia.add(new Postim(result2.getInt("postimId"), result2.getInt("seminarId"), result2.getString("postim"), result2.getString("seminar"), result2.getString("pedagogu"),result2.getDate("dateCreated"), result2.getInt("lloji")));
                System.out.println("Tani pas next-it");
            }
        } catch (Exception e) {
            System.out.println("Nje gabim ka ndodhur");
            return null;
        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println("Gabim ne mbylljen e db");
            return null;
        }
        return postimeteMia;
    }

    public void fshiPostim(int postimId) {

    }

    public ArrayList<PostimDTO> listAllPostsPerUser(int idUseri){
        Connection c = null;
        ArrayList<Postim> postimet = new ArrayList<Postim>();
        ArrayList<Koment> komentet;
        ArrayList<PostimDTO> postimDto = new ArrayList<PostimDTO>();

        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM userseminar, seminar, postim WHERE userseminar.userId_FK ='"+idUseri+"' AND userseminar.seminarId_FK=seminar.seminarId AND seminar.seminarId=postim.seminarId_FK ";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();

            while (result1.next()) {
                postimet.add(new Postim(result1.getInt("postimId"), result1.getInt("seminarId"), result1.getString("postim"), result1.getString("seminar"), result1.getString("pedagogu"), result1.getDate("dateCreated"), result1.getInt("lloji")));
            }

            for(Postim postim: postimet) {
                String sql2="SELECT * FROM users, koment WHERE postimId_FK ='"+postim.getPostimId()+"' AND users.userId=koment.userId_FK" ;
                PreparedStatement pstmt2 = c.prepareStatement(sql2);
                ResultSet result2 = pstmt2.executeQuery();
                komentet = new ArrayList<>();
                while(result2.next()) {
                    komentet.add(new Koment(result2.getInt("komentId"), result2.getString("koment"), result2.getString("username"), result2.getString("firstName"), result2.getString("lastName"), result2.getDate("dateCreated"), result2.getString("role")));
                }

                postimDto.add(new PostimDTO(new Postim(postim.getPostimId(), postim.getSeminarId(), postim.getPostim(), postim.getSeminar(), postim.getPedagogu(), postim.getDateCreated(), postim.getLloji()), komentet));
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        databaz.closeConnection(c);
        return postimDto;
    }

    public ArrayList<PostimDTO> listAllPostsPerSeminar(int idSeminari){
        Connection c = null;
        ArrayList<Postim> postimet = new ArrayList<Postim>();
        ArrayList<Koment> komentet;
        ArrayList<PostimDTO> postimDto = new ArrayList<PostimDTO>();

        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM postim, seminar WHERE postim.seminarId_FK ='"+idSeminari+"' AND postim.seminarId_FK=seminar.seminarId";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();

            while (result1.next()) {
                postimet.add(new Postim(result1.getInt("postimId"), result1.getInt("seminarId"), result1.getString("postim"), result1.getString("seminar"), result1.getString("pedagogu"), result1.getDate("dateCreated"), result1.getInt("lloji")));
            }

            for(Postim postim: postimet) {
                String sql2="SELECT * FROM users, koment WHERE postimId_FK ='"+postim.getPostimId()+"' AND users.userId=koment.userId_FK" ;
                PreparedStatement pstmt2 = c.prepareStatement(sql2);
                ResultSet result2 = pstmt2.executeQuery();
                komentet = new ArrayList<>();
                while(result2.next()) {
                    komentet.add(new Koment(result2.getInt("komentId"), result2.getString("koment"), result2.getString("username"), result2.getString("firstName"), result2.getString("lastName"), result2.getDate("dateCreated"), result2.getString("role")));
                }

                postimDto.add(new PostimDTO(new Postim(postim.getPostimId(), postim.getSeminarId(), postim.getPostim(), postim.getSeminar(), postim.getPedagogu(), postim.getDateCreated(), postim.getLloji()), komentet));
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        databaz.closeConnection(c);
        return postimDto;
    }

    public String shtoPostim(String a){
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Postim obj = mapper.readValue(a, Postim.class);
            c = databaz.estamblishConnection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            System.out.println(formatted); //2016/11/16 12:08:43
            int lloji = 0;
            String sql1="INSERT INTO postim(postim,dateCreated,seminarId_FK, lloji) VALUES('"+obj.getPostim()+"','"+formatted+"','"+obj.getSeminarId()+"','"+lloji+"')";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            pstmt1.executeUpdate();
            databaz.closeConnection(c);
            return "ok";//nqs cdo gje ka shkuar ok

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }


    public String fshiPostim(String a)
    {
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Postim obj = mapper.readValue(a, Postim.class);
            c = databaz.estamblishConnection();
            String sql2="DELETE FROM koment WHERE postimId_FK ='"+obj.getPostimId()+"'" ;
            PreparedStatement pstmt2 = c.prepareStatement(sql2);
            pstmt2.executeUpdate();


            String sql1="DELETE FROM postim WHERE postimId ='"+obj.getPostimId()+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            pstmt1.executeUpdate();


            return "ok";

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
