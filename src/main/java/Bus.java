public class Bus extends Transport {
    public Bus(String workTimeEnd, String workTimeBegin, String routeNumber, String number) {
        super(TranspType.bus, number, routeNumber, workTimeBegin, workTimeEnd);
    }
    @Override
    public String toString() {
        return "автобус номер " + getNumber() + ", маршрут " + getRouteNumber() + ", начало " + getWorkTimeBegin() + ", конец" + getWorkTimeEnd();
    }
}
