import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class conjunto {
    // Define o conjunto N
    private final Set<Integer> N = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);


    @Test
    void testBelongsToSet() {
        assertTrue(N.contains(4), "The number 4 should belong to the set");
        assertFalse(N.contains(10), "The number 10 should not belong to the set");
    }

    @Test
    void testSetOperations() {
        Set<Integer> union = new HashSet<>(N);
        union.addAll(Set.of(10, 11, 12));
        assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), union, "The union should contain the new elements");

        Set<Integer> intersection = new HashSet<>(N);
        intersection.retainAll(Set.of(3, 6, 9)); assertEquals(Set.of(3, 6, 9), intersection, "The intersection should contain only common elements");

        Set<Integer> difference = new HashSet<>(N);
        difference.removeAll(Set.of(2, 4, 6));
        assertEquals(Set.of(1, 3, 5, 7, 8, 9), difference, "The difference should remove elements 2, 4 and 6");
    }

}
