public abstract class Employee {  //abstract employee class
    private static double NORMAL_WORKWEEK = 39.5;  //static variable for normal work workweek
    private static double MIN_WAGE = 9.80;   //static variable for minimum wage

    private double hoursWorked;
    private double hourlyRate;

    private String employeeFirstName;           //variables for employee information
    private String employeeLastName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private String employeePPS;

    public Employee(double hoursWorked, double hourlyRate, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhoneNumber, String employeePPS) {  //constructor for employee class
        if(hoursWorked > 0) {
            this.hoursWorked = hoursWorked;   //setting validation for hoursworked so it cant be below zero
        }else{
            this.hoursWorked = 0;
        }

        if(hourlyRate > MIN_WAGE) {
            this.hourlyRate = hourlyRate;
        }else{                                 //makes sure the hourlyrate cant be below minimum wage
            this.hourlyRate = MIN_WAGE;
        }

        this.employeeFirstName = Utilities.max20Chars(employeeFirstName);    //using the utilities class to make sure the employee first name is less than 20 characters
        this.employeeLastName = Utilities.max20Chars(employeeLastName);      //using the utilities class to make sure the employee last name is less than 20 characters

        if(Utilities.validEmail(employeeEmail)) {
            this.employeeEmail = employeeEmail;
        }else{                                                                            //using the utilities class to make sure an email has a @ and a .
            this.employeeEmail = "invalid format email. Needs to contain . and @";
        }

        if(Utilities.onlyContainsNumbers(employeePhoneNumber)) {
            this.employeePhoneNumber = employeePhoneNumber;
        }else{                                                      //using the utilities to make sure only numbers are entered for the phone number
            this.employeePhoneNumber = "unKnown";
        }

        this.employeePPS = Utilities.validPPS(employeePPS);

    }


    public static double getNormalWorkweek() {  //getter for normal work week
        return NORMAL_WORKWEEK;
    }

    public static void setNormalWorkweek(double normalWorkweek) {
        NORMAL_WORKWEEK = normalWorkweek;  //setter for normal work week
    }

    public static double getMinWage() {   //getter for min wage
        return MIN_WAGE;
    }

    public static void setMinWage(double minWage) {  //setter for min wage
        MIN_WAGE = minWage;
    }

    public double getHoursWorked() {
        if(hoursWorked > 0) {
            return hoursWorked;        //getter for hoursworked + validation
        }else{
           return 0;
        }
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked > 0) {                           //setter for hoursworked + validation
            this.hoursWorked = hoursWorked;
        }
    }

    public double getHourlyRate() {
        if(hourlyRate > MIN_WAGE) {
            return hourlyRate;
        }else{                              //getter for hourly rate incuding validation
            return MIN_WAGE;
        }
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate > MIN_WAGE) {
            this.hourlyRate = hourlyRate;   //setter for hourly rate
        }
    }

    public String getEmployeeFirstName() {
        return Utilities.max20Chars(employeeFirstName);     //getter for employee first name + validation
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        if(employeeFirstName.length() < 30){                        //setter for employee first name + validation
            this.employeeFirstName = Utilities.max20Chars(employeeFirstName);
        }
    }

    public String getEmployeeLastName() {               //getter for employee first last + validation
        return Utilities.max20Chars(employeeLastName);
    }

    public void setEmployeeLastName(String employeeLastName) {
        if(employeeLastName.length() < 30){                     //setter for employee first last + validation
            this.employeeLastName = Utilities.max20Chars(employeeLastName);
        }
    }

    public String getEmployeeEmail() {
        if(Utilities.validEmail(employeeEmail)) {
            return employeeEmail;                       //getter for employee email + validation
        }else{
            return "invalid format email. Needs to contain . and @";
        }
    }

    public void setEmployeeEmail(String employeeEmail) {
        if(Utilities.validEmail(employeeEmail)) {       //setter for employee email + validation
           this.employeeEmail = employeeEmail;
        }
    }

    public String getEmployeePhoneNumber() {
        if(Utilities.onlyContainsNumbers(employeePhoneNumber)) {
            return employeePhoneNumber;                 //getter for employee phone number + validation
        }else{
            return  "unknown";
        }
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        if(Utilities.onlyContainsNumbers(employeePhoneNumber)) {    //setter for employee phone number + validation
            this.employeePhoneNumber = employeePhoneNumber;
        }
    }

    public String getEmployeePPS() {
        return Utilities.validPPS(employeePPS);             //getter for employee pps + validation
    }

    public void setEmployeePPS(String employeePPS) {
        if(employeePPS.length() < 30){              //setter for employee pps + validation
            this.employeePPS = Utilities.max20Chars(employeePPS);
        }
    }

    public double getOverTime(){
        double overTimeRate = hourlyRate*2;
        double overTime = 0;
            if(hoursWorked < NORMAL_WORKWEEK){
                overTime = 0;                           //if the hours worked is more than the normal work week it multiplies the over time hours by double the
            }else{                                      //hourly rate if its less over time is zero.
                overTime = (hoursWorked-NORMAL_WORKWEEK)*(overTimeRate);
            }

        return overTime;
    }

    public double getSalary(){
        double basicSalary;
        if(hoursWorked < NORMAL_WORKWEEK) {
            basicSalary = hourlyRate*hoursWorked;
        }else {                                                         //if there is no overtime salary is hours worked multiplied by hourly rate
            basicSalary = (hourlyRate*NORMAL_WORKWEEK) + getOverTime(); // if there is overtime it adds the overtime to the basic salary.
        }
        return basicSalary;
    }

    public abstract double calculateSalary();  // abstract method calculate salary

    @Override
    public String toString() {
        return  "Name :" +employeeFirstName + employeeLastName + "\n"+
                "Employee Phone Number :"+employeePhoneNumber+ "\n"+
                "Employee Email :"+employeeEmail+ "\n"+                             //to String for employees
                "Employee PPS :" + employeePPS +"\n"+
                "Hours Worked :"+ hoursWorked +"\n"+
                "Hourly Rate :"+ hourlyRate + "per hour"+"\n"+
                "--------------------------------------------------------"+"\n";
    }


}
