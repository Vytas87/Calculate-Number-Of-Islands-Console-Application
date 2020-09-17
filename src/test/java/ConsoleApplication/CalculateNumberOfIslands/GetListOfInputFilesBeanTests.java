package ConsoleApplication.CalculateNumberOfIslands;

import ConsoleApplication.CalculateNumberOfIslands.Beans.GetListOfInputFilesBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
public class GetListOfInputFilesBeanTests {

    @Autowired
    private GetListOfInputFilesBean getListOfInputFiles;

    @Test
    void nullReferenceTest_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () ->
                getListOfInputFiles.getListOfInputFiles(null)
        );
    }

    @Test
    void directoryDoesNotExistTest_ThrowsFileNotFoundException() {
        String testDirectory = System.getProperty("user.dir") + "/TestData/GetListOfInputFilesBeanTestsData";
        Assertions.assertThrows(FileNotFoundException.class, () ->
                getListOfInputFiles.getListOfInputFiles(testDirectory)
        );
    }
}
