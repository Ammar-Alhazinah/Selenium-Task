package DataProvider;

import HelpClasses.ReadCsvFile;
import org.testng.annotations.DataProvider;

import java.util.List;
public class DataProviderClass {


    @DataProvider(name = "Data")
    public static Object[][] getData() throws Exception {

        List<String[]> lines = ReadCsvFile.readAllLines("resources/Files/Data.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for (String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }
}
