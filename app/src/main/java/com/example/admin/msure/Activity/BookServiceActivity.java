package com.example.admin.msure.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.msure.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookServiceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spin, spin2;
    TextView txt_date;
    EditText et_name, ph_number, emailid, et_city, et_address;
    Button btn_send;
    LinearLayout liner_date;
    private int selectedDate, selectedMonth, selectedYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_service);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
        SelectDate();

    }

    public void init() {
        spin = (Spinner) findViewById(R.id.spinner);
        spin2 = findViewById(R.id.spiner2);
        spin.setOnItemSelectedListener(this);
        liner_date = findViewById(R.id.linear_date);
        et_name = findViewById(R.id.et_name);
        ph_number = findViewById(R.id.et_phonenumber);
        emailid = findViewById(R.id.et_emailid);
        et_city = findViewById(R.id.et_city);
        et_address = findViewById(R.id.et_address);
        txt_date = (TextView) findViewById(R.id.txt_date);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);


    }

    public void SelectDate() {
        liner_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // custom dialog
                final Dialog dialog = new Dialog(BookServiceActivity.this);
                dialog.setContentView(R.layout.datepickerview);
                dialog.setTitle("Date Picker");

                DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.datePicker1);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                selectedDate = calendar.get(Calendar.DAY_OF_MONTH);
                selectedMonth = calendar.get(Calendar.MONTH);
                selectedYear = calendar.get(Calendar.YEAR);
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        Log.e("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);

                        Log.e("selected date", selectedDate + "");
                        Log.e("selected date", dayOfMonth + "");
                        Log.e("selected month", selectedMonth + "");
                        Log.e("selected month", month + "");
                        Log.e("selected year", selectedYear + "");
                        Log.e("selected year", year + "");
                        if (selectedDate == dayOfMonth && selectedMonth == month && selectedYear == year) {


                            txt_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            dialog.dismiss();
                        } else {

                            if (selectedDate != dayOfMonth) {
                                txt_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                dialog.dismiss();
                            } else {
                                if (selectedMonth != month) {
                                    txt_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                    dialog.dismiss();
                                }
                            }
                        }
                        selectedDate = dayOfMonth;
                        selectedMonth = (month);
                        selectedYear = year;
                    }
                });


                dialog.show();
            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sp1 = String.valueOf(spin.getSelectedItem());
        if (sp1.contentEquals("Home Services")) {
            ArrayList<String> list = new ArrayList<String>();
            list.add("Electrician");
            list.add("Plumber");
            list.add("Carpenter");
            list.add("Pest Control");
            list.add("House Painter");
            list.add("Laundry");
            list.add("R.o Services");
            list.add("Refrigerator Service");
            list.add("House Cleaning");
            list.add("Washing Machine Service");
            list.add("Sofa Cleaning");
            list.add("furniture & wood work");
            list.add("Interior Designer");
            list.add("Waterproofing");
            list.add("Apple Product Repair");
            list.add("Renovation");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    R.layout.spinerlayout, list);
            dataAdapter.setDropDownViewResource(R.layout.spinerlayout);
            dataAdapter.notifyDataSetChanged();
            spin2.setAdapter(dataAdapter);
        }
        if (sp1.contentEquals("Business Services")) {
            List<String> list = new ArrayList<String>();
            list.add("Accountancy & CA");
            list.add("CCTV Camera Installation");
            list.add("Website Devloping");
            list.add("Packers & Movers");
            list.add("Logistic Service");
            list.add("Graphic & Printing");
            list.add("Company Registration");
            list.add("Forex Services");
            list.add("Tax Consultant");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinerlayout, list);
            dataAdapter2.setDropDownViewResource(R.layout.spinerlayout);
            dataAdapter2.notifyDataSetChanged();
            spin2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Event And Wedding Services")) {
            List<String> list = new ArrayList<String>();
            list.add("Party Caterers");
            list.add("Birthday Party Planner");
            list.add("Bridal Mehndi Artis");
            list.add("Corporate Event Planner");
            list.add("DJ & Garba Event");
            list.add("Event Photographer");
            list.add("Pre Wedding Shoot");
            list.add("Florist & Decorators");
            list.add(" Wedding Photographer");
            list.add("Wedding Planner");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinerlayout, list);
            dataAdapter2.setDropDownViewResource(R.layout.spinerlayout);
            dataAdapter2.notifyDataSetChanged();
            spin2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Beaauty And Health Services")) {
            List<String> list = new ArrayList<String>();
            list.add("Dietitian");
            list.add("Party Makeup Artist");
            list.add("Physiotherapy At Home");
            list.add("Yoga Trainer At Home");
            list.add("Salon At Home");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinerlayout, list);
            dataAdapter2.setDropDownViewResource(R.layout.spinerlayout);
            dataAdapter2.notifyDataSetChanged();
            spin2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Other Services")) {
            List<String> list = new ArrayList<String>();
            list.add("Documentary Service");
            list.add("Tours & Travels");
            list.add("PC & Laptop On Rent");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinerlayout, list);
            dataAdapter2.setDropDownViewResource(R.layout.spinerlayout);
            dataAdapter2.notifyDataSetChanged();
            spin2.setAdapter(dataAdapter2);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public static boolean isValidPhone(String phone) {
        String expression = "^([0-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{3,15}$";
        CharSequence inputString = phone;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onClick(View view)
    {
        if (validation()==true) {
            //validation();
            String name, number, email, city, address, date;
            name = et_name.getText().toString();
            number = ph_number.getText().toString();
            email = emailid.getText().toString();
            city = et_city.getText().toString();
            address = et_address.getText().toString();

            Intent intentemail = new Intent(Intent.ACTION_SEND);
            intentemail.putExtra(Intent.EXTRA_TEXT, name);
            intentemail.putExtra(Intent.EXTRA_TEXT, number);
            intentemail.putExtra(Intent.EXTRA_TEXT, email);
            intentemail.putExtra(Intent.EXTRA_TEXT, city);
            intentemail.putExtra(Intent.EXTRA_TEXT, address);
            intentemail.putExtra(Intent.EXTRA_EMAIL, new String[]{"sojitraravi82@gmail.com"});
            intentemail.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intentemail.setType("message/rfc822");
            startActivity(Intent.createChooser(intentemail, "Choose an Email client :"));
        }
    }

    public boolean validation()
    {

        String phone = ph_number.getText().toString();
        String email_ = emailid.getText().toString();
        if (et_name.getText().toString().length() == 0) {
            et_name.setError("Name Is Missing");
            et_name.requestFocus();
        } else if (ph_number.getText().toString().length()==0) {
            ph_number.setError("Enetr Valid Mobile Number");
            ph_number.requestFocus();
        } else if (!isValidEmail(email_)) {
            emailid.setError("Please enter valid Email !");
            emailid.requestFocus();
        } else if (et_city.getText().toString().length() == 0) {
            et_city.setError("City Is Missing");
            et_city.requestFocus();
        } else if (et_address.getText().toString().length() == 0) {
            et_address.setError("Address Is Missing");
            et_address.requestFocus();
        }
        return false;
    }
}
