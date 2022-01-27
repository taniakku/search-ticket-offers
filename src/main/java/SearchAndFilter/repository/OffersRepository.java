package SearchAndFilter.repository;

import SearchAndFilter.domain.RouteOffer;

public class OffersRepository {

    private RouteOffer[] tickets = new RouteOffer[0];

    public void save(RouteOffer ticket) {
        int length = tickets.length + 1;
        RouteOffer[] tmp = new RouteOffer[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public RouteOffer[] findAll() {
        return tickets;
    }

    public void removeById(int id) {

        int length = tickets.length - 1;
        RouteOffer[] tmp = new RouteOffer[length];
        int index = 0;
        for (RouteOffer ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}






