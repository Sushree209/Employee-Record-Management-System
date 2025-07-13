import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Employee Record System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Sort Employees");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> sortEmployees();
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        employeeList.add(new Employee(id, name, dept, salary));
        System.out.println("Employee added successfully.");
    }

    static void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee e : employeeList) {
                System.out.println(e);
            }
        }
    }

    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (Employee e : employeeList) {
            if (e.id == id) {
                System.out.println("Found: " + e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        for (Employee e : employeeList) {
            if (e.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                e.name = sc.nextLine();
                System.out.print("Enter New Department: ");
                e.department = sc.nextLine();
                System.out.print("Enter New Salary: ");
                e.salary = sc.nextDouble();
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Employee> itr = employeeList.iterator();
        while (itr.hasNext()) {
            if (itr.next().id == id) {
                itr.remove();
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void sortEmployees() {
        System.out.println("Sort by: 1.ID 2.Name 3.Salary");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> employeeList.sort(Comparator.comparingInt(e -> e.id));
            case 2 -> employeeList.sort(Comparator.comparing(e -> e.name));
            case 3 -> employeeList.sort(Comparator.comparingDouble(e -> e.salary));
            default -> System.out.println("Invalid option!");
        }
        System.out.println("Sorted successfully.");
    }
}
    

