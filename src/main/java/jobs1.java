import com.csvreader.CsvReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jobs1 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\111\\Desktop\\任务\\任务\\jobs1.csv");
        InputStream in = new FileInputStream(file);
        CsvReader cr = new CsvReader(in, Charset.forName("utf-8"));
        cr.readHeaders();
        int a = 0;
        System.out.println(cr.getHeader(12));
        System.out.println(Arrays.toString(cr.getHeaders()));
        cr.readRecord();
        String rawRecord = cr.getRawRecord();
        int columnCount = cr.getColumnCount();
        System.out.println(columnCount);
        for(int i=0;i<columnCount;i++){
            String str = cr.get(i);
            Pattern p = Pattern.compile("\\s+|\t+|\n|\r");
            Matcher m = p.matcher(str);
            String s = m.replaceAll("~~");
            System.out.println(s);
        }

        System.out.println(a);
        cr.close();
    }
}
