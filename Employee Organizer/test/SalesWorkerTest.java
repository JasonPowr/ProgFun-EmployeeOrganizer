import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
public class SalesWorkerTest {
    private SalesWorker sales1;
    private SalesWorker sales2;
    private SalesWorker sales3;
    private SalesWorker sales4ValPercentBonus;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */

    @Before
    public void setUp() throws Exception {
        sales1 = new SalesWorker(10,20,"Mike","Vaughn","Mike@Vaughn.com","5482419568","4519532hf",13);
        sales2 = new SalesWorker(45,10,"Arian","Grant","Arian@Grant.com","4519462819","4349254hd",3);
        sales3 = new SalesWorker(26,15,"Aisha","Mullen","Aisha@Mullen.com","4518432784","4529453hs",16);   //setting up the salesworker
        sales4ValPercentBonus = new SalesWorker(18,34.6,"Zofia","Kline","Zofia@Kline.com","6296439264","6295729hd",89);
    }

    @Test
    public void testSalesWorker(){
        assertEquals(10, sales1.getHoursWorked(), 0.01);
        assertEquals(20, sales1.getHourlyRate(), 0.01);
        assertEquals("Mike",sales1.getEmployeeFirstName());
        assertEquals("Vaughn",sales1.getEmployeeLastName());
        assertEquals("Mike@Vaughn.com",sales1.getEmployeeEmail());
        assertEquals("5482419568",sales1.getEmployeePhoneNumber());
        assertEquals("4519532hf",sales1.getEmployeePPS());
        assertEquals(13, sales1.getPercentageOfSalary(), 0.01);

        assertEquals(45, sales2.getHoursWorked(), 0.01);
        assertEquals(10, sales2.getHourlyRate(), 0.01);
        assertEquals("Arian",sales2.getEmployeeFirstName());
        assertEquals("Grant",sales2.getEmployeeLastName());
        assertEquals("Arian@Grant.com",sales2.getEmployeeEmail());          //testing the sales worker
        assertEquals("4519462819",sales2.getEmployeePhoneNumber());
        assertEquals("4349254hd",sales2.getEmployeePPS());
        assertEquals(3, sales2.getPercentageOfSalary(), 0.01);

        assertEquals(26, sales3.getHoursWorked(), 0.01);
        assertEquals(15, sales3.getHourlyRate(), 0.01);
        assertEquals("Aisha",sales3.getEmployeeFirstName());
        assertEquals("Mullen",sales3.getEmployeeLastName());
        assertEquals("Aisha@Mullen.com",sales3.getEmployeeEmail());
        assertEquals("4518432784",sales3.getEmployeePhoneNumber());
        assertEquals("4529453hs",sales3.getEmployeePPS());
        assertEquals(16, sales3.getPercentageOfSalary(), 0.01);

        assertEquals(18, sales4ValPercentBonus.getHoursWorked(), 0.01);
        assertEquals(34.6, sales4ValPercentBonus.getHourlyRate(), 0.01);
        assertEquals("Zofia",sales4ValPercentBonus.getEmployeeFirstName());
        assertEquals("Kline",sales4ValPercentBonus.getEmployeeLastName());
        assertEquals("Zofia@Kline.com",sales4ValPercentBonus.getEmployeeEmail());
        assertEquals("6296439264",sales4ValPercentBonus.getEmployeePhoneNumber());
        assertEquals("6295729hd",sales4ValPercentBonus.getEmployeePPS());
        assertEquals(0,sales4ValPercentBonus.getPercentageOfSalary(),0.01);
    }

    @Test
    public void getPercentageOfSalary() {
        sales1.getPercentageOfSalary();
        assertEquals(13, sales1.getPercentageOfSalary(), 0.01);

        sales2.getPercentageOfSalary();
        assertEquals(3, sales2.getPercentageOfSalary(), 0.01);
                                                                                        //testing the getPercentageOfSalary()
        sales3.getPercentageOfSalary();
        assertEquals(16, sales3.getPercentageOfSalary(), 0.01);

        sales4ValPercentBonus.getPercentageOfSalary();
        assertEquals(0,sales4ValPercentBonus.getPercentageOfSalary(),0.01);
    }

    @Test
    public void setPercentageOfSalary() {
        sales1.setPercentageOfSalary(12);
        assertEquals(12, sales1.getPercentageOfSalary(), 0.01);

        sales2.setPercentageOfSalary(18);
        assertEquals(18, sales2.getPercentageOfSalary(), 0.01);
                                                                                                //testing the setPercentageOfSalary()
        sales3.setPercentageOfSalary(16);
        assertEquals(16, sales3.getPercentageOfSalary(), 0.01);

        sales4ValPercentBonus.setPercentageOfSalary(82);
        assertEquals(0, sales4ValPercentBonus.getPercentageOfSalary(), 0.01);
    }

    @Test
    public void calculateSalary() {
        assertEquals(226, sales1.calculateSalary(), 0.01);
        assertEquals(511, sales2.calculateSalary(), 0.01);          //testing the calculate Salary Method
        assertEquals(422, sales3.calculateSalary(), 0.01);
    }
}
