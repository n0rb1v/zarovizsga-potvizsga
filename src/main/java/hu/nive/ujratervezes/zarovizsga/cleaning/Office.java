package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{
    private String address;
    private int size;
    private int levels;

    public Office(String address, int size, int levels) {
        this.address = address;
        this.size = size;
        this.levels = levels;
    }

    @Override
    public int clean() {
        return size*100*levels;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
