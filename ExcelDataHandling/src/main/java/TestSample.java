import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
    public static void main(String[] args) throws IOException {

        DataDriven d = new DataDriven();
        ArrayList testData = d.getData("Add Profile");

        System.out.println(testData.get(0));
        System.out.println(testData.get(1));
        System.out.println(testData.get(2));
        System.out.println(testData.get(3));
    }
}
