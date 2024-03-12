package service;

import model.Professor;
import model.Student;

import java.util.ArrayList;

public class StorageService {
    private static ArrayList<Student> listaStudenti;
    private static ArrayList<Professor> listaProfesori;


    static {
        listaProfesori = new ArrayList<Professor>();
        listaStudenti = new ArrayList<Student>();
    }

    public static ArrayList<Student> getListaStudenti() {
        return listaStudenti;
    }

    public static ArrayList<Professor> getListaProfesori() {
        return listaProfesori;
    }

    public static void setListaStudenti(ArrayList<Student> listaStudenti) {
        StorageService.listaStudenti = listaStudenti;
    }

    public static void setListaProfesori(ArrayList<Professor> listaProfesori) {
        StorageService.listaProfesori = listaProfesori;
    }
}
