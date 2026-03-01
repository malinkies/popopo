public class Trolleybus extends Transport{
    public Trolleybus(String workTimeEnd, String workTimeBegin, String routeNumber, String number) {
        super(TranspType.trolleybus, number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "троллейбус номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
