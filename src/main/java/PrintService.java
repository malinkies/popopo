import java.util.*;

public class PrintService {
    private static final TransportService service = new TransportService();

    private static boolean isStr1BiggerThanStr2(String str1, String str2) {
        if (str1.length() != str2.length()) return str1.length() > str2.length();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            return str1.charAt(i) > str2.charAt(i);
        }
        return true;
    }

    public static boolean compare(String... args) {
        for (int i = 0; i < args.length / 2; i++) {
            if (args[i].equals(args[i + (args.length / 2)])) continue;
            return isStr1BiggerThanStr2(args[i], args[i + (args.length / 2)]);
        }
        return true;
    }

    public static void printNum_StartTime() {
        List<Transport> data = service.readAll();
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (compare(data.get(j).getNumber(), data.get(j).getWorkTimeBegin(),
                        data.get(j + 1).getNumber(), data.get(j + 1).getWorkTimeBegin())) {
                    Transport temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        System.out.print("(номер) время отбытия: ");
        for (Transport t : data) {
            System.out.print("(" + t.getNumber() + ") " + t.getWorkTimeBegin() + "; ");
        }
        System.out.println();
    }

    public static void printRouteNum_StartTime_EndTime() {
        List<Transport> data = service.readAll();
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (compare(data.get(j).getRouteNumber(), data.get(j).getWorkTimeBegin(),
                        data.get(j).getWorkTimeEnd(), data.get(j + 1).getRouteNumber(),
                        data.get(j + 1).getWorkTimeBegin(), data.get(j + 1).getWorkTimeEnd())) {
                    Transport temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        System.out.print("(маршрут) время отбытия-прибытия: ");
        for (Transport t : data) {
            System.out.print("(" + t.getRouteNumber() + ") " + t.getWorkTimeBegin() + "-" + t.getWorkTimeEnd() + "; ");
        }
        System.out.println();
    }

    public static void printRoutesAmount() {
        List<Transport> data = service.readAll();
        List<String> routes = new ArrayList<>();
        for (Transport t : data) {
            if (!routes.contains(t.getRouteNumber())) {
                routes.add(t.getRouteNumber());
            }
        }
        System.out.println(routes.size() + " ");
    }

    public static void printTransportAmount() {
        List<Transport> data = service.readAll();
        List<String> transports = new ArrayList<>();
        for (Transport t : data) {
            if (!transports.contains(t.getNumber())) {
                transports.add(t.getNumber());
            }
        }
        System.out.println(transports.size() + " ");
    }

    public static void printRouteNum_TranspAmount() {
        List<Transport> data = service.readAll();
        Map<String, Set<String>> res = new HashMap<>();

        for (Transport t : data) {
            if (res.containsKey(t.getRouteNumber())) {
                res.get(t.getRouteNumber()).add(t.getNumber());
            } else {
                res.put(t.getRouteNumber(), new HashSet<>(List.of(t.getNumber())));
            }
        }

        List<String> keys = new ArrayList<>(res.keySet());
        int n = keys.size();
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (isStr1BiggerThanStr2(keys.get(j), keys.get(j + 1))) {
                    String temp = keys.get(j);
                    keys.set(j, keys.get(j + 1));
                    keys.set(j + 1, temp);
                    flag = true;
                }
            }
            if (!flag) break;
        }

        for (String s : keys) {
            System.out.print("маршрут (" + s + ") - " + res.get(s).size() + " трансп.; ");
        }
        System.out.println();
    }

}
