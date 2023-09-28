package introToOOP.employees;

import java.time.LocalDate;

public class Clerk extends Employee {

    private static final int SALARY = 3000;
    private static final String TITLE = "Clerk";

    public Clerk(LocalDate birthDate, String name, String address) {
        super(birthDate, name, TITLE, SALARY, address);
    }

    public void callCustomer() {
        System.out.println("Clerk " + this.getName() + " called a customer");
    }

    public void answerTheCall() {
        System.out.println("Clerk " + this.getName() + " answered the call");
    }
}
