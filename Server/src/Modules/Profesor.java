package Modules;

public class Profesor implements Human {
    private String nume;
    private String prenume;
    private String facultate;
    private Integer varsta;
    private String materie;

    public void greeting() {

    }
    public void doWork() {

    }

    public Integer getAge() {
        return this.varsta;
    }

    public Profesor(String nume, String prenume, String facultate, Integer varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.facultate = facultate;
        this.varsta = varsta;
        this.materie = materie;
    }

    @Override
    public String toString() {
        return ("Prof. " + this.nume + " " +this.prenume + " ," + "Fac. " + this.facultate + ", Varsta" +
                this.varsta +", Materie Predata" +this.materie);
    }
}
