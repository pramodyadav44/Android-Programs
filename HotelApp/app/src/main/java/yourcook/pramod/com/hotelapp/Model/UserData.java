package yourcook.pramod.com.hotelapp.Model;

/**
 * Created by pramod on 17/3/18.
 */

public class UserData {
    private int id;
    private String category;
    private String food;

    public UserData(String category, String food) {
        this.category = category;
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
