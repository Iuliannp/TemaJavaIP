package Modules;

public class Student implements Human {
    private String nume;
    private String prenume;
    private String facultate;
    private Integer varsta;
    private Integer anDeStudiu;

    public void greeting() {

    }
    public void doWork() {

    }

    public Integer getAge() {
        return this.varsta;
    }

    public Student(String nume, String prenume, String facultate, Integer varsta, Integer anDeStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.facultate = facultate;
        this.varsta = varsta;
        this.anDeStudiu = anDeStudiu;
    }

    @Override
    public String toString() {
        return ("Sd. " + this.nume + " " +this.prenume + " ," + "Anul, " + this.anDeStudiu + ", Fac." +
                this.facultate +", Varsta" + this.varsta);
    }
}
