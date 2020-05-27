package ex3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateFileTest extends BaseTest {
    @Test(groups = "positive", dataProviderClass = DataProviders.class, dataProvider = "filenames")
    public void create_new_file_positive(String nameFile) {
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

    @Test(groups = "positive")
    public void create_old_file_positive() {
        String filename = "C:\\ISSart\\myFile\\program.txt" ;
//        System.out.println(filename);
        File f = new File(filename);
        if (!f.exists())
            try {
                f.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
//                System.err.println(e);
            }

        try {
//            Assert.assertFalse(f.createNewFile());
            assertThat("This file was rewrited ", f.createNewFile(), equalTo(false));
            System.out.println("create old file");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test(groups = "negative")
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

//            Assert.assertEquals("Системе не удается найти указанный путь");
        }
    }
}
