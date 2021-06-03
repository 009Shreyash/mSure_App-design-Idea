package com.example.admin.msure.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.msure.Adapter.BeautyserviceAdapter;
import com.example.admin.msure.Adapter.BusinessserviceAdapter;
import com.example.admin.msure.Adapter.EventserviceAdapter;
import com.example.admin.msure.Adapter.Homeservice_Adapter;
import com.example.admin.msure.Adapter.MyAdapter;
import com.example.admin.msure.Adapter.OtherserviceAdapter;
import com.example.admin.msure.Model.DataModel;
import com.example.admin.msure.Model.MyData;
import com.example.admin.msure.PrefManager;
import com.example.admin.msure.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class  All_serviceActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Integer[] XMEN = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5};
    public static RecyclerView.Adapter adapter;
    public static RecyclerView.Adapter Businessadapter;
    public static RecyclerView.Adapter Eventadapter;
    public static RecyclerView.Adapter Beautyadapter;
    public static RecyclerView.Adapter Otheradapter;
    private static ViewPager mPager;
    private static int currentPage = 0;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView_home;
    public ArrayList<DataModel> data;
    public RecyclerView.LayoutManager BusinesslayoutManager;
    public RecyclerView BusinessrecyclerView;
    public ArrayList<DataModel> Businessdata;
    public RecyclerView.LayoutManager EventlayoutManager;
    public RecyclerView EventrecyclerView;
    public ArrayList<DataModel> Eventdata;
    public RecyclerView.LayoutManager BeautylayoutManager;
    public RecyclerView BeautyrecyclerView;
    public ArrayList<DataModel> Beautydata;
    public RecyclerView.LayoutManager OtherlayoutManager;
    public RecyclerView OtherrecyclerView;
    public ArrayList<DataModel> Otherdata;
    Button btn_home, btn_business, btn_event, btn_beauty, btn_other;
    TextView txt_seeall, txt_seall2, txt_seall3, txt_seall4, txt_seall5;
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_service);
        txt_seeall = findViewById(R.id.txt_seeall);
        txt_seall2 = findViewById(R.id.txt_seeall2);
        txt_seall3 = findViewById(R.id.txt_seeall3);
        txt_seall4 = findViewById(R.id.txt_seeall4);
        txt_seall5 = findViewById(R.id.txt_seeall5);

        txt_seeall.setOnClickListener(this);
        txt_seall2.setOnClickListener(this);
        txt_seall3.setOnClickListener(this);
        txt_seall4.setOnClickListener(this);
        txt_seall5.setOnClickListener(this);

        btn_home = findViewById(R.id.btn_homeservices);
        btn_business = findViewById(R.id.btn_businessservices);
        btn_event = findViewById(R.id.btn_eventservices);
        btn_beauty = findViewById(R.id.btn_beautyservices);
        btn_other = findViewById(R.id.btn_otherservices);

        btn_home.setOnClickListener(this);
        btn_business.setOnClickListener(this);
        btn_event.setOnClickListener(this);
        btn_beauty.setOnClickListener(this);
        btn_other.setOnClickListener(this);

        Animation startAnimation = AnimationUtils.loadAnimation(this, R.anim.plus);
        btn_home.startAnimation(startAnimation);
        btn_business.startAnimation(startAnimation);
        btn_event.startAnimation(startAnimation);
        btn_beauty.startAnimation(startAnimation);
        btn_other.startAnimation(startAnimation);


        init();
        HomeService();
        BusinessServices();
        EventServices();
        BeautyServices();
        OtherServices();
    }

        /*
        Slider Images Set Method*
        */

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(All_serviceActivity.this, XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

    public void HomeService() {
        recyclerView_home = (RecyclerView) findViewById(R.id.recylear_home);
        recyclerView_home.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(All_serviceActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_home.setLayoutManager(layoutManager);
        recyclerView_home.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < 5; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.drawableArray[i]
            ));
            adapter = new Homeservice_Adapter(data);
            recyclerView_home.setAdapter(adapter);
        }


    }

    public void BusinessServices() {
        BusinessrecyclerView = (RecyclerView) findViewById(R.id.recylear_business);
        BusinessrecyclerView.setHasFixedSize(true);
        BusinesslayoutManager = new LinearLayoutManager(All_serviceActivity.this, LinearLayoutManager.HORIZONTAL, false);
        BusinessrecyclerView.setLayoutManager(BusinesslayoutManager);
        BusinessrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Businessdata = new ArrayList<DataModel>();
        for (int i = 0; i < 5; i++) {
            Businessdata.add(new DataModel(
                    MyData.nameArrayBusinessService[i],
                    MyData.drawableArrayBusinessServices[i]
            ));
            Businessadapter = new BusinessserviceAdapter(Businessdata);
            BusinessrecyclerView.setAdapter(Businessadapter);
        }

    }

    public void EventServices() {
        EventrecyclerView = (RecyclerView) findViewById(R.id.recylear_event);
        EventrecyclerView.setHasFixedSize(true);
        EventlayoutManager = new LinearLayoutManager(All_serviceActivity.this, LinearLayoutManager.HORIZONTAL, false);
        EventrecyclerView.setLayoutManager(EventlayoutManager);
        EventrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Eventdata = new ArrayList<DataModel>();
        for (int i = 0; i < 5; i++) {
            Eventdata.add(new DataModel(
                    MyData.nameArrayEventservices[i],
                    MyData.drawableArrayEventservices[i]
            ));
            Eventadapter = new EventserviceAdapter(Eventdata);
            EventrecyclerView.setAdapter(Eventadapter);
        }

    }

    public void BeautyServices() {
        BeautyrecyclerView = (RecyclerView) findViewById(R.id.recylear_beauty);
        BeautyrecyclerView.setHasFixedSize(true);
        BeautylayoutManager = new LinearLayoutManager(All_serviceActivity.this, LinearLayoutManager.HORIZONTAL, false);
        BeautyrecyclerView.setLayoutManager(BeautylayoutManager);
        BeautyrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Beautydata = new ArrayList<DataModel>();
        for (int i = 0; i < 5; i++) {
            Beautydata.add(new DataModel(
                    MyData.nameArrayBeutyService[i],
                    MyData.drawableArrayBeutyServices[i]
            ));
            Beautyadapter = new BeautyserviceAdapter(Beautydata);
            BeautyrecyclerView.setAdapter(Beautyadapter);
        }
    }

    public void OtherServices() {

        OtherrecyclerView = (RecyclerView) findViewById(R.id.recylear_other);
        OtherrecyclerView.setHasFixedSize(true);
        OtherlayoutManager = new LinearLayoutManager(All_serviceActivity.this, LinearLayoutManager.HORIZONTAL, false);
        OtherrecyclerView.setLayoutManager(OtherlayoutManager);
        OtherrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Otherdata = new ArrayList<DataModel>();
        for (int i = 0; i < 3; i++) {
            Otherdata.add(new DataModel(
                    MyData.nameArrayOtherServices[i],
                    MyData.drawableArrayOtherServices[i]
            ));
            Otheradapter = new OtherserviceAdapter(Otherdata);
            OtherrecyclerView.setAdapter(Otheradapter);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        {
            if (id == R.id.about_us) {

                final Dialog dialog = new Dialog(All_serviceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.about_usdialog);

                ImageView imageView = (ImageView) dialog.findViewById(R.id.img_close);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                ;
                return true;

            }

            if (id == R.id.terms) {


                final Dialog dialog = new Dialog(All_serviceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.termscoustomdialog);

                ImageView imageView = (ImageView) dialog.findViewById(R.id.img_close);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

                return true;


            }
            if (id == R.id.Conatct_us) {
                final Dialog dialog = new Dialog(All_serviceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.contact_us_dialog);

                ImageView imageView = (ImageView) dialog.findViewById(R.id.img_close);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return true;
            }
            if (id == R.id.share) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        Intent intent = new Intent(All_serviceActivity.this, SeeAll_Activity.class);
        switch (id) {
            case R.id.txt_seeall:
                intent.putExtra("service", 1);
                startActivity(intent);
                break;
            case R.id.txt_seeall2:
                intent.putExtra("service", 2);
                startActivity(intent);
                break;
            case R.id.txt_seeall3:
                intent.putExtra("service", 3);
                startActivity(intent);
                break;
            case R.id.txt_seeall4:
                intent.putExtra("service", 4);
                startActivity(intent);
                break;
            case R.id.txt_seeall5:
                intent.putExtra("service", 5);
                startActivity(intent);
                break;
            case R.id.btn_homeservices:
                intent.putExtra("service", 1);
                startActivity(intent);
                break;
            case R.id.btn_businessservices:
                intent.putExtra("service", 2);
                startActivity(intent);
                break;
            case R.id.btn_eventservices:
                intent.putExtra("service", 3);
                startActivity(intent);
                break;
            case R.id.btn_beautyservices:
                intent.putExtra("service", 4);
                startActivity(intent);
                break;
            case R.id.btn_otherservices:
                intent.putExtra("service", 5);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.logo)
                .setTitle("Msure")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
