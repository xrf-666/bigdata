
import com.csvreader.CsvReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 测试 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\111\\Desktop\\任务\\任务\\jobs5.csv");
        FileWriter fw = new FileWriter(new File("C:\\Users\\111\\Desktop\\任务\\任务\\5.csv"));
        BufferedWriter bw = new BufferedWriter(fw);
        InputStream in = new FileInputStream(file);
        CsvReader cr = new CsvReader(in, Charset.forName("utf-8"));

        //获取表头信息
        cr.readHeaders();
        //bw.write(Arrays.toString(cr.getHeaders()));
        System.out.println(Arrays.toString(cr.getHeaders()));

        while(cr.readRecord()) {
            String RawRecord = cr.getRawRecord();
            int columnCount = cr.getColumnCount();
            for (int i = 0; i <columnCount; i++) {
                String str = cr.get(i);
                Pattern p = Pattern.compile("\\s+|\t+|\n\r");
                Matcher m = p.matcher(str);
                String s = m.replaceAll(",");
                //System.out.println(s);
                String out= (s+',').toString();
                bw.write(out);
            }
            bw.write('\n');
        }

        bw.close();
        fw.close();
        cr.close();


    }
}
