package tests.ex7_8;

import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> filenames() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"name.txt"});
        data.add(new Object[]{"name-name.txt"});
        data.add(new Object[]{"name-name-name.jpg"});
        return data.iterator();
    }
}
