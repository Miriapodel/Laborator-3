import model.Professor;
import model.Student;
import service.StorageService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public void adaugaStudent(Scanner scanner){
        String name;
        String email;
        String phoneNumber;
        int studentNumber;
        int classNr;
        double averageMark;


        System.out.println("Adauga numele studentului: ");
        name = scanner.nextLine();
        System.out.println("Adauga emailul studentului: ");
        email = scanner.nextLine();
        System.out.println("Adauga numarul de telefon al studentului: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Adauga numarul matricol al studentului: ");
        studentNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adauga media studentului: ");
        averageMark = scanner.nextDouble();
        System.out.println("Adauga grupa studentului: ");
        classNr = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Student> listaStudenti = StorageService.getListaStudenti();
        boolean existaStudent = false;

        for(int i = 0; i < listaStudenti.size(); i++)
            if (Objects.equals(listaStudenti.get(i).getName(), name)) {

                System.out.println("Exista deja un student cu acest nume!");

                existaStudent = true;
            }

        if (!existaStudent){
            StorageService.getListaStudenti().add(new Student(name, email, phoneNumber, studentNumber, averageMark , classNr));

            System.out.println("Studentul a fost adaugat cu succes!");
            System.out.println();
        }
    }

    public void afiseazaStudent(Scanner scanner){
        ArrayList<Student> listaStudenti = StorageService.getListaStudenti();

        if(!listaStudenti.isEmpty()){
            System.out.println("Alege studentul pe care vrei sa il afisezi:");

            for(int i = 0; i < listaStudenti.size(); i++){
                System.out.println( (i + 1) + ". " + listaStudenti.get(i).getName() );
            }

            int indexStudent = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexStudent >= 0 && indexStudent < listaStudenti.size()){
                System.out.println("Detaliile studentului: ");
                System.out.println(listaStudenti.get(indexStudent).toString());
                System.out.println();
            }
            else{
                System.out.println("Nu exista studentul cu indexul introdus!");
                System.out.println();
            }


        }
        else{
            System.out.println("Momentan nu exista niciun student adaugat!");
            System.out.println();
        }
    }

    public void updateStudent(Scanner scanner){
        ArrayList<Student> listaStudenti = StorageService.getListaStudenti();

        if(!listaStudenti.isEmpty()){
            System.out.println("Alege studentul caruia vrei sa-i modifici datele:");

            for(int i = 0; i < listaStudenti.size(); i++){
                System.out.println( (i + 1) + ". " + listaStudenti.get(i).getName() );
            }

            int indexStudent = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexStudent >= 0 && indexStudent < listaStudenti.size()){
                System.out.println("Alege ce vrei sa modifici: ");
                System.out.println("1. Nume");
                System.out.println("2. Email");
                System.out.println("3. Numar telefon");
                System.out.println("4. Numar matricol");
                System.out.println("5. Medie");
                System.out.println("6. Grupa");

                int optiuneMod = scanner.nextInt();
                scanner.nextLine();

                switch (optiuneMod){
                    case 1:
                        System.out.println("Introdu numele nou: ");

                        String numeNou = scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setName(numeNou);

                        System.out.println("Numele a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 2:
                        System.out.println("Introdu email-ul nou: ");

                        String emailNou = scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setEmail(emailNou);

                        System.out.println("Email-ul a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 3:
                        System.out.println("Introdu numarul de telefon nou: ");

                        String telNou = scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setPhoneNumber(telNou);

                        System.out.println("Numarul de telefon a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 4:
                        System.out.println("Introdu numarul matricoul nou: ");

                        int nrMatNou = scanner.nextInt();
                        scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setStudentNumber(nrMatNou);

                        System.out.println("Numarul matricol a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 5:
                        System.out.println("Introdu media noua: ");

                        double medieNoua = scanner.nextDouble();
                        scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setAverageMark(medieNoua);

                        System.out.println("Media a fost modificata cu succes!");
                        System.out.println();

                        break;

                    case 6:
                        System.out.println("Introdu grupa noua: ");

                        int grupaNoua = scanner.nextInt();
                        scanner.nextLine();

                        StorageService.getListaStudenti().get(indexStudent).setClassNr(grupaNoua);

                        System.out.println("Grupa a fost modificata cu succes!");
                        System.out.println();

                        break;

                    default:
                        System.out.println("Input invalid!");
                        break;
                }
            }
            else{
                System.out.println("Nu exista niciun student cu indexul introdus");
                System.out.println();
            }

        }
        else{
            System.out.println("Momentan nu exista niciun student adaugat!");
            System.out.println();
        }

    }

    public void stergeStudent(Scanner scanner){
        ArrayList<Student> listaStudenti = StorageService.getListaStudenti();

        if (!listaStudenti.isEmpty()){
            System.out.println("Alege studentul pe care vrei sa il stergi:");

            for(int i = 0; i < listaStudenti.size(); i++){
                System.out.println( (i + 1) + ". " + listaStudenti.get(i).getName() );
            }

            int indexStudent = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexStudent >= 0 && indexStudent < listaStudenti.size()){
                listaStudenti.remove(indexStudent);

                System.out.println("Studentul a fost modificat cu succes!");
                System.out.println();
            }
            else{
                System.out.println("Nu exista nicinu student cu indexul introdus!");
                System.out.println();
            }
        }
        else{
            System.out.println("Nu a fost adaugat niciun student momentan!");
            System.out.println();
        }
    }

    public void optiuniStudent(Application app, Scanner scanner){
        System.out.println("Alege una dintre optiuni:");
        System.out.println("1. Adauga un nou student");
        System.out.println("2. Afiseaza datele unui student");
        System.out.println("3. Schimba datele unui student");
        System.out.println("4. Sterge un student");


        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune){
            case 1:
                app.adaugaStudent(scanner);
                break;
            case 2:
                app.afiseazaStudent(scanner);
                break;
            case 3:
                app.updateStudent(scanner);
                break;
            case 4:
                app.stergeStudent(scanner);
                break;
            default:
                System.out.println("Nu ai introdus o optiune valida!");
                break;
        }
    }



    public void adaugaProfesor(Scanner scanner){
        String name;
        String email;
        String phoneNumber;
        String course;
        int year;


        System.out.println("Adauga numele profesorului: ");
        name = scanner.nextLine();
        System.out.println("Adauga emailul profesorului: ");
        email = scanner.nextLine();
        System.out.println("Adauga numarul de telefon al profesorului: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Adauga cursul profesorului: ");
        course = scanner.nextLine();
        System.out.println("Adauga anul la care preda profesorul: ");
        year = scanner.nextInt();


        ArrayList<Professor> listaProfesori = StorageService.getListaProfesori();
        boolean existaProfesor = false;

        for(int i = 0; i < listaProfesori.size(); i++)
            if (Objects.equals(listaProfesori.get(i).getName(), name)) {

                System.out.println("Exista deja un profesor cu acest nume!");

                existaProfesor = true;
            }

        if (!existaProfesor){
            StorageService.getListaProfesori().add(new Professor(name, email, phoneNumber, course, year ));

            System.out.println("Profesorul a fost adaugat cu succes!");
            System.out.println();
        }
    }

    public void afiseazaProfesor(Scanner scanner){
        ArrayList<Professor> listaProfesori = StorageService.getListaProfesori();

        if(!listaProfesori.isEmpty()){
            System.out.println("Alege profesorul pe care vrei sa il afisezi:");

            for(int i = 0; i < listaProfesori.size(); i++){
                System.out.println( (i + 1) + ". " + listaProfesori.get(i).getName() );
            }

            int indexProfesor = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexProfesor >= 0 && indexProfesor < listaProfesori.size()){
                System.out.println("Detaliile profesorului: ");
                System.out.println(listaProfesori.get(indexProfesor).toString());
                System.out.println();
            }
            else{
                System.out.println("Nu exista profesorul cu indexul introdus!");
                System.out.println();
            }


        }
        else{
            System.out.println("Momentan nu exista niciun profesor adaugat!");
            System.out.println();
        }
    }

    public void updateProfesor(Scanner scanner){
        ArrayList<Professor> listaProfesori = StorageService.getListaProfesori();

        if(!listaProfesori.isEmpty()){
            System.out.println("Alege studentul caruia vrei sa-i modifici datele:");

            for(int i = 0; i < listaProfesori.size(); i++){
                System.out.println( (i + 1) + ". " + listaProfesori.get(i).getName() );
            }

            int indexProfesor = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexProfesor >= 0 && indexProfesor < listaProfesori.size()){
                System.out.println("Alege ce vrei sa modifici: ");
                System.out.println("1. Nume");
                System.out.println("2. Email");
                System.out.println("3. Numar telefon");
                System.out.println("4. Cursul");
                System.out.println("5. Anul la care preda");

                int optiuneMod = scanner.nextInt();
                scanner.nextLine();

                switch (optiuneMod){
                    case 1:
                        System.out.println("Introdu numele nou: ");

                        String numeNou = scanner.nextLine();

                        StorageService.getListaProfesori().get(indexProfesor).setName(numeNou);

                        System.out.println("Numele a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 2:
                        System.out.println("Introdu email-ul nou: ");

                        String emailNou = scanner.nextLine();

                        StorageService.getListaProfesori().get(indexProfesor).setEmail(emailNou);

                        System.out.println("Email-ul a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 3:
                        System.out.println("Introdu numarul de telefon nou: ");

                        String telNou = scanner.nextLine();

                        StorageService.getListaProfesori().get(indexProfesor).setPhoneNumber(telNou);

                        System.out.println("Numarul de telefon a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 4:
                        System.out.println("Introdu cursul nou: ");

                        String numeCurs = scanner.nextLine();

                        StorageService.getListaProfesori().get(indexProfesor).setCourse(numeCurs);

                        System.out.println("Cursul a fost modificat cu succes!");
                        System.out.println();

                        break;

                    case 5:
                        System.out.println("Introdu anul nou la care preda: ");

                        int anNou = scanner.nextInt();
                        scanner.nextLine();

                        StorageService.getListaProfesori().get(indexProfesor).setYear(anNou);

                        System.out.println("Anul a fost modificat cu succes!");
                        System.out.println();

                        break;

                    default:
                        System.out.println("Input invalid!");
                        break;
                }
            }
            else{
                System.out.println("Nu exista niciun student cu indexul introdus");
                System.out.println();
            }

        }
        else{
            System.out.println("Momentan nu exista niciun student adaugat!");
            System.out.println();
        }
    }

    public void stergeProfesor(Scanner scanner){
        ArrayList<Professor> listaProfesori = StorageService.getListaProfesori();

        if (!listaProfesori.isEmpty()){
            System.out.println("Alege profesorul pe care vrei sa il stergi:");

            for(int i = 0; i < listaProfesori.size(); i++){
                System.out.println( (i + 1) + ". " + listaProfesori.get(i).getName() );
            }

            int indexProfesor = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indexProfesor >= 0 && indexProfesor < listaProfesori.size()){
                listaProfesori.remove(indexProfesor);

                System.out.println("Profesorul a fost modificat cu succes!");
                System.out.println();
            }
            else{
                System.out.println("Nu exista nicinu profesor cu indexul introdus!");
                System.out.println();
            }
        }
        else{
            System.out.println("Nu a fost adaugat niciun profesor momentan!");
            System.out.println();
        }
    }

    public void optiuniProfesor(Application app, Scanner scanner){
        System.out.println("Alege una dintre optiuni:");
        System.out.println("1. Adauga un nou profesor");
        System.out.println("2. Afiseaza datele unui profesor");
        System.out.println("3. Schimba datele unui profesor");
        System.out.println("4. Sterge un profesor");

        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune){
            case 1:
                app.adaugaProfesor(scanner);
                break;
            case 2:
                app.afiseazaProfesor(scanner);
                break;
            case 3:
                app.updateProfesor(scanner);
                break;
            case 4:
                app.stergeProfesor(scanner);
                break;
            default:
                System.out.println("Nu ai introdus o optiune valida!");
                break;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Application app = new Application();
        int optiune = 0;

        while(true){
            System.out.println("Alege una dintre optiuni:");
            System.out.println("1. Operatii cu clasa Student");
            System.out.println("2. Operatii cu clasa Professor");
            System.out.println("3. Inchide aplicatia");

            optiune = scanner.nextInt();
            scanner.nextLine();


            switch (optiune){
                case 1:
                    app.optiuniStudent(app, scanner);
                    break;
                case 2:
                    app.optiuniProfesor(app, scanner);
                    break;
                case 3:
                    System.out.println("Aplicatia se inchide...");
                    break;
                default:
                    System.out.println("Nu a fost introdusa o optiune valida");
                    break;
            }

            if (optiune == 3){
                break;
            }
        }
    }
}
