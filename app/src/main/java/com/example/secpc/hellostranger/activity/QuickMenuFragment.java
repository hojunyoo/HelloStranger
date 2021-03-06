package com.example.secpc.hellostranger.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.controller.DataInstance;
import com.example.secpc.hellostranger.controller.ServerRequest;
import com.example.secpc.hellostranger.data.Menu;
import com.example.secpc.hellostranger.data.Store;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuickMenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuickMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//
public class QuickMenuFragment extends Fragment implements View.OnTouchListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View flipview, flipview2, flipview3;
    private VelocityTracker mVelocityTracker = null;

    float xCoOrdinate;
    float yCoOrdinate;

    public QuickMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuickMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuickMenuFragment newInstance(String param1, String param2) {
        QuickMenuFragment fragment = new QuickMenuFragment();
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
        //fragment를 view로 추가 한 후 layout안의 view들을 fragment의 view를 이용해 접근한다.
        View view = inflater.inflate(R.layout.fragment_quick_menu, container, false);
        ((MainActivity)getActivity()).toolbar.setTitle(R.string.app_quick);
        ((MainActivity)getActivity()).floating_back.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).floating_select.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).floating_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();

                LocationFragment frament = new LocationFragment();
                Bundle bundle = new Bundle();
                frament.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frament); // Activity 레이아웃의 View ID
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ((MainActivity)getActivity()).floating_keep.setVisibility(View.VISIBLE);

        LayoutInflater inflaters = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FrameLayout parent = (FrameLayout)view.findViewById(R.id.quickMenu_framelayout);


//        View flipv2 = inflaters.inflate(R.layout.quickmenu_flipview, parent);
//        View flipv3 = inflaters.inflate(R.layout.quickmenu_flipview, parent);
        View flipv = inflaters.inflate(R.layout.quickmenu_flipview, parent);
// fill in any details dynamically here
        TextView textView = (TextView) flipv.findViewById(R.id.quickMenu_store_name);
        textView.setText(((Store)DataInstance.store.get(1)).getName());
        Menu[] menus = new Menu[2];
        menus = ((Store)DataInstance.store.get(1)).getMenus();
        TextView menu1name = (TextView) flipv.findViewById(R.id.quickMenu_menu1_name);
        menu1name.setText(menus[0].getName());

        TextView menu1Text = (TextView) flipv.findViewById(R.id.quickMenu_menu1_text);
        menu1Text.setText("#"+menus[0].getFoodGlossary1()+"\n#"+menus[0].getFoodGlossary2()
        +"\n#"+menus[0].getTaste()+"\n#"+menus[0].getCookingmethod());

//        TextView menu1Price = (TextView) flipv.findViewById(R.id.quickMenu_menu1_price);
//        Log.d("가격??", String.valueOf(menus[0].getPrice()));
//        menu1Price.setText(menus[0].getPrice());

        if(menus[0].getMenuImage()!=null){
            ImageView imageView = (ImageView)flipv.findViewById(R.id.quickMenu_menu1_image);
            imageView.setImageBitmap(menus[0].getMenuImage());
        }
        TextView menu2name = (TextView) flipv.findViewById(R.id.quickMenu_menu2_name);
        menu2name.setText(menus[1].getName());

        //menu2

        TextView menu2Text = (TextView) flipv.findViewById(R.id.quickMenu_menu2_text);
        menu2Text.setText("#"+menus[1].getFoodGlossary1()+"\n#"+menus[1].getFoodGlossary2()
                +"\n#"+menus[1].getTaste()+"\n#"+menus[1].getCookingmethod());

        TextView menu2Price = (TextView) flipv.findViewById(R.id.quickMenu_menu2_price);
        Log.d("가격??", String.valueOf(menus[1].getPrice()));
//        menu2Price.setText(menus[1].getPrice());

        if(menus[1].getMenuImage()!=null){
            ImageView imageView = (ImageView)flipv.findViewById(R.id.quickMenu_menu2_image);
            imageView.setImageBitmap(menus[1].getMenuImage());
        }

//        flipview = view.findViewById(R.id.flipview1);
//        flipview2 = view.findViewById(R.id.flipview2);
//        flipview3 = view.findViewById(R.id.flipview3);
        flipv.setOnTouchListener(this);
//        flipv2.setOnTouchListener(this);
//        flipv3.setOnTouchListener(this);

        return view;
    }
    public void prev(View view){

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
    public boolean onTouch(View view, MotionEvent event) {

        mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(event);
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.i("ac ", "ACTION_DOWN");
                xCoOrdinate = view.getX() - event.getRawX();
                yCoOrdinate = view.getY() - event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("ac ", "ACTION_MOVE");
                view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();

                mVelocityTracker.computeCurrentVelocity(1000);
                int v = (int) mVelocityTracker.getXVelocity(); // x 축 이동 속도를 구함
                int v2 = (int) mVelocityTracker.getYVelocity(); // x 축 이동 속도를 구함

                if(Math.abs(v) > 100 || Math.abs(v2) >100){
//                    if(Math.abs(v)-Math.abs(v2)>0){
//                        startTranslate(view, v, v2);
//                    }
//                    else{
//                        //
//                    }
                    startTranslate(view, v, v2);
                }
                else{
                    startTranslate2(view);
                }

//                TranslateAnimation ani = new TranslateAnimation(
//                        Animation.RELATIVE_TO_SELF, X,
//                        Animation.RELATIVE_TO_SELF, X,
//                        Animation.RELATIVE_TO_SELF, Y,
//                        Animation.RELATIVE_TO_SELF, Y);
//                ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
//                ani.setDuration(6000); //지속시간
//
//                view.startAnimation(ani);
                break;
//            case MotionEvent.ACTION_UP:
//                Log.i("ac ", "ACTION_UP");
//               if (mVelocityTracker != null) {
//                    mVelocityTracker.recycle();
//                    mVelocityTracker = null;
//                }
//                break;
            default:
                return true;

//            case MotionEvent.ACTION_MOVE:
//                Log.i("ac ", "ACTION_MOVE");
//
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        return true;
    }
    private void startTranslate2(View view) {
        TranslateAnimation ani = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, -view.getX(),
                Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, -view.getY());
        ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
        ani.setDuration(500); //지속시간

        view.startAnimation(ani);

    }
    private void startTranslate(View view, int v, int v2) {
        float delX, delY;
        TranslateAnimation ani;
        if(Math.abs(v)-Math.abs(v2)>0){
            if(v>0){
                delX = 1.0f-view.getX();
                delY = 1.0f-view.getY();
            }
            else{
                delX = -1.0f+view.getX();
                delY = 1.0f-view.getY();
            }
        }
        else{
            if(v2>0){
                delX = 1.0f-view.getX();
                delY = -1.0f+view.getY();
            }
            else{
                delX = 1.0f-view.getX();
                delY = 1.0f-view.getY();
            }
        }
        ani = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, delX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, delY);
        ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
        ani.setDuration(100); //지속시간
        view.startAnimation(ani);
        view.setVisibility(View.GONE);

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
