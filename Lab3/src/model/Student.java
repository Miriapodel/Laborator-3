package model;

public class Student extends model.Person{
    private int studentNumber;
    private double averageMark;
    private int classNr;

    public Student(String name, String email, String phoneNumber, int studentNumber, double averageMark, int classNr) {
        super(name, email, phoneNumber);
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
        this.classNr = classNr;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public int getClassNr() {
        return classNr;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public void setClassNr(int classNr) {
        this.classNr = classNr;
    }

    @Override
    public String toString() {
        return "Nume: " +  getName() + ", Email: " + getEmail() + ", Numar telefon: " + getPhoneNumber() +
                ", Numar matricol: " + studentNumber + ", Media: " + averageMark + ", Grupa: " + classNr;
    }
}
