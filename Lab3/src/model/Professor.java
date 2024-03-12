package model;

public class Professor extends Person{
    private String course;
    private int year;

    public Professor(String name, String email, String phoneNumber, String course, int year) {
        super(name, email, phoneNumber);
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Nume: " +  getName() + ", Email: " + getEmail() + ", Numar telefon: " + getPhoneNumber() +
                ", Curs: " + course + ", An: " + year;
    }
}
