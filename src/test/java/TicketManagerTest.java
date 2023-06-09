import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, "SPB", "MSK", 1500, 80);
    Ticket ticket2 = new Ticket(2, "UG", "LG", 6000, 160);
    Ticket ticket3 = new Ticket(3, "SPB", "MSK", 4500, 60);
    Ticket ticket4 = new Ticket(4, "VT", "VR", 3000, 120);
    Ticket ticket5 = new Ticket(5, "SPB", "MSK", 2000, 110);

    @Test
    public void sortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = manager.findAll("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void singleTicketSearch() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("VT", "VR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByWhenItemNotFound() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("UA", "BG");

        Assertions.assertArrayEquals(expected, actual);
    }
}
