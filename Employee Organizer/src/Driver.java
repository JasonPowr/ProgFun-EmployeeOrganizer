public class Driver {
    private EMPAPI empAPI;  //instanciating the empAPI class


    public static void main(String args[]){
        Driver app = new Driver();
        app.run();
    }

    public Driver(){
        empAPI = new EMPAPI();      //constructor for the driver class
    }

    private int mainMenu() {
        System.out.println("1) Add an employee (Manager)");
        System.out.println("2) Add an employee (Sales worker)");
        System.out.println("3) Add an employee (Admin Worker)");
        System.out.println("4) Add an existing employee to a department");
        System.out.println("5) Delete an employee");
        System.out.println("-----------------------------------------------------------");
        System.out.println("6) Find the total of the salaries owed to all employees");
        System.out.println("7) Find the average of the salaries owed to all employees");
        System.out.println("8) Print the employee with the highest pay");                       //for displaying the menu
        System.out.println("-----------------------------------------------------------");
        System.out.println("9) List all employees in the company in ascending alphabetical order (first name)");
        System.out.println("10) List all employees in the company in ascending alphabetical order (second name)");
        System.out.println("11) List all employees in the company in ascending order (hourly rate)");
        System.out.println("-----------------------------------------------------------");
        System.out.println("12) Search the system for an employee by second name");
        System.out.println("13) Search the system for an employee within a given managers department");
        System.out.println("-----------------------------------------------------------");
        System.out.println("14) Save to XML");
        System.out.println("15) Load to XML");
        System.out.println("-----------------------------------------------------------");
        System.out.println("0) Exit");
        int choice = ScannerInput.readNextInt("==>>");
        return choice;
    }

    private void run(){
        int choice = mainMenu();
        while (choice != 0) {
            switch (choice) {
                case 1: addManager();
                    break;
                case 2: addSalesWorker();
                    break;
                case 3: addAdminWorker();
                    break;
                case 4: addEmpToManager();
                    break;
                case 5: deleteEmployeeByIndex();
                    break;
                case 6: System.out.println(empAPI.totalSalariesOwed()); ;
                    break;
                case 7: System.out.println(empAPI.avgSalariesOwed());               //switch case for menu
                    break;
                case 8: System.out.println(empAPI.employeeWithHighestPay());
                    break;
                case 9: sortEmployeeByFirstName();
                    break;
                case 10: sortEmployeeByLastName();
                    break;
                case 11: sortEmployeeByHourlyRate();
                    break;
                case 12: searchBySecondName();
                    break;
                case 13:searchByDepartmentName();
                    break;
                case 14:
                    try{
                        empAPI.save();
                    }
                    catch (Exception e){
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 15:
                    try{
                        empAPI.load();
                    }
                    catch (Exception e){
                        System.err.println("Error loading from file: " + e);
                    }
                    break;
            }
            System.out.println("\nPress any key to continue...");
            ScannerInput.validNextLine("");
            choice = mainMenu();
        }
        System.out.println("Exiting........bye");
        System.exit(0);
    }

    public void addManager(){
     String employeeFirstName = ScannerInput.validNextLine("Please enter the first name of the manager: ");
     String employeeLastName = ScannerInput.validNextLine("Please enter the last name of the manager: ");
     String employeeEmail = ScannerInput.validNextLine("Please enter the Email address of the manager: ");
     String employeePhoneNumber = ScannerInput.validNextLine("Please enter the Phone number of the manager: ");             //for adding a manager
     String employeePPS = ScannerInput.validNextLine("Please enter the PPS Number of the manager: ");
     double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate of the manager: ");
     int hoursWorked = ScannerInput.readNextInt("Please enter the Hours Worked of the manager: ");
     empAPI.addEmployee(new Manager(hoursWorked,hourlyRate,employeeFirstName,employeeLastName,employeeEmail,employeePhoneNumber,employeePPS));
    }


    public void addSalesWorker(){
        String employeeFirstName = ScannerInput.validNextLine("Please enter the first name of the Sales Worker");
        String employeeLastName = ScannerInput.validNextLine("Please enter the last name of the Sales Worker");
        String employeeEmail = ScannerInput.validNextLine("Please enter the Email address of the Sales Worker");
        String employeePhoneNumber = ScannerInput.validNextLine("Please enter the Phone number of the Sales Worker");           //for adding a salesworker
        String employeePPS = ScannerInput.validNextLine("Please enter the PPS Number of the Sales Worker");
        double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate of the Sales Worker");
        int hoursWorked = ScannerInput.readNextInt("Please enter the Hours Worked of the Sales Worker");
        double percentageOfSalary = ScannerInput.readNextDouble("Please enter the Percentage Of Salary of the Sales Worker");
        empAPI.addEmployee(new SalesWorker(hoursWorked,hourlyRate,employeeFirstName,employeeLastName,employeeEmail,employeePhoneNumber,employeePPS,percentageOfSalary));
    }

        public void addAdminWorker(){
            String employeeFirstName = ScannerInput.validNextLine("Please enter the first name of the Admin Worker");
            String employeeLastName = ScannerInput.validNextLine("Please enter the last name of the Admin Worker");
            String employeeEmail = ScannerInput.validNextLine("Please enter the Email address of the Admin Worker");
            String employeePhoneNumber = ScannerInput.validNextLine("Please enter the Phone number of the Admin Worker");           //for adding a admin worker
            String employeePPS = ScannerInput.validNextLine("Please enter the PPS Number of the Admin Worker");
            double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate of the Admin Worker");
            int hoursWorked = ScannerInput.readNextInt("Please enter the Hours Worked of the Admin Worker");
            double fixedBonusAmount = ScannerInput.readNextDouble("Please enter the fixed bonus amount of the Admin Worker");
            empAPI.addEmployee(new AdminWorker(hoursWorked,hourlyRate,employeeFirstName,employeeLastName,employeeEmail,employeePhoneNumber,employeePPS,fixedBonusAmount));
        }


        public void addEmpToManager(){
        System.out.println(empAPI.listEmployees());
        int employeeIndex = ScannerInput.readNextInt("Please enter the index of the Employee you wish to add to a mangers department");
        System.out.println(empAPI.listManagerEmployees());                                                                                             //adding a employee to a mangers department
        int departmentIndex = ScannerInput.readNextInt("Please enter the index of the managers you wish to add the employee to ");
        empAPI.addEmployeeToDepartment(employeeIndex,departmentIndex);
        }

        public void deleteEmployeeByIndex(){
            System.out.println(empAPI.listEmployees());
            int index = ScannerInput.readNextInt("Please enter the index of the employee you wish to remove ");     //deleting an employee
            empAPI.removeEmployee(index);
        }

        public void searchBySecondName(){
            String lastName = ScannerInput.validNextLine("Please enter the last name of the employee you wish to search for");      //searches for an employee by second name
            System.out.println(empAPI.searchEmployeeSecondName(lastName));
        }

    public void searchByDepartmentName(){
        String DepartmentName = ScannerInput.validNextLine("Please enter the Name of the Department");      //searches for an employee by department name
        System.out.println(empAPI.listManagerEmployees(DepartmentName));
    }

        public void sortEmployeeByFirstName(){
            empAPI.sortEmployeeByFirstName();
            System.out.println(empAPI.listEmployees());     //sorts employees by first name
        }

         public void sortEmployeeByLastName(){
            empAPI.sortEmployeeBySecondName();
            System.out.println(empAPI.listEmployees());     //sorts employees by last name
         }

        public void sortEmployeeByHourlyRate(){
            empAPI.sortEmployeeByHourlyRate();          //sorts employees by hourly rate
            System.out.println(empAPI.listEmployees());
    }

}






