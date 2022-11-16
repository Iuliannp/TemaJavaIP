package Services;

import Modules.Human;
import Modules.Profesor;
import Modules.Student;

import java.io.*;
import java.util.*;
import java.net.*;

public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter outputStream;
    private ArrayList<Human> humans = new ArrayList<>();

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    Comparator<Human> comparator = new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {
            return Integer.compare(h1.getAge(), h2.getAge());
        }
    };

    @Override
    public void run() {
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintWriter(socket.getOutputStream(),true);

            while(true) {
                String outputString = inputStream.readLine();
                if(outputString.equals("exit")) {
                    break;
                }
                System.out.println("Serverul a primit:" + outputString);
                Scanner inputLine = new Scanner(outputString);

                String type = null;
                inputLine.next();
                if(inputLine.hasNext()) {
                    inputLine.next();
                    if(inputLine.hasNext()) {
                        inputLine.next();
                        if(inputLine.hasNext()) {
                            type = inputLine.next();

                            if(Objects.equals(type,"Student")) { // Student Popa Iulian ATM 22 4
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String facultate = inputLine.next();
                                Integer varsta =  Integer.valueOf(inputLine.next());
                                Integer anDeStudiu =  Integer.valueOf(inputLine.next());
                                Human newStudent = new Student(nume,prenume,facultate,varsta,anDeStudiu);
                                humans.add(newStudent);
                            }
                            else if(Objects.equals(type, "Profesor")){ // Profesor Ioana Dragos ATM 23 IP
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String facultate = inputLine.next();
                                Integer varsta =  Integer.valueOf(inputLine.next());
                                String materie = inputLine.next();
                                Human newProfesor = new Profesor(nume,prenume,facultate,varsta,materie);
                                humans.add(newProfesor);
                            }
                            else {
                                System.out.println("Mesaj gresit");
                            }
                        }
                    }
                }
                humans.sort(comparator);
                for(Human h : humans)
                {
                    System.out.println(h.toString());
                }
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
