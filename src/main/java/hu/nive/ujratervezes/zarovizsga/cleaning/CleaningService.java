package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CleaningService {
    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }


    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int sum = 0;
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable item : cleanables) {
            sum += item.clean();
            result.add(item);
        }
        cleanables.removeAll(result);
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable item : cleanables) {
            if (item instanceof Office) {
                sum += item.clean();
                result.add(item);
            }
        }
        cleanables.removeAll(result);
        return sum;
    }

    public List<Cleanable> findByAddressPart(String s) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable item : cleanables) {
            if (item.getAddress().contains(s)) {
                result.add(item);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder("");
        for (Cleanable item : cleanables) {
            sb.append(item.getAddress() + ", ");
        }
        return sb.substring(0, sb.length() - 2).toString();
    }
}
