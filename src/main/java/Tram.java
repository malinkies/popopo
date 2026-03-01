public class Tram extends Transport{
    public Tram(String workTimeEnd, String workTimeBegin, String routeNumber, String number) {
        super(TranspType.tram, number, routeNumber, workTimeBegin, workTimeEnd);
    }
    @Override
    public String toString() {
        return "трамвай номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
