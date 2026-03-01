public class Tram extends Transport{
    public Tram(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TranspType.tram, number, routeNumber, workTimeBegin, workTimeEnd);
    }
    @Override
    public String toString() {
        return "трамвай номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
