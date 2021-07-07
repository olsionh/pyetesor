package com.packt.pyetesor.service;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;

        import com.packt.pyetesor.domain.Seminar;
        import com.packt.pyetesor.domain.User;
        import com.packt.pyetesor.dto.SeminarDTO;

public interface SeminarService {

    public List<Seminar> shfaqSeminaretPedagog(String pedagogu);
    public List<Seminar> shfaqSeminaret();
    public ArrayList<Seminar> seminareteMia(int userId);
    public String cregjistrim(String a, int seminarId);
    public ArrayList<SeminarDTO> listAllSeminars(int idUseri);
    public Seminar findSeminar(int seminarID);
    public ArrayList<Seminar> afishoTeGjithaSeminaret();
    public int nrStudenteve (int seminarId);
    public int nrPostimeve (int seminarId);
    public void shtoPerdorues (String a, int seminarId);
    public String fshiSeminar(String a);
    public Seminar findSeminarPedagog(int seminarID, String pedagog);
    public String emriPedagogut(int seminarID);
    public Seminar findSeminarStudent(int seminarID, int userID);
    public void hiqPerdorues (String a);
    public String shtoKurs(Seminar newSeminar, String username);
    public int nrTesteve (int seminarId);

}
