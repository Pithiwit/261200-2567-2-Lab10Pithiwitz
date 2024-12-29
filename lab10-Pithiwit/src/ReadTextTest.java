import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReadTextTest {
    @Test
    void fileInputAccess() {
        File file1 = new File("C:/Users/Admin/IdeaProjects/lab09-Pithiwit/src/input");
        assertTrue(file1.exists() && file1.canRead());//
    }

    @Test
    void fileOutputAccess() {
        File file2 = new File("C:/Users/Admin/IdeaProjects/lab09-Pithiwit/src/output");
        assertTrue(file2.exists() && file2.canRead());
    }


}