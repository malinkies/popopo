public class Bus extends Transport {
    public Bus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TranspType.bus, number, routeNumber, workTimeBegin, workTimeEnd);
    }
    @Override
    public String toString() {
        return "автобус номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
