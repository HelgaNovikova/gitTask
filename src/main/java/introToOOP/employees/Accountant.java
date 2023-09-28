package introToOOP.employees;

import java.time.LocalDate;

public class Accountant extends Employee {

    private static final int SALARY = 5000;
    private static final String TITLE = "Accountant";

    public Accountant(LocalDate birthDate, String name, String address) {
        super(birthDate, name, TITLE, SALARY, address);
    }

    public void openAccount() {
        System.out.println(this.getName() + " opened the account");
    }

    public void closeAccount() {
        System.out.println(this.getName() + " closed the account");
    }

    public void createReport() {
        System.out.println(this.getName() + " created the report");
    }
}
