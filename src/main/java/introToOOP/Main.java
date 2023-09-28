package introToOOP;

import introToOOP.employees.Accountant;
import introToOOP.employees.Clerk;
import introToOOP.employees.Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager(LocalDate.parse("1990-01-08"), "John Smith", "Toronto");
        List<Clerk> clerks = new ArrayList<>();
        clerks.add(new Clerk(LocalDate.parse("1990-01-09"), "Connor Moore", "Toronto"));
        clerks.add(new Clerk(LocalDate.parse("1990-01-10"), "Jannet Lunn", "Toronto"));
        clerks.add(new Clerk(LocalDate.parse("1990-01-09"), "Margaret Atwood", "Toronto"));
        List<Accountant> accountants = new ArrayList<>();
        accountants.add(new Accountant(LocalDate.parse("1990-02-09"), "John Faults", "Toronto"));
        accountants.add(new Accountant(LocalDate.parse("1990-03-09"), "John Test", "Toronto"));
        accountants.get(1).openAccount();
        accountants.get(0).closeAccount();
        accountants.get(1).createReport();
        accountants.get(0).receiveSalary();
        clerks.get(1).answerTheCall();
        clerks.get(2).callCustomer();
        manager.fireEmployee(clerks.get(0));
        manager.hireEmployee(accountants.get(1));
    }
}