package in.codingninjas.stocks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manishakhattar on 11/03/17.
 */

public class Course  implements Serializable{

    @Expose
    @SerializedName("id")
    int id;
    @Expose
    @SerializedName("title")
    String title;
    String name;
    @SerializedName("overview")
    String description;



    boolean isActive;


    public Course(int id, String title, String name, String description){
        this.id = id;
        this.title = title;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
