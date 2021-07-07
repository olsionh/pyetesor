package com.packt.pyetesor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.*;
import com.packt.pyetesor.dto.SeminarDTO;
import com.packt.pyetesor.dto.TestDTO;
import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeminarServiceImpl implements SeminarService {
    @Autowired
    private Database databaz;

    private List<Seminar> listaime;

    public List<Seminar> shfaqSeminaret(){
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
            }
        } catch (Exception e) {

        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {


        }

        return seminaret;

    }



    public List<Seminar> shfaqSeminaretPedagog(String pedagogu){
        Connection c = null;
        int semId, kodi;
        String sem, ped, ses;
        List<Seminar> seminaret = new ArrayList<Seminar>();
        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM seminar WHERE pedagogu ='"+pedagogu+"'";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            while (result.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                semId=result.getInt(1);
                sem=result.getString(2);
                ped=result.getString(3);
                ses=result.getString(4);
                seminaret.add(new Seminar(semId, sem, ped, ses));
            }
        } catch (Exception e) {

        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {


        }

        return seminaret;

    }






    public ArrayList<Seminar> seminareteMia(int userId){
        Connection c = null;
        ArrayList<Seminar> seminareteMia = new ArrayList<Seminar>();
        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT seminarId_FK FROM userseminar WHERE userId_FK ='"+userId+"'";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();

            while (result.next()) {
                sql1 = "SELECT * FROM seminar WHERE seminarId='"+result.getInt("seminarId_FK")+"'";
                pstmt1 = c.prepareStatement(sql1);
                ResultSet result2 = pstmt1.executeQuery();
                result2.next();
                seminareteMia.add(new Seminar(result2.getInt("seminarId"),result2.getString("seminar"),result2.getString("pedagogu"), result2.getString("sesioni")));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return seminareteMia;
    }

    public List<Map<String, Object>> report()
    {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Seminar seminar: this.shfaqSeminaret())
        {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("seminarId", seminar.getSeminarId());
            item.put("seminar", seminar.getSeminar());
        }
        return result;
    }

    public String cregjistrim(String a, int userId){
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Seminar obj = mapper.readValue(a, Seminar.class);
            c = databaz.estamblishConnection();
            String sql1="DELETE FROM userseminar WHERE seminarId_FK ='"+obj.getSeminarId()+"' AND userId_FK='"+userId+"'" ;
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

    public ArrayList<SeminarDTO> listAllSeminars(int idUseri){
        Connection c = null;
        ArrayList<Seminar> seminaret = new ArrayList<Seminar>();
        ArrayList<Postim> postimet;
        ArrayList<SeminarDTO> seminarDto = new ArrayList<SeminarDTO>();

        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM userseminar, seminar WHERE userseminar.userId_FK ='"+idUseri+"' AND userseminar.seminarId_FK=seminar.seminarId";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();

                while (result1.next()) {
                    seminaret.add(new Seminar(result1.getInt("seminarId"), result1.getString("seminar"), result1.getString("pedagogu"), result1.getString("sesioni")));
                }

                int k=0;
            for(Seminar seminar : seminaret) {
                System.out.println("Ketu jemi te seminari me id "+seminar.getSeminarId());
                String sql2="SELECT * FROM postim WHERE seminarId_FK ='"+seminar.getSeminarId()+"'" ;
                PreparedStatement pstmt2 = c.prepareStatement(sql2);
                ResultSet result2 = pstmt2.executeQuery();
                int i=0;
                postimet = new ArrayList<>();
                while(result2.next()) {
                    postimet.add(new Postim(result2.getInt("postimId"), result1.getInt("seminarId"), result2.getString("postim"), "seminar", "pedagogu", result2.getDate("dateCreated"), result2.getInt("lloji")));
                    i++;
                }

                    seminarDto.add(new SeminarDTO(new Seminar(seminar.getSeminarId(), seminar.getSeminar(), seminar.getPedagogu(), seminar.getSesioni()), postimet));
                    k++;
                }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        databaz.closeConnection(c);
        return seminarDto;
    }

    public Seminar findSeminar(int seminarID){
        Connection c = null;
        Seminar t =null;
        try {
            c = databaz.estamblishConnection();
            String sql1="SELECT * FROM seminar WHERE seminarId='"+seminarID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();
            while (result1.next()){
                t= new Seminar(result1.getInt("seminarId"),result1.getString("seminar"),result1.getString("pedagogu"),result1.getString("sesioni"));
            }
        }
        catch(Exception e){
            return null;
        }
        return t;
    }


    public Seminar findSeminarPedagog(int seminarID, String pedagog){
        Connection c = null;
        Seminar t =null;
        try {
            c = databaz.estamblishConnection();
            String sql1="SELECT * FROM seminar WHERE seminarId='"+seminarID+"' AND pedagogu='"+pedagog+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();
            while (result1.next()){
                t= new Seminar(result1.getInt("seminarId"),result1.getString("seminar"),result1.getString("pedagogu"),result1.getString("sesioni"));
            }
        }
        catch(Exception e){
            return null;
        }
        return t;
    }



    public Seminar findSeminarStudent(int seminarID, int userID){
        Connection c = null;
        Seminar t =null;
        try {
            c = databaz.estamblishConnection();
            String sql1="SELECT * FROM userseminar, seminar WHERE seminar.seminarId='"+seminarID+"' AND userseminar.seminarId_FK='"+seminarID+"' AND userseminar.userId_FK='"+userID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();
            while (result1.next()){
                t= new Seminar(result1.getInt("seminarId"),result1.getString("seminar"),result1.getString("pedagogu"),result1.getString("sesioni"));
            }
        }
        catch(Exception e){
            return null;
        }
        return t;
    }





    public String emriPedagogut(int seminarID)
    {
        String emri = "";
        Connection c = null;
        try {
            c = databaz.estamblishConnection();
            String sql1="SELECT pedagogu FROM seminar WHERE seminarId='"+seminarID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();
            result1.next();
            String username = result1.getString("pedagogu");

            String sql2 = "SELECT firstName, lastName from users WHERE username='"+username+"'";
            PreparedStatement pstmt2 = c.prepareStatement(sql2);
            ResultSet result2 = pstmt2.executeQuery();
            result2.next();
            emri = result2.getString("firstName") + " " + result2.getString("lastName");
        }
        catch(Exception e){
            return null;
        }
        return emri;
    }






    public ArrayList<Seminar> afishoTeGjithaSeminaret()
    {
        Connection c = null;
        ArrayList<Seminar> seminareteMia = new ArrayList<Seminar>();
        try {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM seminar";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();

            while (result.next()) {
                seminareteMia.add(new Seminar(result.getInt("seminarId"),result.getString("seminar"),result.getString("pedagogu"), result.getString("sesioni")));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        try {
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return seminareteMia;
    }

    public int nrStudenteve (int seminarId)
    {
        Connection c = null;
        int nr = 0;
        System.out.println(seminarId);
        try
        {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM userseminar WHERE seminarId_FK='"+seminarId+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            while (result.next())
            {
                nr++;
            }
        }
        catch (Exception e)
        {
            return -1;
        }
        System.out.println(nr);

        return nr;
    }

    public int nrPostimeve (int seminarId)
    {
        Connection c = null;
        int nr = 0;
        try
        {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM postim WHERE seminarId_FK='"+seminarId+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            while (result.next())
            {
                nr++;
            }
        }
        catch (Exception e)
        {
            return -1;
        }

        return nr;
    }



    public int nrTesteve (int seminarId)
    {
        Connection c = null;
        int nr = 0;
        try
        {
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM tests WHERE seminarId_FK='"+seminarId+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            while (result.next())
            {
                nr++;
            }
        }
        catch (Exception e)
        {
            return -1;
        }

        return nr;
    }






    public void shtoPerdorues (String a, int seminarId)
    {
        Connection c = null;
        int nr = 0;
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            User obj = mapper.readValue(a, User.class);
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM users WHERE username='"+obj.getUsername()+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            result.next();
            String sql2 = "INSERT INTO userseminar(userId_FK,seminarId_FK) VALUES('"+result.getInt("userId")+"','"+seminarId+"')";
            PreparedStatement pstmt2 = c.prepareStatement(sql2);
            pstmt2.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void hiqPerdorues (String a)
    {
        Connection c = null;
        int nr = 0;
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            User obj = mapper.readValue(a, User.class);
            c = databaz.estamblishConnection();
            String sql1 = "SELECT * FROM users WHERE username='"+obj.getUsername()+"'" ;
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result = pstmt1.executeQuery();
            result.next();
            String sql2 = "DELETE FROM userseminar WHERE userId_FK = '"+result.getInt("userId")+"'";
            PreparedStatement pstmt2 = c.prepareStatement(sql2);
            pstmt2.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public String fshiSeminar(String a)
    {
        Connection c = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Seminar obj = mapper.readValue(a, Seminar.class);
            c = databaz.estamblishConnection();
            String sql1="SELECT * FROM postim WHERE seminarId_FK ='"+obj.getSeminarId()+"'";
            PreparedStatement pstmt1 = c.prepareStatement(sql1);
            ResultSet result1 = pstmt1.executeQuery();

            while (result1.next())
            {
                String sql2 = "DELETE FROM koment WHERE postimId_FK ='" + result1.getInt("postimId") + "'";
                PreparedStatement pstmt2 = c.prepareStatement(sql2);
                pstmt2.executeUpdate();
            }

            String sql4 = "DELETE FROM postim WHERE seminarId_FK ='" + obj.getSeminarId() + "'";
            PreparedStatement pstmt4 = c.prepareStatement(sql4);
            pstmt4.executeUpdate();



            String sql5 = "DELETE FROM userseminar WHERE seminarId_FK ='" + obj.getSeminarId() + "'";
            PreparedStatement pstmt5 = c.prepareStatement(sql5);
            pstmt5.executeUpdate();

            String sql3="DELETE FROM seminar WHERE seminarId ='"+obj.getSeminarId()+"'" ;
            PreparedStatement pstmt3 = c.prepareStatement(sql3);
            pstmt3.executeUpdate();



            return "ok";

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }



    public String shtoKurs(Seminar newSeminar, String username) {
        Connection c = null;
        ArrayList<String> array = new ArrayList<String>();
        try {
            c = databaz.estamblishConnection();
            System.out.println(username);
            String sql2 = "INSERT INTO seminar (seminar, pedagogu, sesioni) VALUES('"+newSeminar.getSeminar()+"','"+username+"','"+newSeminar.getSesioni()+"')";
            PreparedStatement pstmt2 = c.prepareStatement(sql2);
            pstmt2.executeUpdate();

        } catch (Exception e) {
            System.out.println("gabim?");
            e.printStackTrace();
            return null;
        }
        try {
            System.out.println("te dhenat u hodhen");
            databaz.closeConnection(c);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return "Sukses";
    }




}
