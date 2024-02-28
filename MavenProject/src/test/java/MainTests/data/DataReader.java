package MainTests.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.io.FileUtils.*;

public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        //Read json to String
        String jsonContent = readFileToString(new File(System.getProperty("user.dir" + "//src//test//java//MainTests//data//PurchaseOrder.json")), StandardCharsets.UTF_8);

        //String to hashmap -> Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

}
