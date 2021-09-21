import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the abstract class Employee
 *
 * Note that we are testing via the AdminWorker class, but we are
 * only testing methods that reside in the Employee class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */

public class EmployeeTest {

    private AdminWorker empNormal1, empNormal2;
    private AdminWorker empTestValidation;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        empNormal1 = new AdminWorker(20, 10, "Dan","Yu","employee@employee.com","1237562759","8536174ca",9.80);
        empNormal2 = new AdminWorker( 40.5, 10,"Linda","Beltran","testemployee@employee.com","0732135642","1234567iw",10.50);
        empTestValidation = new AdminWorker(-1, 5, "123456789101112131415161718","123456789101112131415161718","employee@employee","12345678465673ke","123456789123456",-1);
    }

    /**
     * Test method for Employee constructor
     */
    @Test
    public void testConstructor() {
        //test on valid data
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        assertEquals(10, empNormal1.getHourlyRate(), 0.01);
        assertEquals("Dan", empNormal1.getEmployeeFirstName());
        assertEquals("Yu", empNormal1.getEmployeeLastName());
        assertEquals("employee@employee.com", empNormal1.getEmployeeEmail());
        assertEquals("1237562759", empNormal1.getEmployeePhoneNumber());
        assertEquals("8536174ca", empNormal1.getEmployeePPS());
        assertEquals(9.80, empNormal1.getFixedBonusAmount(), 0.01);

        assertEquals(40.5, empNormal2.getHoursWorked(), 0.01);
        assertEquals(10, empNormal2.getHourlyRate(), 0.01);
        assertEquals("Linda", empNormal2.getEmployeeFirstName());
        assertEquals("Beltran", empNormal2.getEmployeeLastName());
        assertEquals("testemployee@employee.com", empNormal2.getEmployeeEmail());
        assertEquals("0732135642", empNormal2.getEmployeePhoneNumber());
        assertEquals("1234567iw", empNormal2.getEmployeePPS());
        assertEquals(10.50, empNormal2.getFixedBonusAmount(), 0.01);

        //test on invalid data
        assertEquals(0, empTestValidation.getHoursWorked(), 0.01);
        assertEquals(9.80, empTestValidation.getHourlyRate(), 0.01);
        assertEquals("12345678910111213141", empTestValidation.getEmployeeFirstName());
        assertEquals("12345678910111213141",  empTestValidation.getEmployeeLastName());
        assertEquals("invalid format email. Needs to contain . and @",  empTestValidation.getEmployeeEmail());
        assertEquals("unknown",  empTestValidation.getEmployeePhoneNumber());
        assertEquals("123456789",  empTestValidation.getEmployeePPS());
        assertEquals(0,  empTestValidation.getFixedBonusAmount(), 0.01);
    }

    /**
     * Test method for getSalary(), testing for employees with and without overtime.
     */
    @Test
    public void testgetSalary(){
        //employee under NORMAL_WORKING_WEEKS hours
        assertEquals(200, empNormal1.getSalary(), 0.01 );
        //employee with overtime + fixed bonus
        assertEquals(415, empNormal2.getSalary(), 0.01 );
        empNormal1.setHourlyRate(0);
        assertEquals(200, empNormal1.getSalary(), 0.01 );
        empNormal1.setHourlyRate(20);
        assertEquals(400, empNormal1.getSalary(), 0.01 );
        empNormal1.setHourlyRate(20);
        assertEquals(400, empNormal1.getSalary(), 0.01 );
        empNormal1.setHoursWorked(40.5);
        empNormal1.setHourlyRate(20);
        assertEquals(830, empNormal1.getSalary(), 0.01);
    }

    /**
     * Test method for getters and setters.
     */
    @Test
    public void testSettersGetters() {
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(40);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(-1);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);

        empNormal1.setHourlyRate(40);
        assertEquals(40, empNormal1.getHourlyRate(), 0.01);
        empNormal1.setHourlyRate(9.79);
        assertEquals(40, empNormal1.getHourlyRate(), 0.01);

        empNormal1.setEmployeeFirstName("Dan");
        assertEquals("Dan", empNormal1.getEmployeeFirstName());
        empNormal1.setEmployeeFirstName("1234567891011121314151617");
        assertEquals("12345678910111213141", empNormal1.getEmployeeFirstName());

        empNormal1.setEmployeeLastName("Yu");
        assertEquals("Yu", empNormal1.getEmployeeLastName());
        empNormal1.setEmployeeLastName("1234567891011121314151617");
        assertEquals("12345678910111213141", empNormal1.getEmployeeLastName());

        empNormal1.setEmployeeEmail("employee@employee.com");
        assertEquals("employee@employee.com", empNormal1.getEmployeeEmail());
        empNormal1.setEmployeeEmail("employee@employee");
        assertEquals("employee@employee.com", empNormal1.getEmployeeEmail());

        empNormal1.setEmployeePhoneNumber("1237562759");
        assertEquals("1237562759", empNormal1.getEmployeePhoneNumber());
        empNormal1.setEmployeePhoneNumber("1237562759567656776543gdhjcfdk");
        assertEquals("1237562759", empNormal1.getEmployeePhoneNumber());

        empNormal1.setEmployeePPS("8536174ca");
        assertEquals("8536174ca" , empNormal1.getEmployeePPS());
        empNormal1.setEmployeePPS("8536174caadasad");
        assertEquals("8536174ca" , empNormal1.getEmployeePPS());

        empNormal1.setFixedBonusAmount(9.80);
        assertEquals(9.80, empNormal1.getFixedBonusAmount(), 0.01);
        empNormal1.setFixedBonusAmount(-7.23);
        assertEquals(9.80, empNormal1.getFixedBonusAmount(), 0.01);
    }

    /**
     * Test method for getOverTime (= hourly-rate*2 * (the number of hours overtime))
     */
    @Test
    public void getOverTime() {
        assertEquals(0, empNormal1.getOverTime(), 0.01);
        assertEquals(20, empNormal2.getOverTime(), 0.01);
        empNormal2.setHourlyRate(20);
        assertEquals(40, empNormal2.getOverTime(), 0.01);
    }

    /**
     * Test method for toString - checks that all data fields are present.
     */
    @Test
    public void testToString() {
        assertTrue(empNormal1.toString().contains("Hours Worked"));
        assertTrue(empNormal1.toString().contains("20"));
        assertTrue(empNormal1.toString().contains("per hour"));
        assertTrue(empNormal1.toString().contains("10"));
    }
}