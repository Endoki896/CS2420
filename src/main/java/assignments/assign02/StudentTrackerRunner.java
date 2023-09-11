package assignments.assign02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentTrackerRunner {

    private static String[] firstNames = {
            "William",
            "David",
            "John",
            "Lexi",
            "Abby",
            "Peter",
            "Wade",
            "John",
            "Richard",
            "Daniel",
            "Theresa",
            "Giovanni",
            "Simon",
            "James",
            "Jackson",
            "Sarah",
            "Olivia",
            "Emma",
            "Christopher",
            "Alexander",
            "Riley"
    };
    private static String[] lastNames = {
            "Jones",
            "Walker",
            "Bond",
            "Scott",
            "Baker",
            "Allen",
            "Williams",
            "Rodriguez",
            "Moore",
            "Russell",
            "Strobehn",
            "Robinson",
            "Clark",
            "Schock",
            "Campbell",
            "Taylor",
            "Miller",
            "Lewis",
            "Great",
            "Johnson",
            "Rodriguez"
    };
    private static String[] domainNames = {
            "gmail.com",
            "yahoo.com",
            "icloud.com",
            "hotmail.com"
    };
    private static List<Integer> usedUNIDs = new ArrayList<>();
    private static List<Integer> usableUNIDs = new ArrayList<>();

    static CS2420Student generateStudent()
    {
        Random rand = new Random();
        String firstName = firstNames[rand.nextInt(firstNames.length)];
        String lastName = lastNames[rand.nextInt(lastNames.length)];
        String domain = domainNames[rand.nextInt(domainNames.length)];
        int unid = usableUNIDs.remove(rand.nextInt(usableUNIDs.size()));
        usedUNIDs.add(unid);
        return new CS2420Student(firstName, lastName, unid, new EmailAddress(firstName.substring(0, 1).toLowerCase() + lastName, domain));
    }

    static CS2420Class generateClassOf(int size)
    {
        CS2420Class output = new CS2420Class();
        for(int i = 0; i < size; i++) output.addStudent(generateStudent());

        return output;
    }

    public static void main(String[] args)
    {
        for(int i = 1000000; i < 10000000; i++)
        {
            usableUNIDs.add(i);
        }
        long time = 0;
        long start = System.nanoTime();
        while(time < 10000000000L)
        {
            time += System.nanoTime() - start;
            start = System.nanoTime();
        }

        List<Double> runTimes = new ArrayList<>();
        Random rand = new Random();
        double averageTime = 0;
        int target;
        long startTime;
        long endTime;

        CS2420Class CSclass;

        System.out.println("Starting runtime collection...");

        for(int i = 10000; i <= 100000; i += 10000)
        {
            CSclass = generateClassOf(i);
            System.out.println("testing class of " + i + "...");
            for(int j = 0; j < 100; j++)
            {
                System.out.println("starting test " + j + "...");
                target = rand.nextInt(usedUNIDs.size());
                startTime = System.nanoTime();
                CSclass.lookup(usedUNIDs.get(target));
                endTime = System.nanoTime();
                if(averageTime > 0) averageTime = (averageTime + (endTime - startTime)) / 2.0;
                else averageTime = (endTime - startTime);
            }
            runTimes.add(averageTime);
            System.out.println("class of " + i + "; runtime average: " + averageTime);

            usedUNIDs.clear();
            averageTime = 0.0;
        }

        System.out.println("Test complete(in ns):");
        for(double runTime : runTimes)
            System.out.println(runTime);
    }
}
