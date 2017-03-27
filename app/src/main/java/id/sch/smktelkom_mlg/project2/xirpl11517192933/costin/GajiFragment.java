package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class GajiFragment extends Fragment {

    EditText ejumlah;
    Spinner spilih;
    Button bsimpan;
    Database myDb;
    public GajiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment}
        View view = inflater.inflate(R.layout.fragment_gaji, container, false);
        myDb = new Database(getActivity());


        ejumlah = (EditText) view.findViewById(R.id.editTextgaji);
        spilih = (Spinner) view.findViewById(R.id.spinnerPilih);
        bsimpan = (Button) view.findViewById(R.id.buttonSimpangaji);

        AddData();


        return view;
    }

    private void AddData() {
        bsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserttotal = myDb.insertTotal(ejumlah.getText().toString(),
                        spilih.getSelectedItem().toString());

                if (inserttotal == true)
                    Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }


}

