package Intermediate_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    int id;
    String department;
    String jobTitle;
    String contactInfo;

    public Employee(String name, int id, String department, String jobTitle, String contactInfo) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.contactInfo = contactInfo;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nDepartment: " + department + "\nJob Title: " + jobTitle + "\nContact Info: " + contactInfo;
    }
}

public class EmployeeManagementApplication {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementApplication() {
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter employee job title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter employee contact info: ");
        String contactInfo = scanner.nextLine();

        Employee employee = new Employee(name, id, department, jobTitle, contactInfo);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private void viewEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.println(employee.toString());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private void updateEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.print("Enter new employee name (or press Enter to keep the same): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    employee.name = name;
                }
                System.out.print("Enter new employee department (or press Enter to keep the same): ");
                String department = scanner.nextLine();
                if (!department.isEmpty()) {
                    employee.department = department;
                }
                System.out.print("Enter new employee job title (or press Enter to keep the same): ");
                String jobTitle = scanner.nextLine();
                if (!jobTitle.isEmpty()) {
                    employee.jobTitle = jobTitle;
                }
                System.out.print("Enter new employee contact info (or press Enter to keep the same): ");
                String contactInfo = scanner.nextLine();
                if (!contactInfo.isEmpty()) {
                    employee.contactInfo = contactInfo;
                }
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Employee employee : employees) {
            if (employee.id == id) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {
        EmployeeManagementApplication application = new EmployeeManagementApplication();
        application.run();
    }
}