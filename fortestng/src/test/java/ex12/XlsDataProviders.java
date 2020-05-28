package ex12;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class XlsDataProviders {

    @DataProvider
    public static Object[][] testData(Method method) {

        if (method.isAnnotationPresent(XlsDataSource.class)) {
            int length = method.getParameterTypes().length;
            XlsDataSource dataSource = method.getAnnotation(XlsDataSource.class);

            ExcelReader excelReader = new ExcelReader();
            excelReader.setExcelFile(dataSource.value(), "data");
            List rowsNo = excelReader.getRowContains(method.getName(), 0);
            return excelReader.getTableArray(rowsNo);
        } else {
            throw new Error("There is no @CsvDataSource annotation on method " + method);
        }
    }

}
