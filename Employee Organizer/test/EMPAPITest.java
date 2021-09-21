import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class EMPAPITest {
    private EMPAPI empapi;

    private AdminWorker admin1,admin2,admin3;
    private Manager manager1, manager2,manager3;
    private SalesWorker sales1,sales2,sales3;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        empapi = new EMPAPI();
        admin1 = new AdminWorker(40,10,"Aronas","Rowley","Aronas@Rowley.com","6592659365","5739664ur",13);
        admin2 = new AdminWorker(45,10,"Abraham","Nieves","Abraham@Nieves.com","5720583657","3857354op",12);
        admin3 = new AdminWorker(40,10,"Aaliya","Mcmanus","Aaliya@Mcmanus.com","5729562856","3768254ju",20);

        manager1 = new Manager(36,15,"Inaaya","Whitfield","Inaaya@Whitfield.com","5728562856","2759365jd");
        manager2 = new Manager(60,15,"Ashton","Weiss","Ashton@Weiss.com","5826583657","2819467dv");         //setting up the test
        manager3 = new Manager(29,15,"Rehaan","Suarez","Rehaan@Suarez.com","5829562956","1956374ne");

        sales1 = new SalesWorker(40,9.80,"Lloyd","Robertson","Lloyd@Robertson.com","4729462856","1956374bs",12);
        sales2 = new SalesWorker(38,9.80,"Eden","Conley","Eden@Conley.com","47295638563","1859254dp",15);
        sales3 = new SalesWorker(10,9.80,"Precious","Joseph","Precious@Joseph.com","563748257","2659364bt",16);
    }


    @Test
    public void getEmployees() {
        assertEquals(0,empapi.getEmployees().size());

        empapi.addEmployee(admin1);
        empapi.addEmployee(manager1);               //testing the getEmployees()
        empapi.addEmployee(sales3);

        assertEquals(3,empapi.getEmployees().size());
    }

    @Test
    public void addEmployee() {
        empapi.addEmployee(admin1);
        assertEquals(admin1, empapi.getEmployee(0));

        empapi.addEmployee(manager1);
        assertEquals(manager1, empapi.getEmployee(1));  //testing the addEmployee()

        empapi.addEmployee(sales1);
        assertEquals(sales1, empapi.getEmployee(2));
    }

    @Test
    public void addEmployeeToDepartment() {
        empapi.addEmployee(manager1);
        empapi.addEmployee(sales1);

        assertEquals(2,empapi.getEmployees().size());
        empapi.addEmployeeToDepartment(1,0);       //testing the addEmployeeToDepartment()
        assertEquals(1,manager1.getDept().size());

        empapi.addEmployee(manager2);
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales3);

        assertEquals(5,empapi.getEmployees().size());
        empapi.addEmployeeToDepartment(3,2);
        empapi.addEmployeeToDepartment(4,2);
        assertEquals(2,manager2.getDept().size());
    }

    @Test
    public void getEmployee() {
        empapi.addEmployee(admin1);
        assertEquals(admin1, empapi.getEmployee(0));
                                                                        //testing the getEmployee
        assertEquals(null, empapi.getEmployee(1));
    }

    @Test
    public void removeEmployee() {
        empapi.addEmployee(sales1);
        empapi.removeEmployee(0);
        assertEquals(null,empapi.getEmployee(0));

        empapi.addEmployee(manager1);
        empapi.removeEmployee(0);
        assertEquals(null,empapi.getEmployee(0));   //testing the remove employee method

        empapi.addEmployee(admin1);
        empapi.removeEmployee(0);
        assertEquals(null,empapi.getEmployee(0));

    }

    @Test
    public void numberOfEmployees() {
        assertEquals(0, empapi.numberOfEmployees());

        empapi.addEmployee(manager1);
        empapi.addEmployee(admin1);                             //testing the number of employees
        empapi.addEmployee(sales1);
        empapi.addEmployee(sales2);

        assertEquals(4, empapi.numberOfEmployees());
    }

    @Test
    public void listEmployees() {
        assertEquals("No Employees stored", empapi.listEmployees());

        empapi.addEmployee(manager1);
        empapi.addEmployee(admin1);
        empapi.addEmployee(sales1);                                                     //testing the list employees

        assertEquals("0: "+manager1 + "1: "+admin1 + "2: "+sales1,empapi.listEmployees());

    }

    @Test
    public void listManagerEmployees() {
        assertEquals("No Employees stored" , empapi.listManagerEmployees());

        empapi.addEmployee(manager1);
        empapi.addEmployee(manager2);
        empapi.addEmployee(manager3);
        empapi.addEmployee(sales1);                                  //testing the list employees
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales3);
        assertEquals( "0: "+manager1 + "1: "+manager2+ "2: "+manager3, empapi.listManagerEmployees());
    }

    @Test
    public void testListManagerEmployees() {
        empapi.addEmployee(manager1);
        empapi.addEmployee(admin2);

        assertEquals(2,empapi.getEmployees().size());
        empapi.addEmployeeToDepartment(1,0);
        assertEquals(1,manager1.getDept().size());

        assertEquals("Name :AbrahamNieves\n" +
                "Employee Phone Number :5720583657\n" +
                "Employee Email :Abraham@Nieves.com\n" +
                "Employee PPS :3857354op\n" +
                "Hours Worked :45.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "\n",empapi.listManagerEmployees("Inaaya"));

        assertEquals("No Employee by that name", empapi.searchEmployeeSecondName("Power"));
    }

    @Test
    public void searchEmployeeSecondName() {
        empapi.addEmployee(manager1);
        empapi.addEmployee(sales3);
        empapi.addEmployee(admin3);
        assertEquals("Name :InaayaWhitfield\n" +
                "Employee Phone Number :5728562856\n" +
                "Employee Email :Inaaya@Whitfield.com\n" +
                "Employee PPS :2759365jd\n" +
                "Hours Worked :36.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n" +
                "\n", empapi.searchEmployeeSecondName("Whitfield"));

        empapi.addEmployee(manager2);
        empapi.addEmployee(sales1);                                                 //testing the searchEmployeeSecondName
        empapi.addEmployee(sales2);
        assertEquals("Name :AshtonWeiss\n" +
                "Employee Phone Number :5826583657\n" +
                "Employee Email :Ashton@Weiss.com\n" +
                "Employee PPS :2819467dv\n" +
                "Hours Worked :60.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n" +
                "\n",empapi.searchEmployeeSecondName("Weiss"));

        assertEquals("No Employee by that name", empapi.searchEmployeeSecondName("Power"));
    }

    @Test
    public void totalSalariesOwed(){
        assertEquals(0,empapi.getEmployees().size());
        assertEquals(0,empapi.totalSalariesOwed(), 0.01);

        empapi.addEmployee(manager2);
        empapi.addEmployee(manager1);
        empapi.addEmployee(manager3);                           //testing the total salaries owed
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales1);
        assertEquals(5,empapi.getEmployees().size());
        assertEquals(2951.8,empapi.totalSalariesOwed(), 0.01);
    }

    @Test
    public void avgSalariesOwed() {
        assertEquals(0,empapi.getEmployees().size());
        assertEquals(0,empapi.avgSalariesOwed(), 0.01);

        empapi.addEmployee(manager2);
        empapi.addEmployee(manager1);
        empapi.addEmployee(manager3);                                       //testing the avgSalariesOwed
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales1);
        assertEquals(5,empapi.getEmployees().size());
        assertEquals(2951.8,empapi.totalSalariesOwed(), 0.01);
        assertEquals(590.36,empapi.avgSalariesOwed(), 0.01);
    }

    @Test
    public void employeeWithHighestPay(){
        empapi.addEmployee(manager1);
        empapi.addEmployee(manager2);
        empapi.addEmployee(manager3);
        assertEquals(manager2,empapi.employeeWithHighestPay());

        empapi.addEmployee(sales1);                                             //testing the employeeWithHighestPay
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales3);
        assertEquals(manager2,empapi.employeeWithHighestPay());

        empapi.addEmployee(admin1);
        empapi.addEmployee(admin2);
        empapi.addEmployee(admin3);
        assertEquals(admin2,empapi.employeeWithHighestPay());

    }

    @Test
    public void sortEmployeeByFirstName() {
        empapi.addEmployee(sales1);
        empapi.addEmployee(sales2);
        empapi.addEmployee(sales3);
        assertEquals(3, empapi.getEmployees().size());
        assertEquals("0: Name :LloydRobertson\n" +
                "Employee Phone Number :4729462856\n" +
                "Employee Email :Lloyd@Robertson.com\n" +
                "Employee PPS :1956374bs\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :9.8per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :EdenConley\n" +
                "Employee Phone Number :47295638563\n" +
                "Employee Email :Eden@Conley.com\n" +
                "Employee PPS :1859254dp\n" +
                "Hours Worked :38.0\n" +
                "Hourly Rate :9.8per hour\n" +                                      //testing sortEmployeeByFirstName
                "--------------------------------------------------------\n" +
                "2: Name :PreciousJoseph\n" +
                "Employee Phone Number :563748257\n" +
                "Employee Email :Precious@Joseph.com\n" +
                "Employee PPS :2659364bt\n" +
                "Hours Worked :10.0\n" +
                "Hourly Rate :9.8per hour\n" +
                "--------------------------------------------------------\n", empapi.listEmployees());
        empapi.sortEmployeeByFirstName();
        assertEquals(3, empapi.getEmployees().size());

        assertEquals("0: Name :EdenConley\n" +
                "Employee Phone Number :47295638563\n" +
                "Employee Email :Eden@Conley.com\n" +
                "Employee PPS :1859254dp\n" +
                "Hours Worked :38.0\n" +
                "Hourly Rate :9.8per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :LloydRobertson\n" +
                "Employee Phone Number :4729462856\n" +
                "Employee Email :Lloyd@Robertson.com\n" +
                "Employee PPS :1956374bs\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :9.8per hour\n" +
                "--------------------------------------------------------\n" +
                "2: Name :PreciousJoseph\n" +
                "Employee Phone Number :563748257\n" +
                "Employee Email :Precious@Joseph.com\n" +
                "Employee PPS :2659364bt\n" +
                "Hours Worked :10.0\n" +
                "Hourly Rate :9.8per hour\n" +
                "--------------------------------------------------------\n",empapi.listEmployees());
    }

    @Test
    public void sortEmployeeBySecondName() {
        empapi.addEmployee(admin1);
        empapi.addEmployee(admin2);
        empapi.addEmployee(admin3);
        assertEquals(3, empapi.getEmployees().size());
        assertEquals("0: Name :AronasRowley\n" +
                "Employee Phone Number :6592659365\n" +
                "Employee Email :Aronas@Rowley.com\n" +
                "Employee PPS :5739664ur\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :AbrahamNieves\n" +
                "Employee Phone Number :5720583657\n" +
                "Employee Email :Abraham@Nieves.com\n" +
                "Employee PPS :3857354op\n" +                                                       //testing sortEmployeeBysecondName
                "Hours Worked :45.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "2: Name :AaliyaMcmanus\n" +
                "Employee Phone Number :5729562856\n" +
                "Employee Email :Aaliya@Mcmanus.com\n" +
                "Employee PPS :3768254ju\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n",empapi.listEmployees());

        assertEquals(3, empapi.getEmployees().size());
        empapi.sortEmployeeBySecondName();
        assertEquals("0: Name :AaliyaMcmanus\n" +
                "Employee Phone Number :5729562856\n" +
                "Employee Email :Aaliya@Mcmanus.com\n" +
                "Employee PPS :3768254ju\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :AbrahamNieves\n" +
                "Employee Phone Number :5720583657\n" +
                "Employee Email :Abraham@Nieves.com\n" +
                "Employee PPS :3857354op\n" +
                "Hours Worked :45.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "2: Name :AronasRowley\n" +
                "Employee Phone Number :6592659365\n" +
                "Employee Email :Aronas@Rowley.com\n" +
                "Employee PPS :5739664ur\n" +
                "Hours Worked :40.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n", empapi.listEmployees());
    }

    @Test
    public void sortEmployeeByHourlyRate() {
        empapi.addEmployee(manager1);
        empapi.addEmployee(admin2);
        empapi.addEmployee(manager2);

        assertEquals(3,empapi.getEmployees().size());
        assertEquals("0: Name :InaayaWhitfield\n" +
                "Employee Phone Number :5728562856\n" +
                "Employee Email :Inaaya@Whitfield.com\n" +
                "Employee PPS :2759365jd\n" +
                "Hours Worked :36.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :AbrahamNieves\n" +
                "Employee Phone Number :5720583657\n" +                                         //testing sortEmployeeByHourlyRate
                "Employee Email :Abraham@Nieves.com\n" +
                "Employee PPS :3857354op\n" +
                "Hours Worked :45.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n" +
                "2: Name :AshtonWeiss\n" +
                "Employee Phone Number :5826583657\n" +
                "Employee Email :Ashton@Weiss.com\n" +
                "Employee PPS :2819467dv\n" +
                "Hours Worked :60.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n", empapi.listEmployees());

        assertEquals(3,empapi.getEmployees().size());
        empapi.sortEmployeeByHourlyRate();
        assertEquals("0: Name :AshtonWeiss\n" +
                "Employee Phone Number :5826583657\n" +
                "Employee Email :Ashton@Weiss.com\n" +
                "Employee PPS :2819467dv\n" +
                "Hours Worked :60.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n" +
                "1: Name :InaayaWhitfield\n" +
                "Employee Phone Number :5728562856\n" +
                "Employee Email :Inaaya@Whitfield.com\n" +
                "Employee PPS :2759365jd\n" +
                "Hours Worked :36.0\n" +
                "Hourly Rate :15.0per hour\n" +
                "--------------------------------------------------------\n" +
                "2: Name :AbrahamNieves\n" +
                "Employee Phone Number :5720583657\n" +
                "Employee Email :Abraham@Nieves.com\n" +
                "Employee PPS :3857354op\n" +
                "Hours Worked :45.0\n" +
                "Hourly Rate :10.0per hour\n" +
                "--------------------------------------------------------\n",empapi.listEmployees());
    }

    @Test
    public void testSaveAndLoad() throws Exception{
       assertEquals(0,empapi.getEmployees().size());
       empapi.save();
       empapi.load();
       assertEquals(0, empapi.getEmployees().size());

       empapi.addEmployee(admin1);
       empapi.addEmployee(manager2);                                        //testing the save and load
       empapi.addEmployee(sales3);

       assertEquals(3,empapi.getEmployees().size());
       empapi.save();
       empapi.load();
       assertEquals(3,empapi.getEmployees().size());
    }

}
