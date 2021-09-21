import java.util.ArrayList;   //imports the Arraylist

public class Manager extends Employee {  //manager class that extends the super class employee
    private ArrayList<Employee> Dept;      //creates a Arraylist of employees called Dept

    public Manager(double hoursWorked, double hourlyRate, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhoneNumber, String employeePPS) {
        super(hoursWorked, hourlyRate, employeeFirstName, employeeLastName, employeeEmail, employeePhoneNumber, employeePPS);   //constructor with call to super class
        Dept = new ArrayList<Employee>();       //instantiating the arraylist
        if(hourlyRate > 15) {
            hourlyRate = hourlyRate;
        }else{                                 //makes sure the hourly rate cant be below 15 for managers
            hourlyRate = 15;
        }
    }

    public ArrayList<Employee> getDept() {
        return Dept;                        //getter for the Dept arraylist
    }



    public void setDept(ArrayList<Employee> dept) {
        this.Dept = dept;            //setter for the Dept arraylist
    }

    public double calculateSalary() {
        double managersBonus = 0;
        double salary = 0;
        if(getDept().isEmpty()){
            salary = getSalary();
        }else{
            for(int i =0; i < getDept().size(); i++) {                      //calculates the managers salary by cycyling through the Dept arraylist
                managersBonus += getDepartment(i).calculateSalary()*0.01;   // and adding 1% of each employees total salary if theres no employees in the Dept arraylist
            }                                                               //then salary is just hoursworked*hourly rate
            salary = getSalary() + managersBonus;
        } return salary;
    }

    public void addDeptEmployee(Employee employee) {
        Dept.add(employee);    //adds and employee to the Dept arraylist
    }

    public Employee getDepartment(int i){
        if(!Dept.isEmpty()){
            return Dept.get(i);
        }                                       //getter for Dept Arraylist by index
        else{
            return null;
        }
    }

    public boolean removeDepartment(int i){
        if((!Dept.isEmpty()) && Utilities.validIntNonNegative(i) && (i < Dept.size())){
            Dept.remove(i);
            return  true;               //removes an employee for the Dept arraylist
        }else{
            return false;
        }
    }

    public int ManagerDepartmentSize(){
        return Dept.size();
    }   //returns the Dept size

}

