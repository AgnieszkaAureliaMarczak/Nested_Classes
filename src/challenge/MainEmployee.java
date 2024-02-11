package challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>(List.of(
                new Employee("Tim", "Smith", 1999),
                new Employee("Dan", "Johnson", 2010),
                new Employee("Anna", "Williams", 1995),
                new Employee("Emma", "Jones", 2015),
                new Employee("Eli", "Brown", 2023),
                new Employee("Tom", "Davis", 2015),
                new Employee("Zac", "Miller", 2001),
                new Employee("Ila", "Wilson", 2001),
                new Employee("Jack", "Moore", 2000),
                new Employee("Jim", "Taylor", 2016)
        ));
        System.out.println("New List");
        printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");
    }

    public static void printOrderedList(List<Employee> list, String sortField) {
        class EmployeeWrapper { // klasa lokalna
            Employee employee;
            String fullName;
            int yearsWorked;

            public EmployeeWrapper(Employee employee) {
                this.employee = employee;
                fullName = String.join(" ", employee.firstName(), employee.lastName());
                yearsWorked = 2023 - employee.hireDate();
            }

            @Override
            public String toString() {
                return "%s has been am employee for %d years".formatted(fullName, yearsWorked);
            }
        }
        List<EmployeeWrapper> myList = new ArrayList<>();
        for (Employee employee : list) {
            myList.add(new EmployeeWrapper(employee));
        }

        var comparator = new Comparator<EmployeeWrapper>() { // klasa anonimowa

            @Override
            public int compare(EmployeeWrapper o1, EmployeeWrapper o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };
        myList.sort(comparator);
        for (EmployeeWrapper employeeWrapper : myList) {
            System.out.println(employeeWrapper);
        }
    }
}
