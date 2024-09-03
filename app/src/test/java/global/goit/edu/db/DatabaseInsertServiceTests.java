package global.goit.edu.db;

import global.goit.edu.enterprise.WorkerLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class DatabaseInsertServiceTests {

    DatabaseInsertService dbInsertServ;
    ClientService clServ;

    @BeforeEach
    public void BeforeEach() {
        this.dbInsertServ = new DatabaseInsertService(
                Database.getInstance()
        );
        this.clServ = new ClientService(
                Database.getInstance()
        );
    }

    @BeforeAll
    public static void BeforeAll() {
        DatabaseInitService.main(null);
    }

    @Test
    public void testThatMethodCreateWorkerWorkOk() {

        //Given
        boolean expected = true;

        //When
        boolean actual = dbInsertServ.createWorker(
                "John Week", Date.valueOf(LocalDate.now()), WorkerLevel.JUNIOR, 5000
        );

        //Then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testThatMethodCreateProjectWorkOk() {

        //Given
        clServ.create("GoIT");
        boolean expected = true;

        //When
        boolean actual = dbInsertServ.createProject(
                1,
                Date.valueOf(LocalDate.now().minusYears(5)),
                Date.valueOf(LocalDate.now().plusYears(2))
        );

        //Then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testThatMethodCreateProjectWorkerWorkOk() {

        //Given
        dbInsertServ.createWorker(
                "Elon Mask",
                Date.valueOf(LocalDate.now().minusYears(30)),
                WorkerLevel.SENIOR,
                3800
        );
        clServ.create("Tesla");
        dbInsertServ.createProject(
                1,
                Date.valueOf(LocalDate.now().minusYears(2)),
                Date.valueOf(LocalDate.now().plusYears(2))
        );
        boolean expected = true;

        //When
        boolean actual = dbInsertServ.createProjectWorker(1, 1);

        //Then
        Assertions.assertEquals(expected, actual);

    }
}
