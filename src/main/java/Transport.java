public abstract class Transport {
    private TranspType type;
    private String number;
    private String routeNumber;
    private String workTimeBegin;
    private String workTimeEnd;

    public Transport() {}

    public Transport(TranspType type, String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
        this.workTimeBegin = workTimeBegin;
        this.routeNumber = routeNumber;
        this.number = number;
        this.type = type;
    }

    public TranspType getType() {
        return type;
    }

    public void setType(TranspType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }
}
