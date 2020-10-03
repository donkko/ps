package p5515;

import java.util.HashMap;
import java.util.Map;

class ParkingSystem {
    final int BIG = 1;
    final int MEDIUM = 2;
    final int SMALL = 3;

    Map<Integer, Integer> countMap;

    public ParkingSystem(int big, int medium, int small) {
        countMap = new HashMap<>();
        countMap.put(BIG, big);
        countMap.put(MEDIUM, medium);
        countMap.put(SMALL, small);
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case BIG:
                if (countMap.get(BIG) == 0) {
                    return false;
                }
                countMap.put(BIG, countMap.get(BIG) - 1);
                return true;
            case MEDIUM:
                if (countMap.get(MEDIUM) == 0) {
                    return false;
                }
                countMap.put(MEDIUM, countMap.get(MEDIUM) - 1);
                return true;
            case SMALL:
                if (countMap.get(SMALL) == 0) {
                    return false;
                }
                countMap.put(SMALL, countMap.get(SMALL) - 1);
                return true;
            default:
                return false;
        }
    }
}
