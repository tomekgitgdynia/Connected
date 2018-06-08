package connected;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Tom Kowszun
 */
public class FileRead {

    public static ArrayList<String> readFile(String aFileName) {

        boolean eof = false;

        Path currentRelativePath = Paths.get("");
        String directoryName = currentRelativePath.toString() + "";
        String finalFileName = currentRelativePath + directoryName + aFileName;
        String line = null;

        ArrayList<String> inputList = new ArrayList<>();
        File initialInputFile = new File(finalFileName);
        try {
            FileReader fr = new FileReader(initialInputFile);
            BufferedReader br = new BufferedReader(fr);
            do {
                line = br.readLine();
                if (line != null) {
                    inputList.add(line);
                } else {
                    eof = true;
                }
            } while (!eof);
            br.close();
            fr.close();
        } catch (IOException ioe) {
            System.out.println(" Exception reading file " + finalFileName + " " + ioe);
        }

        return inputList;
    }

}
