package com.example.secpc.hellostranger.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.secpc.hellostranger.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AllMenuFragment.OnFragmentInteractionListener, LocationFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, QuickMenuFragment.OnFragmentInteractionListener {
    Fragment fragment = null;
    Class fragmentClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //시작화면 home fragment로 설정하는 함수
        InitFrag();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //menu안의 switch view 연결할 때 버튼의 경우 setOnClickListener로 바꿔주면 된다. 생성한 listener안에 버튼 이벤트 구현해주기
        ((Switch)((navigationView.getMenu().findItem(R.id.nav_taboo)).getActionView()).findViewById(R.id.taboo_onoff))
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //taboo swtich on일때
                }
                else{
                    //taboo swtich off일때
                    Log.d("되냐", "off");
                }
            }
        });
        ((Button)((navigationView.getMenu().findItem(R.id.nav_languages)).getActionView())
                .findViewById(R.id.kor_lang)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kor_lang 버튼 이벤트
                Log.d("언어 : ", "한국어");
            }
        });
        ((Button)((navigationView.getMenu().findItem(R.id.nav_languages)).getActionView())
                .findViewById(R.id.eng_lang)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //eng_lang 버튼 이벤트
                Log.d("언어 : ", "영어");
            }
        });
        ((Button)((navigationView.getMenu().findItem(R.id.nav_languages)).getActionView())
                .findViewById(R.id.chn_lang)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chn_lang 버튼 이벤트
                Log.d("언어 : ", "중국어");
            }
        });
        ((Button)((navigationView.getMenu().findItem(R.id.nav_languages))
                .getActionView()).findViewById(R.id.jpn_lang)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //jan_lang 버튼 이벤트
                Log.d("언어 : ", "일본어");
            }
        });
    }

    private void InitFrag() {
        FragmentManager initFrag = getSupportFragmentManager();
        try {
            fragment = (Fragment)(HomeFragment.class.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        initFrag.beginTransaction().replace(R.id.flContent, fragment).commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //fragment를 attach하기 위해 override함수
    public void onFragmentInteraction(Uri uri){

    }

    //액션바의 메뉴 아이콘 클릭 시 나오는 nevigationview의 아이템 클릭 시 이벤트 처리
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // 선택(터치)한 id 얻어오기
        int id = item.getItemId();

        //id별 fragment를 연결
        switch (id) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_food_diary:
                fragmentClass = LocationFragment.class;
                break;
            case R.id.nav_keep:
                fragmentClass = KeepFragment.class;
                break;
            case R.id.nav_taboo:
                Intent goTaboo = new Intent(MainActivity.this, SettingTabooActivity.class);
                startActivity(goTaboo);
                return true;
        }
        //연결한 fragment를 생성해 준다
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //생성한 fragment를 main에서 보여주기
        FragmentManager fragmentManager = getSupportFragmentManager();
        //main activity에서 fragment를 붙일 view의 id, 보여줄 fragment의 id 가 인자로 받아진다
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
