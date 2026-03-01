import java.util.Arrays;
import java.util.List;

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
}
