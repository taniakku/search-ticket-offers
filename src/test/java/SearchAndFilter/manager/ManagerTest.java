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


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldFindSvoAndBer() {

        RouteOffer[] expected = {fifth, second, third};
        RouteOffer[] actual = manager.searchByFromTo("SVO", "BER");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindDmeAndLed() {

        RouteOffer[] expected = {sixth, fourth, first};
        RouteOffer[] actual = manager.searchByFromTo("DME", "LED");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);


    }

/*    @Test — оставлю тут закомментированный тест, который всегда должен падать (параметры можно менять)
    void shouldFail() {

        RouteOffer[] expected = {sixth, fourth, first};
        RouteOffer[] actual = manager.searchByFromTo("DME", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);


    }*/

}