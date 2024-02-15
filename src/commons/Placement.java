package commons;
import java.util.HashMap;
import java.util.Map;

public class Placement {
    private static Map<String, Integer> placement;

    static {
        placement = new HashMap<>();
        placement.put("garut", 1961085);
        placement.put("bandung", 3742276);
        placement.put("jakarta", 4453935);
        placement.put("bekasi", 4782935);
        placement.put("bogor", 4330249);
    }

    public static boolean isKotaTersedia(String kota) {
        if (placement.containsKey(kota.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static int getUmk(String kota) {
        if (isKotaTersedia(kota)) {
            return placement.get(kota.toLowerCase());
        } else {
            return 0;   
        }
    }
}
