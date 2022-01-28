package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (building.getArea() > fullArea - getCityArea()) {
            throw new IllegalArgumentException(String.format("City can't be larger than %d", fullArea));
        }
        buildings.add(building);
    }

    private long getCityArea() {
        long fullArea = 0;
        for (Building item : buildings) {
            fullArea += item.getArea();
        }
        return fullArea;
    }

//    public Building findHighestBuilding() {
//        if (buildings.size() > 0) {
//            Building highestBuilding = buildings.get(0);
//            for (Building item : buildings) {
//                if (highestBuilding.getLevels() < item.getLevels()) {
//                    highestBuilding = item;
//                }
//            }
//            return highestBuilding;
//        }
//        throw new IllegalStateException("This is not work. City is limited.");
//    }


        public Building findHighestBuilding() {
            return buildings.stream()
//                    .max(Comparator.comparingInt(Building::getLevels))
                    .max(Comparator.comparing(Building::getLevels))
                    .orElseThrow(() -> new IllegalArgumentException("Empty Building"));
        }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> foundBuildings = new ArrayList<>();
        for (Building item : buildings) {
            if (item.getAddress().getStreet().equals(street)) {
                foundBuildings.add(item);
            }
        }
        return foundBuildings;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeopleCanFit) {
        for (Building item : buildings) {
            if (item.calculateNumberOfPeopleCanFit() > numberOfPeopleCanFit) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public long getFullArea() {
        return fullArea;
    }
}
