package messCode.meeting04.orchard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OrchardTest {

    public Orchard apricot;
    public Orchard peach;
    public Orchard plum;
    public Orchard[] orchards;
    public Orchard[] orchardsByFruit;
    public Orchard[] orchardsByFruitReversed;
    public Orchard[] orchardsByTreeCount;
    public Orchard[] orchardsByTreeCountReversed;
    public Orchard[] orchardsByLocation;
    public Orchard[] orchardsByFoundedAt;

    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    void setup() throws ParseException {
        apricot = new Orchard(
                "apricot",
                200,
                new Point(-500, 200),
                sdf.parse("2015-05-01")
        );

        peach = new Orchard(
                "peach",
                500,
                new Point(900, -100),
                sdf.parse("2012-12-22")
        );

        plum = new Orchard(
                "plum",
                150,
                new Point(-500, 500),
                sdf.parse("2000-10-31")
        );

        orchards = new Orchard[] {peach, plum, apricot};
        orchardsByFruit = new Orchard[] {apricot, peach, plum};
        orchardsByFruitReversed = new Orchard[] {plum, peach, apricot};
        orchardsByTreeCount = new Orchard[] {plum, apricot, peach};
        orchardsByTreeCountReversed = new Orchard[] {peach, apricot, plum};
        orchardsByLocation = new Orchard[] {apricot, plum, peach};
        orchardsByFoundedAt = new Orchard[] {plum, peach, apricot};
    }

    @Test
    void testSortDefault() {
        // Assume default sorting is by fruit
        Arrays.sort(orchards);

        assertTrue(Arrays.equals(orchards, orchardsByFruit));
    }

    @Test
    void testSortByFruit() {
        // Sort orchards by fruit without using default sort
        // Using a comparator
        Arrays.sort(orchards, new OrchardFruitComparator());

        // Using a functor/lambda
        //Arrays.sort(orchards, (a, b) -> a.getFruit().compareTo(b.getFruit()));

        // Using Comparator.comparing
        //Arrays.sort(orchards, Comparator.comparing(Orchard::getFruit));

        assertTrue(Arrays.equals(orchards, orchardsByFruit));
    }

    @Test
    void testSortByFruitReversed()
    {
        Arrays.sort(orchards, new OrchardFruitComparator().reversed());

        assertTrue(Arrays.equals(orchards, orchardsByFruitReversed));
    }

    @Test
    void testSortByTreeCount() {
        // Sort orchards by tree count
        Arrays.sort(orchards, Comparator.comparing(Orchard::getTreeCount));

        assertTrue(Arrays.equals(orchards, orchardsByTreeCount));
    }

    @Test
    void testSortByTreeCountReversed() {
        // Sort orchards by tree count, highest to lowest
        Arrays.sort(orchards, Comparator.comparing(Orchard::getTreeCount).reversed());

        assertTrue(Arrays.equals(orchards, orchardsByTreeCountReversed));
    }

    @Test
    void testSortByLocation() {
        // Sort orchards by location (lexicographic order)
        // Implement the sort

        assertTrue(Arrays.equals(orchards, orchardsByLocation));
    }

    @Test
    void testSortByFoundedAt() {
        // Sort orchards by date founded
        // Implement the sort

        assertTrue(Arrays.equals(orchards, orchardsByFoundedAt));
    }
}