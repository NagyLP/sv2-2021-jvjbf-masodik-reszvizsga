package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (this.getFullArea() / SQUARE_METERS_NEED_PER_PERSON);
    }

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (levels > 3) {
            throw new IllegalArgumentException("Error, max level 3.");
        }
        this.levels = levels;
    }

    public Home(int area, Address home) {
        super(area, home);
    }
}
