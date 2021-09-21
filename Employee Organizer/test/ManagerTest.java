import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Test Class for the (concrete) Manager class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */


public class ManagerTest {

    private Manager manNormal1, manNormal2;
    private AdminWorker admin1;
    private SalesWorker sales1, sales2;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        manNormal1 = new Manager(30, 20,"Digby", "Tillman","Digby@Tillman.com","1234567899","1234567ui");
        admin1 = new AdminWorker(20, 10, "Alexander", "Zhang", "Alexander@Zhang.com","6583659365","1234567iy",10);
        sales1 = new SalesWorker(20, 10, "Cherry","Morse","Cherry@Morse.com","7694669365","7693557ji",10);
        sales2 = new SalesWorker(20, 10, "Aayan","Downs","Ayan@Downs.com","1238654720","6583558fu",10);

        manNormal2 = new Manager(20, 100, "Faiz","Buckley","Faiz@Buckley.com","7694749562","8506739hv");
        manNormal2.addDeptEmployee(admin1);
        manNormal2.addDeptEmployee(sales1);
    }

    /**
     * Test method for Manager constructor
     */
    @Test
    public void testManager() {
        assertEquals(30, manNormal1.getHoursWorked(), 0.01);
        assertEquals(20, manNormal1.getHourlyRate(), 0.01);
        assertEquals("Digby", manNormal1.getEmployeeFirstName());
        assertEquals("Tillman",manNormal1.getEmployeeLastName());
        assertEquals("Digby@Tillman.com",manNormal1.getEmployeeEmail());
        assertEquals("1234567899",manNormal1.getEmployeePhoneNumber());
        assertEquals("1234567ui",manNormal1.getEmployeePPS());
        assertEquals(0, manNormal1.ManagerDepartmentSize());

        assertEquals(20, manNormal2.getHoursWorked(), 0.01);
        assertEquals(100, manNormal2.getHourlyRate(), 0.01);
        assertEquals("Faiz",manNormal2.getEmployeeFirstName());
        assertEquals("Buckley",manNormal2.getEmployeeLastName());
        assertEquals("Faiz@Buckley.com",manNormal2.getEmployeeEmail());
        assertEquals("7694749562",manNormal2.getEmployeePhoneNumber());
        assertEquals("8506739hv",manNormal2.getEmployeePPS());
        assertEquals(2, manNormal2.ManagerDepartmentSize());
    }

    /**
     * Test method for getDept and setDept. (No validation on this field)
     */
    @Test
    public void testConstructorsGetSetDept() {
        //todo - this is a sample test method idea that you could complete
    }

    @Test
    public void testCalculateSalary() {
        // manager with no employees
        assertEquals(600, manNormal1.calculateSalary(), 0.01);
        assertEquals(210, admin1.calculateSalary(), 0.01);
        assertEquals(220, sales1.calculateSalary(), 0.01);
        assertEquals(2004.3, manNormal2.calculateSalary(), 0.01);
        manNormal2.addDeptEmployee(sales2);
        assertEquals(2006.5, manNormal2.calculateSalary(), 0.01);
    }

    /**
     * Test method for addDeptEmployee(Employee).
     */
    @Test
    public void testAddDeptEmployee() {
        assertEquals(0, manNormal1.ManagerDepartmentSize());
        manNormal1.addDeptEmployee(sales1);
        assertEquals(1, manNormal1.ManagerDepartmentSize());
        assertEquals("Cherry",manNormal1.getDepartment(0).getEmployeeFirstName());
    }

    @Test
    public void removeEmployee() {
        assertEquals(2, manNormal2.ManagerDepartmentSize());
        manNormal2.removeDepartment(0);
        assertEquals(1, manNormal2.ManagerDepartmentSize());
        assertEquals("Cherry", manNormal2.getDepartment(0).getEmployeeFirstName());
    }

    @Test
    public void setDept() {
        ArrayList<Employee> newDept = new ArrayList<Employee>();
        newDept.add(new AdminWorker(20, 10, "Nicola","Abbot","Nicola@Abbot.com","5768475937","7693556cg",1));
        newDept.add(new SalesWorker(20, 10, "Keir","Whitmore","Keir@Whitmore.com","6684623487","6693658cf",0.1));
        newDept.add(new AdminWorker(20, 10, "Jun","Ochoa","Jun@Ochoa.com","8593759762","6592655cg",1));
        manNormal2.setDept(newDept);
        assertEquals(3, manNormal2.ManagerDepartmentSize());
        assertEquals("Nicola", manNormal2.getDepartment(0).getEmployeeFirstName());
    }
}