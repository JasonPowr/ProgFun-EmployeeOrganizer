/**
 * The EMPAPI class manages all the action for the app
 * including adding, deleting, reading and performing
 * different actions on the array lists.
 *
 * @AUTHOR   JASON POWER (20076537)
 * @VESION   FINAL VERSION
 *
 */


/**
 * Importing everthing needed for the api class including
 * everything for saving and loading
 */

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EMPAPI {
    /**
     * creating an employees arraylist
     */
    private ArrayList<Employee> employees;

    /**
     * constructor thats instancating the arraylist above
     */
    public EMPAPI() {
        employees = new ArrayList<Employee>();
    }

    /**
     * getter that returns the employees arraylist
     */

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Adds an employee to the employee arraylist
     */

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * adds an employee to a managers department
     * done using Type casting which changes the type of managerDept from Employee
     * to Manager.
     * Refrence: "https://www.baeldung.com/java-type-casting"
     * @param employeeIndex the employee to move to department
     * @param departmentIndex the department
     */
    public boolean addEmployeeToDepartment(int employeeIndex, int departmentIndex){
        if(employees.isEmpty()) {
            return false;
        }else{
            Employee employeeToMove  = employees.get(employeeIndex);
            Employee managerDept = employees.get(departmentIndex);
            if(managerDept instanceof Manager){
                ((Manager) managerDept).addDeptEmployee(employeeToMove);
            }
            return true;
        }
    }

    /**
     * getter for the employee arraylist
     * @param index position of the employee in the arraylist
     * @return employee object
     */

    public Employee getEmployee(int index) {
        if (index < employees.size()) {
            return employees.get(index);
        } else {
            return null;
        }
    }

    /**
     * removes the employee object in the arraylist as long as it is
     * less then the amount of objects in the array
     * @param index position of the employee in the arraylist
     */

    public Employee removeEmployee(int index) {
        if (index < employees.size()) {
            employees.remove(index);
            return getEmployee(index);
        } else {
            return null;
        }
    }

    /**
     * Gets the number of employees
     * @return the number of employees
     */

    public int numberOfEmployees() {
            return employees.size();
    }

    /**
     * Goes through the employees arraylist and creates a list
     * of all the employees in the arraylist
     * @return A list of employees
     */

    public String listEmployees() {
        if (employees.isEmpty()) {
            return "No Employees stored";
        } else {
            String listEmployees = "";
            for (int i = 0; i < employees.size(); i++) {
                listEmployees = listEmployees + i + ": " + employees.get(i);
            }
            return listEmployees;
        }
    }

    /**
     * When the name of a manager is entered it cycles through the arraylist
     * and creates a list of all the employees in that managers department
     * Done using casting to access the managers class referenced above
     * @param managerName name of the manager
     * @return list of employees in the managers department
     */

    public String listManagerEmployees(String managerName) {
        Manager manager = (Manager) employees.get(0);
        String listOfEmployees = "";
        for(int i = 0; i < employees.size();i++){
            if((employees.get(i).getEmployeeFirstName().toUpperCase().contains(managerName.toUpperCase()))){
                listOfEmployees = manager.getDept().get(i).toString()+"\n";
            }
        }
        if(listOfEmployees.equals("")){
            return "No Manager by that name";
        }
        else{
            return listOfEmployees;
        }
    }

    /**
     * Creates a list of all the managers in the arraylist in this case each
     * manager should have a hourly rate of 15
     * @return a list of managers
     */

    public String listManagerEmployees() {
        if (employees.isEmpty()) {
            return "No Employees stored";
        } else {
            String listOfManagers = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) instanceof Manager) {
                    listOfManagers += +i + ": " + employees.get(i);
                }
            }
            return listOfManagers;
        }
    }

    /**
     * Searches through the employee arraylist and returns the employee
     * with that last name
     * @param lastName last name of employee
     * @return employee object
     */

    public String searchEmployeeSecondName(String lastName){
        String matchingLastName = "";
        for(Employee employee:employees){
            if(employee.getEmployeeLastName().toUpperCase().contains(lastName.toUpperCase())){
                matchingLastName += employee +"\n";
            }
        }
        if(matchingLastName.equals("")){
            return "No Employee by that name";
        }
        else{
            return matchingLastName;
        }
    }

    /**
     * Cycles through the employees arraylist and adds up all the total salaries of each
     * of the employees
     * @return the total amount of salaries owed
     */

    public double totalSalariesOwed(){
        double totalSalaries = 0.0;
        if(employees.isEmpty()){
            return 0.0;
        }else{
            for(int i = 0; i < employees.size(); i++){
                totalSalaries = totalSalaries + employees.get(i).getSalary();
            }
            return  totalSalaries;
        }
    }

    /**
     * Cycles through the employees arraylist and adds up all the total salaries of each
     * of the employees and then divides by the amount of employees in the arraylist
     * @return the average amount of salaries owed
     */

    public double avgSalariesOwed() {
        double totalSalaries = 0;
        if (employees.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < employees.size(); i++) {
                totalSalaries += employees.get(i).getSalary();
            }
            return totalSalaries/employees.size();
        }
    }

    /**
     * Cycles through the employees arraylist and gets the employee with the
     * highest pay
     * @return highest paid employee
     */
    public Employee employeeWithHighestPay(){
        if(employees.size() == 0){
            return null;
        }else{
            Employee employeeWithHighestPay  = employees.get(0);
            for(int i = 1; i < employees.size(); i++){
                if(employees.get(i).getSalary() > employees.get(i-1).getSalary() ){
                    employeeWithHighestPay = getEmployee(i);
                }
            }
            return employeeWithHighestPay;
        }
    }

    /**
     *Cycles through the employees arraylist and sorts all employees by firstname
     * in alphabetical order
     */

    public void sortEmployeeByFirstName() {
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getEmployeeFirstName().compareTo(
                        employees.get(highestIndex).getEmployeeFirstName()) > 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     *Cycles through the employees arraylist and sorts all employees by secondname
     * in alphabetical order
     */


    public void sortEmployeeBySecondName(){
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getEmployeeLastName().compareTo(
                        employees.get(highestIndex).getEmployeeLastName()) > 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     *Cycles through the employees arraylist and sorts all employees by hourly rate
     * in alphabetical order
     */

    public void sortEmployeeByHourlyRate(){
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getHourlyRate() < employees.get(highestIndex).getHourlyRate()) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     * Swaps the positions of the objects in an array
     * @param employees the employees arraylist
     * @param currentIndex the current index in the employees arraylist
     * @param highestIndex the highest index in the employees arraylist
     */


    private void swapEmployees(ArrayList<Employee> employees ,int currentIndex,int highestIndex){
        Employee currentEmployee = employees.get(currentIndex);
        Employee highestEmployee = employees.get(highestIndex);

        employees.set(currentIndex,highestEmployee);
        employees.set(highestIndex,currentEmployee);
    }

    /**
     *Loads all employees in an arraylist to an xml file called employees.xml
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employees.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    /**
     *Saves all employees in an arraylist to an xml file called employees.xml
     */

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employees.xml"));
        out.writeObject(employees);
        out.close();
    }


}



