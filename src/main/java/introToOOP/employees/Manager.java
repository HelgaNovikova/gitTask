package introToOOP.employees;

import java.time.LocalDate;

public class Manager extends Employee{

    private static final int SALARY = 10000;
    private static final String TITLE = "Manager";

    public Manager(LocalDate birthDate, String name, String address) {
        super(birthDate, name, TITLE, SALARY, address);
    }

    public void hireEmployee(Employee employee) {

        System.out.println(employee.getName() + " was hired by " + this.getName());
    }

    public void fireEmployee(Employee employee) {
        System.out.println(employee.getName() + " was fired by " + this.getName());
    }
}
