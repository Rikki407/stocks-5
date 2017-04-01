package in.codingninjas.stocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.google.gson.Gson;


public class CourseListActivity extends AppCompatActivity implements CourseListFragment.CourseItemClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);

        CourseListFragment courseListFragment = (CourseListFragment)getSupportFragmentManager().findFragmentById(R.id.courseListFragment);
        courseListFragment.setCourseItemClickListener(this);

        Gson gson = new Gson();
        Course c = new Course(1,"Envision", "Envision","abcd");
        String json = gson.toJson(c);
        Log.i("CourseAppTag", json);

        Course c2 = gson.fromJson(json, Course.class);


    }


    @Override
    public void onCourseItemClicked(Course c) {

//
//        Toast.makeText(this, c.name+" clicked", Toast.LENGTH_SHORT).show();

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        if(frameLayout == null){ // Portrait

            // Launch new Activity with Course Detail Fragment
            Intent i = new Intent();
            i.setClass(this, CourseDetailActivity.class);
            i.putExtra("course", c);
            startActivity(i);
//            Toast.makeText(this, c.name+" clicked", Toast.LENGTH_SHORT).show();

        }else{

//            TextView textView = (TextView) findViewById(R.id.courseNameTextView);
//            textView.setText(c.name);

//            CourseDetailsFragment courseDetailsFragment =(CourseDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.courseDetailFragment);
//            courseDetailsFragment.setCourseView(c);
            CourseDetailsFragment courseDetailsFragment = new CourseDetailsFragment();
            Bundle b = new Bundle();
            b.putSerializable("course", c);
            courseDetailsFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, courseDetailsFragment).commit();


        }

    }


//        String urlString = "http://codingninjas.in/api/v1/courses";
//        CoursesAsyncTask task = new CoursesAsyncTask();
//        task.setCourseDownloadListener(this);
//        task.execute(urlString);



//    public void onDownloadComplete(ArrayList<Course> courseList){
//        if(courseList == null){
//            return;
//        }
//        courses.clear();
//        courses.addAll(courseList);
//        courseTitleList.clear();
//        for(int i = 0; i < courses.size(); i++){
//            courseTitleList.add(courses.get(i).title);
//        }
//        adapter.notifyDataSetChanged();
//
//    }
//
}
