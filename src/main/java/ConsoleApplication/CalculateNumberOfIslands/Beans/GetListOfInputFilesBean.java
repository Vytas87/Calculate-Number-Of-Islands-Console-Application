/*
 * GetListOfInputFilesBean component collects a list of files in the given directory that are used to generate
 * input data
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetListOfInputFilesBean {

    // Pre:     Reference directory exists (if not, NullPointerException is thrown)
    //          Reference directory can be accessed (if not, SecurityException is thrown)
    public File[] getListOfInputFiles(String directory) {
        File folder = new File(directory);
        File[] listOfInputFiles = folder.listFiles();
        return listOfInputFiles;
    }
}