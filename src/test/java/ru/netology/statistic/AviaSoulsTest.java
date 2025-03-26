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
        Ticket ticket1 = new Ticket("A", "B", 200, 10, 15);
        Ticket ticket2 = new Ticket("A", "B", 100, 10, 12);
        souls.add(ticket1);
        souls.add(ticket2);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = souls.search("A", "B");

        assertArrayEquals(expected, actual);
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
        Ticket ticket1 = new Ticket("A", "B", 200, 10, 15);
        Ticket ticket2 = new Ticket("A", "B", 100, 10, 12);
        souls.add(ticket1);
        souls.add(ticket2);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = souls.searchAndSortBy("A", "B", comparator);

        assertArrayEquals(expected, actual);
    }
}