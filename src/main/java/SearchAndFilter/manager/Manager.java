package SearchAndFilter.manager;

import SearchAndFilter.domain.RouteOffer;
import SearchAndFilter.repository.OffersRepository;

public class Manager {

    private OffersRepository repository;

    public Manager(OffersRepository repository) {
        this.repository = repository;
    }

    public Manager() {

    }

    public void add(RouteOffer ticket) {
        repository.save(ticket);

    }


    public RouteOffer[] searchByFromTo(String textFrom, String textTo) {
        RouteOffer[] result = new RouteOffer[0];

        for (RouteOffer ticket : repository.findAll()) {

            if (matchesFromTo(ticket, textFrom)) {
                RouteOffer[] tmp = new RouteOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            if (matchesFromTo(ticket, textTo)) {
                RouteOffer[] tmp = new RouteOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }


        }
        return result;

    }

    public boolean matchesFromTo(RouteOffer ticket, String search) {

        if (ticket.getAirportFrom().contains(search)) ;
        if (ticket.getAirportTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}





