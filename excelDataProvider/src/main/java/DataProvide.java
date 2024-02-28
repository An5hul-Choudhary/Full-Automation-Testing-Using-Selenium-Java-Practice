
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataProvide {

    @Test(dataProvider = "driveTest" )
    public void testCaseData(String greeting, String communication, int id){
        System.out.println(greeting + communication + id);
    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws FileNotFoundException {
//        Object[][] data;
//        data = new Object[][]{
//            {"Hello","text", 1},
//            {"Bye","message", 234},
//            {"Hi", "ping", 483}
//        };
//        return data;


        FileInputStream fs = new FileInputStream("C:\\SeleniumUsingJava\\excelDataProvider\\Book1.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fs);



        return new Object[0][];
    }

}
