public class AdminWorker extends Employee {  //admin worker class that extends the employee class
    private double fixedBonusAmount;        //private double field called fixed bonus amount to be added to the salary

    public AdminWorker(double hoursWorked, double hourlyRate, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhoneNumber, String employeePPS, double fixedBonusAmount) {
        super(hoursWorked, hourlyRate, employeeFirstName, employeeLastName, employeeEmail, employeePhoneNumber, employeePPS);   //constructor with call to the super class

        if(fixedBonusAmount > 0) {
            this.fixedBonusAmount = fixedBonusAmount;      //making sure the fixed bonus amount is not zero
        }else{
            this.fixedBonusAmount = 0;
        }
    }

    public double getFixedBonusAmount() {
        if(fixedBonusAmount > 0) {
            return fixedBonusAmount;            //getter for fixed bonus amount + validation
        }else{
            return 0;
        }
    }

    public void setFixedBonusAmount(double fixedBonusAmount) {
        if(fixedBonusAmount > 0){                   //setter for fixed bonus amount + validation
            this.fixedBonusAmount = fixedBonusAmount;
        }
    }

    public double calculateSalary() {
        return getSalary() + fixedBonusAmount;      //adds the fixed bonus amount to the total salary
    }
}
