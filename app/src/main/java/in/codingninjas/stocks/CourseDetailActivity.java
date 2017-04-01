package in.codingninjas.stocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseDetailActivity extends AppCompatActivity {

    Course c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        Intent i = getIntent();
        c = (Course) i.getSerializableExtra("course");
        CourseDetailsFragment courseDetailsFragment = (CourseDetailsFragment)getSupportFragmentManager().findFragmentById(R.id.courseDetailFragment);
        courseDetailsFragment.setCourseView(c);
    }
}
