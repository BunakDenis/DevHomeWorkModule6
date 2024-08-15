package global.goit.edu.db;

import global.goit.edu.enterprise.LongestProject;
import global.goit.edu.enterprise.MaxProjectsClient;
import global.goit.edu.enterprise.YoungestEldestWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryServiceTests {

    private DatabaseQueryService dbQueryServ;

    @BeforeEach
    public void BeforeEach() {
        this.dbQueryServ = new DatabaseQueryService(Database.getInstance());
    }
    @BeforeAll
    public static void BeforeAll() {
        DatabaseInitService.main(null);
        DatabasePopulateService.main(null);
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

    @Test
    public void testThatMethodFindMaxProjectClientWorkOk() {

        //Given
        List<MaxProjectsClient> expected = new ArrayList<>();
        expected.add(new MaxProjectsClient("Gis6", 3));
        expected.add(new MaxProjectsClient("Youtube", 3));

        //When
        List<MaxProjectsClient> actuals = dbQueryServ.findMaxProjectsClient();

        //Then
        for (int i = 0; i < actuals.size(); i++) {
            Assertions.assertEquals(expected.get(i), actuals.get(i));
        }
    }

    @Test
    public void testThatMethodFindYoungestEldestWorkerWorkOk() {

        //Given
        List<YoungestEldestWorker> expected = new ArrayList<>();
        expected.add(new YoungestEldestWorker("eldest", "Kan", LocalDate.parse("1943-02-04")));
        expected.add(new YoungestEldestWorker("youngest", "Pol", LocalDate.parse("1990-10-14")));

        //When
        List<YoungestEldestWorker> actuals = dbQueryServ.findYoungestEldestWorkers();

        //Then
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actuals.get(i));
        }
    }
}
