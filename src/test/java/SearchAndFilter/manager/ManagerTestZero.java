package SearchAndFilter.manager;

import SearchAndFilter.domain.RouteOffer;
import SearchAndFilter.repository.OffersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTestZero {

    private OffersRepository repository = new OffersRepository();
    private Manager manager = new Manager(repository);

    private RouteOffer first = new RouteOffer(4, 2600, "DME", "LED", 220);

    @Test
    void shouldFindZero() {

        RouteOffer[] expected = {};
        RouteOffer[] actual = manager.searchByFromTo(null, null);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldAddOneElementAndFindIt() {

        repository.save(first);

        RouteOffer[] expected = {first};
        RouteOffer[] actual = manager.searchByFromTo("DME", "LED");

        assertArrayEquals(expected, actual);



    }
}
