package global.goit.edu.db;

import global.goit.edu.enterprise.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        System.out.println(expected);

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
}
