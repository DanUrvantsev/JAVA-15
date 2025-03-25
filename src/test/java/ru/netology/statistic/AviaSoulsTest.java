package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    void testTicketCompareTo() {
        Ticket ticket1 = new Ticket("A", "B", 100, 10, 12);
        Ticket ticket2 = new Ticket("A", "B", 200, 10, 15);
        assertTrue(ticket1.compareTo(ticket2) < 0);
    }

    @Test
    void testSearchSortByPrice() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("A", "B", 200, 10, 15));
        souls.add(new Ticket("A", "B", 100, 10, 12));
        Ticket[] result = souls.search("A", "B");
        assertEquals(100, result[0].getPrice());
        assertEquals(200, result[1].getPrice());
    }

    @Test
    void testTicketTimeComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("A", "B", 100, 10, 12);
        Ticket ticket2 = new Ticket("A", "B", 200, 10, 15);
        assertTrue(comparator.compare(ticket1, ticket2) < 0);
    }

    @Test
    void testSearchAndSortByTime() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("A", "B", 200, 10, 15));
        souls.add(new Ticket("A", "B", 100, 10, 12));
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] result = souls.searchAndSortBy("A", "B", comparator);
        assertEquals(2, result[0].getTimeTo() - result[0].getTimeFrom());
        assertEquals(5, result[1].getTimeTo() - result[1].getTimeFrom());
    }
}