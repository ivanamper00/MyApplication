package com.ivandeveloper.application2.View.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ivandeveloper.application2.Adapter.TeamsAdapter;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Database.BaseballApi;
import com.ivandeveloper.application2.Model.TeamsModel;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.Dashboard;
import com.ivandeveloper.application2.View.Listings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamFragment extends Fragment {


    RecyclerView recyclerView;
    GridLayoutManager grid;
    MinorController minorController;
    ProgressDialog pdLoading;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public TeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamFragment newInstance(String param1, String param2) {
        TeamFragment fragment = new TeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        minorController = new MinorController();
        pdLoading = new ProgressDialog(view.getContext());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        recyclerView = view.findViewById(R.id.teams_list);
        grid = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(grid);
        getTeamsData(1,getYear());

        return view;
    }

    private void getTeamsData(int l,String s) {

        Call<TeamsModel> call = minorController.RetrofitBuilder().getTeams(l,s);

        call.enqueue(new Callback<TeamsModel>() {
            @Override
            public void onResponse(Call<TeamsModel> call, retrofit2.Response<TeamsModel> response) {

                TeamsModel teamsModelList = response.body();
                List<TeamsModel.Response> responseList = teamsModelList.getResponse();
                List<TeamsModel.Response> teams = new ArrayList<>();

                for (int i = 0; i < responseList.size(); i++) {
                    teams.add(new TeamsModel.Response(responseList.get(i).getId(),
                            responseList.get(i).getName(),
                            responseList.get(i).getLogo(),
                            responseList.get(i).getCountry()));
                }
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+teams);

                TeamsAdapter adapter = new TeamsAdapter(getActivity(), teams);
                recyclerView.setAdapter(adapter);
                pdLoading.dismiss();
            }

            @Override
            public void onFailure(Call<TeamsModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String getYear(){
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        String date;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return date;
    }


}