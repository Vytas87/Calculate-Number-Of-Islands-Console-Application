/*
 * GetListOfInputFilesBean component collects a list of files in the given directory that are used to generate
 * input data
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class GetListOfInputFilesBean {

    // Pre:     Reference string to "directory" is not null(if null, NullPointerException is thrown)
    //          Reference directory exists (if not, FileNotFundException is thrown)
    //          Reference directory can be accessed (if not, SecurityException is thrown)
    public File[] getListOfInputFiles(String directory) throws FileNotFoundException {
        File folder = new File(directory);
        if (!folder.exists()) {
            throw new FileNotFoundException("Input file directory \"" + folder.getAbsolutePath() + "\" was not found" +
                    ".");
        }
        File[] listOfInputFiles = folder.listFiles();
        return listOfInputFiles;
    }
}