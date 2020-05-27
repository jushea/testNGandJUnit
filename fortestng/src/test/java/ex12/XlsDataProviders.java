package ex12;

import org.testng.annotations.DataProvider;
import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class XlsDataProviders {

    @DataProvider
    public static Object[][] xlsDataProvider(Method m) throws IOException {
        if (m.isAnnotationPresent(XlsDataSource.class)) {

            return result.toArray(new Object[result.size()][]);
        } else {
            throw new Error("There is no @CsvDataSource annotation on method " + m);
        }
    }

    @DataProvider
    public static Object[][] lazyXlsDataProvider(Method m) throws IOException {
        if (m.isAnnotationPresent(CsvDataSource.class)) {
            return new XlsFileIterator(xlsFile, length);
        } else {
            throw new Error("There is no @CsvDataSource annotation on method " + m);
        }
    }

    private static class XlsFileIterator implements Iterator<Object[]> {

        private int length;

        public XlsFileIterator(File csvFile, int length) throws FileNotFoundException {
            this.length = length;
            reader = new CSVReader(new FileReader(csvFile));
        }



    }
}
