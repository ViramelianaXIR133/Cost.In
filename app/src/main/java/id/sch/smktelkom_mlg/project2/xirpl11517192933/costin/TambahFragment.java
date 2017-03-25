package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahFragment extends Fragment {

    TextView etTgl;
//    int mYear;
//    int mMonth;
//    int mDay;


    Database myDb;
    EditText etRp, etDetail;
    Spinner spJenis;
    DatePicker date;
    Button btnSimpan;
//Date d;

    public TambahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tambah_layout, container, false);
        myDb = new Database(getActivity());

        etRp = (EditText) v.findViewById(R.id.editTextRp);
        etDetail = (EditText) v.findViewById(R.id.editTextDetail);
        spJenis = (Spinner) v.findViewById(R.id.spinnerJenis);
        btnSimpan = (Button) v.findViewById(R.id.buttonSimpan);
        date = (DatePicker) v.findViewById(R.id.datePicker);


        AddData();

//        final Calendar myCalendar = Calendar.getInstance();
//
//        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateLabel();
//            }
//        };
//
//        etTgl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                new DatePickerDialog(TambahFragment.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//        etTgl.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onClick(View view) {
//                Calendar mcurrentDate = Calendar.getInstance();
//                mYear = mcurrentDate.get(Calendar.YEAR);
//                mMonth = mcurrentDate.get(Calendar.MONTH);
//                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    public void onDateSet(DatePicker datePicker, int selectedyear, int selectedmonth, int selectedday) {
//
//                    }
//                }, mYear, mMonth, mDay);
//                mDatePicker.setTitle("Select date");
//                mDatePicker.show();
//            }
//        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.tambah_layout, container, false);
        return v;
    }

//        String datestring
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
//        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyy");
//        Date dDate = dateFormatter.parse(String )
//        return dateFormatter.format(date);


//    public  void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
//       calendar.set (year,monthOfYear,dayOfMonth);
//
//        int years = year;   // Here you can get day,month and year.
//        int month = monthOfYear;
//        int day = dayOfMonth;
//
//        ContentValues values = new ContentValues();
//
//        values.put("Day",dayOfMonth);
//        values.put("Month",monthOfYear);
//        values.put("Year",year);
//
//    }

    private void AddData() {
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Calendar calendar = Calendar.getInstance();
//                int day = date.getDayOfMonth();
//                int mounth = date.getMonth() + 1;
//                int year = date.getYear();





                boolean isInserted = myDb.insertData(etRp.getText().toString(),
                        spJenis.getSelectedItem().toString(),
                        etDetail.getText().toString());
                if (isInserted == true)
                    Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

}
