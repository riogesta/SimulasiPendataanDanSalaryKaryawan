package commons;

import java.util.HashMap;
import java.util.Map;

public class Jobs {
    private static Map<String, Double> jobDesc = new HashMap<>();

    static {
        jobDesc.put("employee".toLowerCase(), 1.0);
        jobDesc.put("programmer".toLowerCase(), 1.5);
        jobDesc.put("projectLeader".toLowerCase(), 2.0);
        jobDesc.put("analyst".toLowerCase(), 1.6);
    }

    public static Map<String, Double> getJobDesc() {
        return jobDesc;
    }
}
