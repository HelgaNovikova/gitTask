package introToOOP.employees;

import java.time.LocalDate;

public abstract class Employee {
    private final int id;
    private static int idCounter = 0;
    private LocalDate birthDate;
    private String name;
    private String title;
    private long salary;
    private String address;

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void receiveSalary() {
        System.out.println("The employee received his salary");
    }

    public Employee(LocalDate birthDate, String name, String title, long salary, String address) {
        this.id = ++idCounter;
        this.birthDate = birthDate;
        this.name = name;
        this.title = title;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name: " + name +
                ", title: " + title +
                ", address: " + address +
                ", birthDate: " + birthDate +
                ", salary: " + salary + "$" +
                '}';
    }
}
