package global.goit.edu.db;

import global.goit.edu.enterprise.LongestProject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DatabaseQueryServiceTests {

    private DatabaseQueryService dbQueryServ;

    @BeforeEach
    public void BeforeEach() {
        this.dbQueryServ = new DatabaseQueryService(Database.getInstance());
    }

    @Test
    public void testThatMethodFindLongestProjectWorkOk() {

        //Given
        LongestProject expected = new LongestProject("project A", 108);

        //When
        List<LongestProject> actuals = dbQueryServ.findLongestProject();

        //Then
        for (LongestProject actual : actuals) {
            Assertions.assertEquals(expected, actual);
        }
    }
}
