package global.goit.edu.db;

import global.goit.edu.enterprise.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientServiceTests {
    private static ClientService clServ;

    @BeforeAll
    public static void BeforeAll() {
        DatabaseInitService.main(null);
    }

    @BeforeEach
    public void BeforeEach() {
        clServ = new ClientService(Database.getInstance());
    }

    @Test
    public void testThatMethodCreateClientWorkOk() {

        //Given
        String name = "Mark Twan";

        //When
        long actual = clServ.create(name);
        long expected = clServ.getIdByName(name);

        //Then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testThatMethodGetByIdWorkOk() {

        //Given
        String expected = "Google";

        //When
        String actual = clServ.getById(1);

        //Then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testThatMethodSetNameWorkOk() {

        //Given
        Client client = new Client(4, "BeerMarket");

        //When
        clServ.setName(client.getId(), client.getName());
        String expected = clServ.getById(client.getId());

        //Then
        Assertions.assertEquals(expected, client.getName());
    }

    @Test
    public void testThatMethodCreateThrowExceptionWhenNameIsShorterThanTwoLetters() {

        //Given
        String name = "V";
        String expectedMessage = "Length of user name must be longer then 2 letters";

        //When
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    clServ.create(name);
                }
        );
        String actualMessage = exception.getMessage();

        //Then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testThatMethodCreateThrowExceptionWhenNameIsLongerThan1000Letters() {


        //Given
        StringBuilder name = new StringBuilder();
        String expectedMessage =
                "Length of user name must be shorter than 1000 letters";

        for (int i = 0; i < 2000; i++) {
            name.append(i);
        }

        //When
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clServ.create(name.toString());
        });
        String actualMessage = exception.getMessage();

        //Then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testThatMethodGetByIdThrowExceptionIfIdLessZero() {

        //Given
        long id = -5;
        String expectedMessage = "Id must be more than 0";

        //When
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clServ.getById(id);
        });
        String actualMessage = exception.getMessage();

        //Then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testThatMethodListAllWorkOk() {

        //Given
        int expected = 9;

        //When
        clServ.create("Apple");
        clServ.create("NewBalance");
        clServ.create("Renault");
        List<Client> clients = clServ.listAll();

        //Then
        Assertions.assertEquals(expected, clients.size());

    }

    @Test
    public void testThatMethodDeleteByIdWorkOk() {

        //Given
        Client client = new Client(2, "Youtube");

        //When
        clServ.deleteById(client.getId());
        List<Client> expected = clServ.listAll();

        //Then
        Assertions.assertTrue((!expected.contains(client)) & (expected.size() > 0));

    }
}