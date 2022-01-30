package SearchAndFilter.manager;

import SearchAndFilter.domain.RouteOffer;
import SearchAndFilter.repository.OffersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private OffersRepository repository = new OffersRepository();
    private Manager manager = new Manager(repository);

    private RouteOffer first = new RouteOffer(1, 3000, "DME", "LED", 180);
    private RouteOffer second = new RouteOffer(2, 1800, "SVO", "BER", 640);
    private RouteOffer third = new RouteOffer(3, 1900, "SVO", "BER", 380);
    private RouteOffer fourth = new RouteOffer(4, 2600, "DME", "LED", 220);
    private RouteOffer fifth = new RouteOffer(5, 1200, "SVO", "BER", 770);
    private RouteOffer sixth = new RouteOffer(6, 2200, "DME", "LED", 360);
    private RouteOffer seventh = new RouteOffer(7, 200, "SVO", "BER", 1900);
    private RouteOffer eighth = new RouteOffer(8, 130, "SVO", "BER", 3000);



    @BeforeEach
    public void setUp() {
        repository.save(second);
        repository.save(first);
        repository.save(third);
        repository.save(fourth);
        repository.save(sixth);
        repository.save(fifth);
        repository.save(seventh);
        repository.save(eighth);
    }

    @Test
    void shouldFindSvoAndBer() {

        RouteOffer[] expected = {eighth, seventh, fifth, second, third};
        RouteOffer[] actual = manager.searchByFromTo("SVO", "BER");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindDmeAndLed() {

        RouteOffer[] expected = {sixth, fourth, first};
        RouteOffer[] actual = manager.searchByFromTo("DME", "LED");

        assertArrayEquals(expected, actual);


    }



}