package com.ivandeveloper.application2.View.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ivandeveloper.application2.Adapter.PlayersAdapter;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Model.PlayersModel;
import com.ivandeveloper.application2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerFragment extends Fragment {

    MinorController minorController;
    RecyclerView recyclerView;
    GridLayoutManager grid;
    WebView webView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeagueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerFragment newInstance(String param1, String param2) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        MinorController minorController;
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
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        minorController = new MinorController();
        minorController.startLoading(view.getContext());
//        recyclerView = view.findViewById(R.id.players_list);
//        grid = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(grid);
//        getPlayersData();
        webView = view.findViewById(R.id.web_players);
        webView.setScrollY(200);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.mlb.com/players");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {

                view.loadUrl("javascript:getValue()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('header__nav-top')[0].style.display='none';" +
                        "document.getElementsByClassName('ad-responsive-size')[0].style.display='none';" +
                        "document.getElementById('google_ads_iframe_/2605/mlb.mlb/players/desktop_0__container__')[0].style.display='none';" +
                        "document.getElementsByClassName('p-heading__text p-heading__text--none p-heading__text--left p-heading__text--h1')[0].style.display='none';"+"})()" );
                minorController.stopLoading();
            }
        });
        return view;
    }

//    private void getPlayersData() {
//
//        Call<List<PlayersModel>> call = minorController.RetrofitBuilder2().getPlayers();
//
//        call.enqueue(new Callback<List<PlayersModel>>() {
//            @Override
//            public void onResponse(Call<List<PlayersModel>> call, retrofit2.Response<List<PlayersModel>> response) {
//
//                List<PlayersModel> playerModelList = response.body();
//                List<PlayersModel> rowList = playerModelList;
//
//                List<PlayersModel> rows = new ArrayList<>();
//
//                for (int i = 0; i < rowList.size(); i++) {
//                    rows.add(new PlayersModel(rowList.get(i).getPlayerID(),
//                            rowList.get(i).getJersey(), rowList.get(i).getLastName(), rowList.get(i).getPhotoUrl()));
//                }
//
//                PlayersAdapter adapter = new PlayersAdapter(getActivity(), rows);
//                recyclerView.setAdapter(adapter);//
//            }
//
//            @Override
//            public void onFailure(Call<List<PlayersModel>> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
////                System.out.println("asssssssssssssssssssssssssssssss sssssssssssssssssssssssssss sssssssssssssssssssss "+ t.getMessage());
//            }
//        });
//    }
}