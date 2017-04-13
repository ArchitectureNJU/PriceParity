package architecture.crawler.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

/**
 * Created by raychen on 2017/4/14.
 */
public class FileUtil {

    private static BufferedWriter writer;

    public static void printToFile(String line){
        File file = new File("src/main/resources/test.txt");
        try {
            if (writer == null) writer = new BufferedWriter(new PrintWriter(file));
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
