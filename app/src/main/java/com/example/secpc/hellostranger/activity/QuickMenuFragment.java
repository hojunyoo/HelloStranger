package com.example.secpc.hellostranger.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.secpc.hellostranger.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuickMenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuickMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuickMenuFragment extends Fragment implements View.OnTouchListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View flipview;
    private int _xDelta;
    private int _yDelta;
    private VelocityTracker mVelocityTracker = null;
    private int[] origin = new int[2];


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
        flipview = view.findViewById(R.id.flipview);
        flipview.setOnTouchListener(this);
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
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        float dX = 0, dY=0;
        Log.d("x :", String.valueOf(X));
        Log.d("y :", String.valueOf(Y));

        if (mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                view.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            default:
                return false;
            case MotionEvent.ACTION_UP:
                Log.i("ac ", "ACTION_UP");
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }

                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.i("ac ", "ACTION_MOVE");
//
//                mVelocityTracker.computeCurrentVelocity(1000);
//                int v = (int) mVelocityTracker.getXVelocity(); // x 축 이동 속도를 구함
//                Log.d("mVelocityTracker : " ,String.valueOf(v));
//                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                layoutParams.leftMargin = X - _xDelta;
//                layoutParams.topMargin = Y - _yDelta;
//                view.setLayoutParams(layoutParams);
//
//                if(v > 600){
//                    startTranslate(view);
//                }
//                else{
//                    startTranslate2(view);
//                }
////
////                TranslateAnimation ani = new TranslateAnimation(
////                        Animation.RELATIVE_TO_SELF, X,
////                        Animation.RELATIVE_TO_SELF, X,
////                        Animation.RELATIVE_TO_SELF, Y,
////                        Animation.RELATIVE_TO_SELF, Y);
////                ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
////                ani.setDuration(6000); //지속시간
////
////                view.startAnimation(ani);
//                break;
//
        }
        return true;
    }
    private void startTranslate2(View view) {
        TranslateAnimation ani = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, 0);
        ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
        ani.setDuration(1000); //지속시간

        view.startAnimation(ani);

    }
    private void startTranslate(View view) {
        TranslateAnimation ani = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 1.0f,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 1.0f);
        ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
        ani.setDuration(1000); //지속시간

        view.startAnimation(ani);

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
