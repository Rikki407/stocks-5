package in.codingninjas.stocks.network;

import java.util.ArrayList;

import in.codingninjas.stocks.Course;

/**
 * Created by manishakhattar on 19/03/17.
 */

public class CoursesResponse {

    Data data;

    public class Data{

        ArrayList<Course> courses;

        public ArrayList<Course> getCourses() {
            return courses;
        }

        public void setCourses(ArrayList<Course> courses) {
            this.courses = courses;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
