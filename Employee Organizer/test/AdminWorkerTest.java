import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.ArrayList;


public class AdminWorkerTest {

    private AdminWorker admin1;
    private AdminWorker admin2;
    private AdminWorker admin3;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        admin1 = new AdminWorker(40,20,"Dillan","Joyce","Dillan@Joyce.com","47583659265","5669254gf",13);
        admin2 = new AdminWorker(30,10,"Colby","Chapman","Colby@Champman.com","4639254935","5630564nb",15);   //setting up the test
        admin3 = new AdminWorker(36,10,"Arthur","Morgan","Arthur@Morgan.com","48592048574","5639427hd",14);
    }

    @Test
    public void testAdminWorker(){
        assertEquals(40, admin1.getHoursWorked(), 0.01);
        assertEquals(20, admin1.getHourlyRate(), 0.01);
        assertEquals("Dillan", admin1.getEmployeeFirstName());
        assertEquals("Joyce", admin1.getEmployeeLastName());
        assertEquals("Dillan@Joyce.com",admin1.getEmployeeEmail());
        assertEquals("47583659265", admin1.getEmployeePhoneNumber());
        assertEquals("5669254gf", admin1.getEmployeePPS());
        assertEquals(13,admin1.getFixedBonusAmount(), 0.01);

        assertEquals(30, admin2.getHoursWorked(), 0.01);
        assertEquals(10, admin2.getHourlyRate(), 0.01);
        assertEquals("Colby", admin2.getEmployeeFirstName());                        //testing the adminworker
        assertEquals("Chapman", admin2.getEmployeeLastName());
        assertEquals("Colby@Champman.com",admin2.getEmployeeEmail());
        assertEquals("4639254935", admin2.getEmployeePhoneNumber());
        assertEquals("5630564nb", admin2.getEmployeePPS());
        assertEquals(15,admin2.getFixedBonusAmount(), 0.01);

        assertEquals(36, admin3.getHoursWorked(), 0.01);
        assertEquals(10, admin3.getHourlyRate(), 0.01);
        assertEquals("Arthur", admin3.getEmployeeFirstName());
        assertEquals("Morgan", admin3.getEmployeeLastName());
        assertEquals("Arthur@Morgan.com",admin3.getEmployeeEmail());
        assertEquals("48592048574", admin3.getEmployeePhoneNumber());
        assertEquals("5639427hd", admin3.getEmployeePPS());
        assertEquals(14,admin3.getFixedBonusAmount(), 0.01);
    }

    @Test
    public void getFixedBonusAmount() {
        admin1.getFixedBonusAmount();
        assertEquals(13,admin1.getFixedBonusAmount(), 0.01);

        admin2.getFixedBonusAmount();                                               //testing the get fixed bonus amount
        assertEquals(15,admin2.getFixedBonusAmount(), 0.01);

        admin3.getFixedBonusAmount();
        assertEquals(15,admin2.getFixedBonusAmount(), 0.01);
    }

    @Test
    public void setFixedBonusAmount() {
        admin1.setFixedBonusAmount(16);
        assertEquals(16,admin1.getFixedBonusAmount(), 0.01);

        admin2.setFixedBonusAmount(11);
        assertEquals(11,admin2.getFixedBonusAmount(), 0.01);        //testing the set fixed bonus amount

        admin3.setFixedBonusAmount(9);
        assertEquals(9,admin3.getFixedBonusAmount(), 0.01);

        admin3.setFixedBonusAmount(-1);
        assertEquals(9,admin3.getFixedBonusAmount(), 0.01);
    }

    @Test
    public void calculateSalary() {
        assertEquals(823, admin1.calculateSalary(), 0.01);
        assertEquals(315, admin2.calculateSalary(), 0.01);     //testing the calculate salary
        assertEquals(374, admin3.calculateSalary(), 0.01);
    }

}
