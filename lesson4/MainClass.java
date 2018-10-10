
public class MainClass {

    public static double getAverageAge (Employee[] emp)
    {
        int avrAge=0;
        for (int i=0;i<emp.length;i++)
        {
           avrAge +=emp[i].getAge();
        }

        return (double)avrAge/emp.length;

    }

    public static double getAverageSalary (Employee[] emp)
    {
        int avrSalary=0;
        for (int i=0;i<emp.length;i++)
        {
            avrSalary +=emp[i].getSalary();
        }

        return (double)avrSalary/emp.length;

    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Petrov",32,10000);

        System.out.println("FIO:"+emp1.getFio());
        System.out.println("Age:"+emp1.getAge());

        Employee[] emp = new Employee[] { new Employee("Petrov",32,10000),
                                          new Employee("Ivanov",23,5000),
                                          new Employee("Sidorov",45,50000),
                                          new Employee("Kuznesov",33,15000),
                                          new Employee("Makarov",56,45000),};

        System.out.println("Employees over 40:");
        for (int i=0;i<emp.length;i++)
        {
            if (emp[i].getAge()>40)
            {
                System.out.println("-"+emp[i].getFio());
            }
        }


        System.out.println("Salary increase over 45:");
        for (int i=0;i<emp.length;i++)
        {
            if (emp[i].getAge()>45)
            {
                System.out.println("FIO:"+emp[i].getFio()+ " Salary before increase:"+emp[i].getSalary());
                emp[i].salaryIncrease(5000);
                System.out.println("FIO:"+emp[i].getFio()+ " Salary after increase:"+emp[i].getSalary());
            }
        }

        System.out.println("Average age:"+ getAverageAge(emp));
        System.out.println("Average salary:"+ getAverageSalary(emp));
    }
}
