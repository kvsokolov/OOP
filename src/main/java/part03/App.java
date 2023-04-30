package part03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class App {

    private static Random random = new Random();

    /**
     * TODO: 2. generateEmployee должен создавать различных сотрудников (Worker, Freelancer)
     * @return
     */
    static Employee generateEmployee(){
        String[] names = new String[] { "Jayden", "Noah", "Reece", "Oliver", "Josh", "Graham", "Benton", "Liam", "Clinton", "Ezra" };
        String[] surnames = new String[] { "Carr", "Walker", "Mccarthy", "Mitchell", "George", "Hicks", "Jensen", "Ewing", "Hayden", "Mullen" };

        int salary = random.nextInt(200, 300);
        int index = random.nextInt(30, 50);
        int age = random.nextInt(18, 65);
        boolean empType = random.nextBoolean();

        if (empType)
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary * index);
        else
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], age, random.nextInt(1000, 2500), random.nextInt(1, 8));

    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees){
            System.out.println(employee);
        }

        //Arrays.sort(employees, new NameComparator());
        Arrays.sort(employees, new AgeComparator().reversed());

        System.out.printf("\n*** Sorted by age ***\n\n");

        for (Employee employee : employees){
            System.out.println(employee);
        }

    }

}


class SalaryComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {

        //return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        return Double.compare( o2.calculateSalary(), o1.calculateSalary());
    }
}

class NameComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        //return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        int res = o1.name.compareTo(o2.name);
        if (res == 0){
            res = Double.compare( o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}
class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee t1) {
        return Integer.compare(employee.getAge(), t1.getAge());
    }
}

abstract class Employee implements Comparable<Employee>{

    protected String name;
    protected String surName;
    protected double salary;
    protected int age;

    public Employee(String name, String surName, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public abstract double calculateSalary();
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d; Среднемесячная заработная плата: %.2f", name, surName, age, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare( o.calculateSalary(), calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary ;
        //TODO: Для фрилансера - return 20 * 5 * salary
    }

    @Override
    public String toString() {
        return String.format("Full name: %s %s,\nAge: %d,\nEmployee status: %s\nSalary: %.2f roubles.\n", name, surName, age, this.getClass().getSimpleName(), calculateSalary());
    }
}

/**
 * TODO: 1. Доработать самостоятельно в рамках домашней работы
 */
class Freelancer extends Employee{
    private int dutyTime;

    public Freelancer(String name, String surName, int age, double salary, int dutyTime) {
        super(name, surName, age, salary);
        this.dutyTime = dutyTime;
    }

    @Override
    public double calculateSalary() {
        return salary * dutyTime;
    }

    @Override
    public String toString() {
        return String.format("Full name: %s %s,\nAge: %d,\nEmployee status: %s\nPay per hour: %.2f,\nDuty time: %d hours,\nSalary: %.2f roubles.\n", name, surName, age, this.getClass().getSimpleName(), salary, dutyTime, calculateSalary());
    }
}