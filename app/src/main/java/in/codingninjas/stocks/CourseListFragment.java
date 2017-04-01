package in.codingninjas.stocks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import in.codingninjas.stocks.network.ApiClient;
import in.codingninjas.stocks.network.ApiInterface;
import in.codingninjas.stocks.network.CoursesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manishakhattar on 25/03/17.
 */

public class CourseListFragment extends Fragment {

    ListView coursesListView;
    ArrayList<Course> courses;
    ArrayList<String> courseTitleList;
    ArrayAdapter<String> adapter;
    CourseItemClickListener clickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.course_list_fragment,container,false);

        courses = new ArrayList<>();
        coursesListView = (ListView) v.findViewById(R.id.coursesListView);
        courseTitleList = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,courseTitleList);
        coursesListView.setAdapter(adapter);
        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), "Item clicked ", Toast.LENGTH_SHORT).show();

                clickListener.onCourseItemClicked(courses.get(position));
            }
        });
        fetchCourses();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void setCourseItemClickListener(CourseItemClickListener listener){
        this.clickListener = listener;
    }

    private void fetchCourses() {

        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<CoursesResponse> call = apiInterface.getCourses();
//                call.execute()
//                 call2.execute();
        call.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {

                if(response.isSuccessful()){
                    Log.i("CourseAppTag", response.message() + response.code());

                    CoursesResponse coursesResponse = response.body();
                    ArrayList<Course> coursesList = coursesResponse.getData().getCourses();
                    courses.clear();
                    courses.addAll(coursesList);
                    courseTitleList.clear();
                    for(int i = 0; i < courses.size(); i++){
                        courseTitleList.add(courses.get(i).title);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {

            }
        });


    }

    public interface CourseItemClickListener{
         void onCourseItemClicked(Course c);
    }

}
