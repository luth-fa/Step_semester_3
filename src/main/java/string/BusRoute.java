package string;

public class BusRoute implements Comparable<BusRoute> {

    String routeCode;
    String routeName;
    int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 0);
    }

    @Override
    public int compareTo(BusRoute other) {

        if (this.priority != other.priority) {
            return other.priority - this.priority;
        }

        int codeCompare =
                this.routeCode.compareToIgnoreCase(other.routeCode);

        if (codeCompare != 0) {
            return codeCompare;
        }

        return this.routeName.compareToIgnoreCase(other.routeName);
    }

    static BusRoute[] rankRoutes(BusRoute[] routes) {

        BusRoute[] result = new BusRoute[routes.length];

        for (int i = 0; i < routes.length; i++) {
            result[i] = routes[i];
        }

        // Stable insertion sort
        for (int i = 1; i < result.length; i++) {

            BusRoute current = result[i];
            int j = i - 1;

            while (j >= 0 && result[j].compareTo(current) > 0) {
                result[j + 1] = result[j];
                j--;
            }

            result[j + 1] = current;
        }

        return result;
    }

    public static void main(String[] args) {

        BusRoute[] routes = {
                new BusRoute("RT205L", "Airport Express", 3),
                new BusRoute("rt201j", "City Central", 4),
                new BusRoute("RT299T", "Night Service")
        };

        BusRoute[] ranked = rankRoutes(routes);

        System.out.println("Ranked Routes:");

        for (int i = 0; i < ranked.length; i++) {
            System.out.println(ranked[i].routeCode
                    + " - " + ranked[i].routeName
                    + " - Priority " + ranked[i].priority);
        }
    }
}