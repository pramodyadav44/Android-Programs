package ipl.pramod.com.alarmexample;

/**
 * Created by pramod on 24/2/18.
 */

public class RemainderModel {
    private int id;
    private String data;
    private int minute;
    public RemainderModel(int id, String data,int minute) {
        this.id = id;
        this.data = data;
        this.minute = minute;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
