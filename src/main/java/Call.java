import java.util.Date;

public class Call {
    private String number;
    private Date date;

    public Call(String number) {
        this.number = number;
        this.date = new Date();
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Call(" + number + ' ' + date + ") DONE";
    }

}
