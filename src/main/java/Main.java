import java.util.ArrayList;
import java.util.List;
/*
1. Описать базовый класс Transport
2. Описать потомков Bus, Tram, Trolleybus
3. Реализовать методы
    + Чтение из файла в список Transport
    + Чтение из файла в списки по типам
    + По списку вывести в упорядоченном виде парковые номера и время начала движения
    + По списку вывести в упорядоченном виде номера маршрутов, время начала и окончания движения маршрута
    - По списку вывести кол-во разных маршрутов
    - По списку вывести кол-во разных транспортных средств
    - По списку вывести номер маршрута и кол-во транспортных средств на нем
4. Функции чтения из файла вынести в класс TransportService
5. Функции вывода вывести в класс PrintService
 */
public class Main {
    public static void main(String[] args) {
        TransportService service = new TransportService();
        List<Transport> lst = service.readAll();
        System.out.println(lst);

        List<Bus> lstBus = service.readBus();
        System.out.println(lstBus);

        PrintService.printNum_StartTime();
        PrintService.printRouteNum_StartTime_EndTime();
    }
}
