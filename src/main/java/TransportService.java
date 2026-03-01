import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportService {
    private static final String FILE_NAME = "src/main/transport.csv";

    public List<Transport> readAll() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Transport> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Transport transport =
                        switch (data[0]) {
                            case "bus" -> new Bus(data[1], data[2], data[3], data[4]);
                            case "tram" -> new Tram(data[1], data[2], data[3], data[4]);
                            case "trolleybus" -> new Trolleybus(data[1], data[2], data[3], data[4]);
                            default -> null;
                        };
                if (transport != null) result.add(transport);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tram> readTram() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Tram> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Tram transport = null;
                if (data[0].equals("tram")) {
                    transport = new Tram(data[1], data[2], data[3], data[4]);
                }
                if (transport != null) result.add(transport);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Trolleybus> readTrolleybus() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Trolleybus> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Trolleybus transport = null;
                if (data[0].equals("trolleybus")) {
                    transport = new Trolleybus(data[1], data[2], data[3], data[4]);
                }
                if (transport != null) result.add(transport);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Bus> readBus() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Bus> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Bus transport = null;
                if (data[0].equals("bus")) {
                    transport = new Bus(data[1], data[2], data[3], data[4]);
                }
                if (transport != null) result.add(transport);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

