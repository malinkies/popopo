public class Trolleybus extends Transport{
    public Trolleybus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TranspType.trolleybus, number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "троллейбус номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
