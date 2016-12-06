package com.example.secpc.hellostranger.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.secpc.hellostranger.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //CATEGORY FLAG
    public static int CATE_TRANDITIONAL=0;
    public static int CATE_RICE=1;
    public static int CATE_NOODLE=2;
    public static int CATE_BBQ=3;
    public static int CATE_SNACK=4;
    public static int CATE_FASTFOOD=5;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView[] buttons = new ImageView[6];

        ((MainActivity)getActivity()).toolbar.setTitle(R.string.app_home);

        buttons[0] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttons[1] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttons[2] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttons[3] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttons[4] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttons[5] = (ImageView) view.findViewById(R.id.HomeFragmnet_imageButton_categoryl);
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                QuickMenuFragment frament = new QuickMenuFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
