package sample;

import java.io.*;
import java.util.*;

class Model {

  static List<Employee> creatingList(){

    List<Employee> employeeList = new LinkedList<>();

    employeeList.add(new EmployeeFixedPayment("Oleg",1000));
    employeeList.add(new EmployeeFixedPayment("Vasya", 2100));
    employeeList.add(new EmployeeFixedPayment("Andrew", 2000));
    employeeList.add(new EmployeeFixedPayment("Serg", 3000));

    employeeList.add(new EmployeeHourlyWage("Ira", 79));
    employeeList.add(new EmployeeHourlyWage("Katya", 30));
    employeeList.add(new EmployeeHourlyWage("Vlad",20));
    employeeList.add(new EmployeeHourlyWage("Vova", 5));
    employeeList.sort(new EmployeeComparator());

    return employeeList;
  }

  static void outputFromFile(List<Employee> employeeList){

    writeEmployees(employeeList);
    List<Employee> list = readEmployees();
    for (Employee employee : list) {
      System.out.println(employee);
    }

  }

  private static void writeEmployees(List<Employee> employeeList){

    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.bin"))) {

      oos.writeObject(employeeList);

    }  catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static List<Employee> readEmployees() {
    List<Employee> result = null;

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.bin"))) {

      result = (List<Employee>) ois.readObject();

    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }

    return result;
  }
}

abstract class Employee implements Serializable {

  private static int idCounter;
  private int id;
  String name;

  public Employee() {
    idCounter++;
    id = idCounter;
  }
  public abstract double getMonthlySalary();

  int getId() {
    return id;
  }

  String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + " - " + getMonthlySalary();
  }
}

class EmployeeFixedPayment extends Employee{
  private int fixedPayment;

  EmployeeFixedPayment(String name, int fixedPayment) {
    this.name = name;
    this.fixedPayment = fixedPayment;
  }

  public double getMonthlySalary() {
    return fixedPayment;
  }
}

class EmployeeHourlyWage extends Employee{

  private int hourlyRate;

  public EmployeeHourlyWage(String name, int hourlyRate) {
    this.name = name;
    this.hourlyRate = hourlyRate;
  }

  public double getMonthlySalary() {
    return 20.8 * 8 * hourlyRate;
  }
}

class EmployeeComparator implements Comparator<Employee> {

  public int compare(Employee e1, Employee e2) {
    if (e1.getMonthlySalary() > e2.getMonthlySalary()) {
      return -1;
    }
    else if (e1.getMonthlySalary() < e2.getMonthlySalary()) {
      return 1;
    }
    else
      return e1.getName().compareTo(e2.getName());
  }
}