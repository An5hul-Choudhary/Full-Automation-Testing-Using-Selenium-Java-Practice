package TestNGG;

import org.testng.annotations.*;

public class TestNGOne {



    @Test(enabled = false)
    public void testing() {
        System.out.println("Hello");
    }

    @Parameters({"URL", "SecondParam"})
    @BeforeTest
    public void preRequisite(String urlName, String secondPar) {
        System.out.println("Cleaning all caches using before test");
        System.out.println(urlName );
        System.out.println(secondPar);

    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest will execute at last");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am afterSuite");
    }


    @Test(dataProvider = "getData")
    public void secondTest(String username, String password){
        System.out.println("Second test");
        System.out.println(username);
        System.out.println(password);
    }
    

    @DataProvider
    public Object[][] getData(){
        Object[][] data= new Object[3][2];

        data[0][0] = "firstusername";
        data[0][1] = "firstpassword";

        data[1][0] = "secondusername";
        data[1][1] = "secondpassword";

        data[2][0] = "thirdusername";
        data[2][1] = "thirdpassword";

        return data;
    }

}
