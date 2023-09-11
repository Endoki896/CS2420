package messCode.meeting04.orchard;

import java.util.Comparator;

public class OrchardFruitComparator implements Comparator<Orchard> {
    @Override
    public int compare(Orchard o1, Orchard o2) {
        return o1.getFruit().compareTo(o2.getFruit());
    }
}
