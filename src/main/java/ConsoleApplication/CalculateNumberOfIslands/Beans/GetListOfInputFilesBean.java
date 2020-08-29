/*
 * GetListOfInputFilesBean component collects a list of files in the given directory that are used to generate
 * input data
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetListOfInputFilesBean {

    // Pre:     Reference directory exists (if not, NullPointerException is caught and 'null' Object returned)
    //          Reference directory can be accessed (if not, SecurityException is caught and 'null' Object returned)
    public File[] getListOfInputFiles(String directory) {
        try {
            File folder = new File(directory);
            File[] listOfInputFiles = folder.listFiles();
            return listOfInputFiles;
        } catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("SecurityException: " + e.getMessage());
        }
        return new File[0];
    }
}