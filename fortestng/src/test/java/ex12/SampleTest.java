package ex12;

import org.testng.annotations.Test;

import java.util.List;

public class SampleTest {

    @Test(enabled = true, dataProvider = "testData", dataProviderClass = XlsDataProviders.class)
    @XlsDataSource("data.xls")
    public void testCsv(List data) {
        System.out.println("Hello, " + data.get(0) + " " + data.get(1) + " " + data.get(2));
    }
}
