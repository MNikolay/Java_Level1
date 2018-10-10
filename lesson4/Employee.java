import java.util.UUID;

public class Employee {
    private String fio;
    private int age;
    private int salary;
    private  String idEmployee;

    String getFio () {return this.fio;}
    int getAge(){return this.age;}
    int getSalary() {return this.salary;}


    public void salaryIncrease(int inc)
    {
        this.salary=this.salary+inc;
    }

    Employee()
    {
        UUID guid = UUID.randomUUID();
        this.idEmployee=guid.toString();
    }
    Employee (String fio, int age, int salary)
    {
        this();
        this.fio=fio;
        this.age=age;
        this.salary=salary;
    }

}
