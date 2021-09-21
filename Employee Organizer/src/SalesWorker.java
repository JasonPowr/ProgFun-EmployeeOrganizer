public class SalesWorker extends Employee{    //sales worker class that extends the abstract employee class
    private double percentageOfSalary;         //private percent of salary

    public SalesWorker(double hoursWorked, double hourlyRate, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhoneNumber, String employeePPS, double percentageOfSalary) {
        super(hoursWorked, hourlyRate, employeeFirstName, employeeLastName, employeeEmail, employeePhoneNumber, employeePPS);       //constructor that includes call to abstract employee class

        if(Utilities.validDoubleRange(0,20,percentageOfSalary)) {
            this.percentageOfSalary = percentageOfSalary;                       //validation for percentage of salary to make sure its a number between 0 - 20
        }else{
            this.percentageOfSalary = 0;
        }
    }

    public double getPercentageOfSalary() {
        if(Utilities.validDoubleRange(0,20,percentageOfSalary)) {       //getter for percentage of salary + validation
            return percentageOfSalary;
        }else{
            return 0;
        }
    }

    public void setPercentageOfSalary(double percentageOfSalary) {
        if(Utilities.validDoubleRange(0,20,percentageOfSalary)) {       //setter for percentage of salary + validation
            this.percentageOfSalary = percentageOfSalary;
        }
    }

    public double calculateSalary() {
     return getSalary() + percentageOfSalary*2;             //gets the getSalary and adds it to the percentage of the Salary
    }
}
