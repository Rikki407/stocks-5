package in.codingninjas.stocks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by manishakhattar on 11/03/17.
 */

public class CoursesAsyncTask extends AsyncTask<String, Void, ArrayList<Course>> {

//    CourseListActivity courseActivity;

    CourseDownloadListener listener;


    CoursesAsyncTask() {

    }

    void setCourseDownloadListener(CourseDownloadListener listener) {
        this.listener = listener;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected ArrayList<Course> doInBackground(String... params) {


        String urlString = params[0];
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return null;
            }

//            String result = "";
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
//                result = result + s.nextLine();
                stringBuffer.append(s.nextLine());
            }
            Log.i("CourseData", stringBuffer.toString());

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {

        }

        return parseCourseList(stringBuffer.toString());

    }

    private ArrayList<Course> parseCourseList(String json) {

        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");
            JSONArray courseArray = data.getJSONArray("courses");
            ArrayList<Course> courseList = new ArrayList<>();

            for (int i = 0; i < courseArray.length(); i++) {
                JSONObject courseObject = courseArray.getJSONObject(i);
                int id = courseObject.getInt("id");
                String title = courseObject.getString("title");
                String name = courseObject.getString("name");
                String description = courseObject.getString("overview");
                Course c = new Course(id, title, name, description);
                courseList.add(c);
            }
            return courseList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    protected void onPostExecute(ArrayList<Course> courses) {
        super.onPostExecute(courses);
        if (listener != null)
            listener.onDownloadComplete(courses);
        // we should pass this list to CourseListActivity
    }

    public interface CourseDownloadListener {
        void onDownloadComplete(ArrayList<Course> courses);
    }

}

