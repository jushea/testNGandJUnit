package ex3;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @DataProvider
    public static Iterator<Object[]> fromFileFilenames() {
        InputStreamReader isr = new InputStreamReader(DataProviders.class.getResourceAsStream("/user.data"));
        BufferedReader in = new BufferedReader(isr);

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            userData.add(line.split(";"));
            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userData.iterator();
    }
}
