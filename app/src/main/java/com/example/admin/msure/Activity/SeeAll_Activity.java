package com.example.admin.msure.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.msure.Adapter.BeautyserviceAdapter;
import com.example.admin.msure.Adapter.BusinessserviceAdapter;
import com.example.admin.msure.Adapter.EventserviceAdapter;
import com.example.admin.msure.Adapter.Homeservice_Adapter;
import com.example.admin.msure.Adapter.OtherserviceAdapter;
import com.example.admin.msure.Horizontal_Adapter.Beautyservice_horizontalAdapter;
import com.example.admin.msure.Horizontal_Adapter.Businessservice_horizontalAdapter;
import com.example.admin.msure.Horizontal_Adapter.Eventservice_horizontalAdapter;
import com.example.admin.msure.Horizontal_Adapter.Homeservice_horizontalAdapter;
import com.example.admin.msure.Horizontal_Adapter.Otherservice_horizontalAdapter;
import com.example.admin.msure.Model.DataModel;
import com.example.admin.msure.Model.MyData;
import com.example.admin.msure.R;

import java.util.ArrayList;

public class SeeAll_Activity extends AppCompatActivity {

    public static RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager layoutManager;
    public  RecyclerView recyclerView_home;
    public ArrayList<DataModel> data;

    public  static RecyclerView.Adapter Businessadapter;
    public RecyclerView.LayoutManager BusinesslayoutManager;
    public  RecyclerView BusinessrecyclerView;
    public  ArrayList<DataModel> Businessdata;

    public  static RecyclerView.Adapter Eventadapter;
    public RecyclerView.LayoutManager EventlayoutManager;
    public RecyclerView EventrecyclerView;
    public  ArrayList<DataModel> Eventdata;

    public static RecyclerView.Adapter Beautyadapter;
    public RecyclerView.LayoutManager BeautylayoutManager;
    public  RecyclerView BeautyrecyclerView;
    public  ArrayList<DataModel> Beautydata;

    public static RecyclerView.Adapter Otheradapter;
    public RecyclerView.LayoutManager OtherlayoutManager;
    public RecyclerView OtherrecyclerView;
    public  ArrayList<DataModel> Otherdata;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent=getIntent();
        int value = getIntent().getExtras().getInt("service");
        HomeService();
        BusinessServices();
        BeautyServices();
        EventServices();
        switch (value){
            case 1:
                HomeService();
                break;
            case 2:
                BusinessServices();
                break;
            case 3:
                EventServices();
                break;
            case 4:
               BeautyServices();
                break;
            case  5:
                OtherServices();;
                break;

        }

    }


    public  void HomeService()
    {
        recyclerView_home = (RecyclerView) findViewById(R.id.recylear_home_horizontal);
        recyclerView_home.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(SeeAll_Activity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView_home.setLayoutManager(layoutManager);
        recyclerView_home.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.drawableArray[i]
            ));
            adapter =new Homeservice_horizontalAdapter(data);
            recyclerView_home.setAdapter(adapter);
        }



    }
    public void BusinessServices()
    {
        BusinessrecyclerView = (RecyclerView) findViewById(R.id.recylear_home_horizontal);
        BusinessrecyclerView.setHasFixedSize(true);
        BusinesslayoutManager = new LinearLayoutManager(SeeAll_Activity.this,LinearLayoutManager.VERTICAL,false);
        BusinessrecyclerView.setLayoutManager(BusinesslayoutManager);
        BusinessrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Businessdata = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArrayBusinessService.length; i++) {
            Businessdata.add(new DataModel(
                    MyData.nameArrayBusinessService[i],
                    MyData.drawableArrayBusinessServices[i]
            ));
            Businessadapter =new Businessservice_horizontalAdapter(Businessdata);
            BusinessrecyclerView.setAdapter(Businessadapter);
        }

    }
    public  void EventServices()
    {
        EventrecyclerView = (RecyclerView) findViewById(R.id.recylear_home_horizontal);
        EventrecyclerView.setHasFixedSize(true);
        EventlayoutManager = new LinearLayoutManager(SeeAll_Activity.this,LinearLayoutManager.VERTICAL,false);
        EventrecyclerView.setLayoutManager(EventlayoutManager);
        EventrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Eventdata = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArrayEventservices.length; i++) {
            Eventdata.add(new DataModel(
                    MyData.nameArrayEventservices[i],
                    MyData.drawableArrayEventservices[i]
            ));
            Eventadapter =new Eventservice_horizontalAdapter(Eventdata);
            EventrecyclerView.setAdapter(Eventadapter);
        }

    }
    public  void BeautyServices()
    {
        BeautyrecyclerView = (RecyclerView) findViewById(R.id.recylear_home_horizontal);
        BeautyrecyclerView.setHasFixedSize(true);
        BeautylayoutManager = new LinearLayoutManager(SeeAll_Activity.this,LinearLayoutManager.VERTICAL,false);
        BeautyrecyclerView.setLayoutManager(BeautylayoutManager);
        BeautyrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Beautydata = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArrayBeutyService.length; i++) {
            Beautydata.add(new DataModel(
                    MyData.nameArrayBeutyService[i],
                    MyData.drawableArrayBeutyServices[i]
            ));
            Beautyadapter =new Beautyservice_horizontalAdapter(Beautydata);
            BeautyrecyclerView.setAdapter(Beautyadapter);
        }
    }
    public  void OtherServices()
    {

        OtherrecyclerView = (RecyclerView) findViewById(R.id.recylear_home_horizontal);
        OtherrecyclerView.setHasFixedSize(true);
        OtherlayoutManager = new LinearLayoutManager(SeeAll_Activity.this,LinearLayoutManager.VERTICAL,false);
        OtherrecyclerView.setLayoutManager(OtherlayoutManager);
        OtherrecyclerView.setItemAnimator(new DefaultItemAnimator());
        Otherdata = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArrayOtherServices.length; i++) {
            Otherdata.add(new DataModel(
                    MyData.nameArrayOtherServices[i],
                    MyData.drawableArrayOtherServices[i]
            ));
            Otheradapter =new Otherservice_horizontalAdapter(Otherdata);
            OtherrecyclerView.setAdapter(Otheradapter);
        }
    }

}
