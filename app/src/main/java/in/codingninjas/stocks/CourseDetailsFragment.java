package in.codingninjas.stocks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by manishakhattar on 25/03/17.
 */

public class CourseDetailsFragment extends Fragment {
    TextView courseNameTextView;
    TextView courseTitleTextView;
    Course c;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.course_details_fragment,container,false);
        courseNameTextView = (TextView) v.findViewById(R.id.courseNameTextView);
        courseTitleTextView = (TextView) v.findViewById(R.id.courseTitleTextView);
        setHasOptionsMenu(true);

        Bundle b = getArguments();
        if(b != null){
            c = (Course)b.getSerializable("course");
            setCourseView(c);
        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void setCourseView(Course c ){
        // Set values of both the text views
        courseNameTextView.setText(c.name);
        courseTitleTextView.setText(c.title);

    }


}
