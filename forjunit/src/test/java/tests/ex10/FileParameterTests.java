package tests.ex10;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static tests.ex10.DataSource.Type.*;

@RunWith(DataProviderRunner.class)
public class FileParameterTests {

    @Test
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value="/user.data",type = RESOURCE)
    public void test1(String name) {
        System.out.println(name);
    }
}
