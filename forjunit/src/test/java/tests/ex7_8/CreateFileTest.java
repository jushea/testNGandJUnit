package tests.ex7_8;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(DataProviderRunner.class)
public class CreateFileTest extends BaseTest {

    @DataProvider
    public static Object[][] filenames() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"name.txt"});
        data.add(new Object[]{"name-name.txt"});
        data.add(new Object[]{"name-name-name.jpg"});
        return new Object[][] {
                {"name.txt"},
                {"name-name.txt"},
                {"name-name-name.jpg"}
        };
    }

    @Test
    @UseDataProvider("filenames")
    @Category(MyCategories.PositiveTests.class)
    public void create_new_file_positive(String nameFile) throws IOException {
        String filename = "C:\\ISSart\\myFile\\" + nameFile;

        File f = new File(filename);

        if (f.exists())
            f.delete();

        try {
            System.out.println("create new file " + f.getAbsolutePath());
            assertThat("This file was created ", f.createNewFile(), equalTo(true));
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    @Category(MyCategories.PositiveTests.class)
    public void create_old_file_positive() throws IOException {
        String filename = "C:\\ISSart\\myFile\\program.txt" ;
        File f = new File(filename);

        if (!f.exists())
            try {
                f.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        try {
            assertThat("This file was rewrited ", f.createNewFile(), equalTo(false));
            System.out.println("create old file");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    @Category(MyCategories.NegativeTests.class)
    public void path_not_exist_negative() {
        String filename = "C:\\ISSart1\\program.txt";
        File f = new File(filename);

        try {

            if(f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            assertThat("This file was created ", f.isFile(), equalTo(false));
            System.out.println(e.getMessage());

        }
    }
}
