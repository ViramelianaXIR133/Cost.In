package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalFragment extends Fragment {

    public TotalFragment() {
        // Required empty public constructor
    }


    //private Context CurrentObj=this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
//       View t = inflater.inflate(R.layout.total_layout, container, false);
//t.findViewById(R.id.buttonGaji).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public  void onClick(View v){
//      //  startActivity(new Intent(TotalFragment.this, GajiFragment.class));
//        Intent redirect=new Intent(TotalFragment.getApplicationContext(),GajiFragment.class);
//        startActivity(redirect);
//    }
//
//});
        View t = inflater.inflate(R.layout.total_layout, container, false);
        Button totalBtn = (Button) t.findViewById(R.id.buttonGaji);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//
////                Intent redirect=new Intent(CurrentObj.getApplicationContext(),GajiFragment.class);
////                startActivity(redirect);
//                Fragment fragment = new TotalFragment();
//             Intent redirect=new Intent(fragment.getActivity(), GajiFragment.class);
//     fragment.startActivity(redirect);

////            Fragment fragment = new GajiFragment();
//
//
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                TotalFragment llf = new TotalFragment();
                ft.replace(R.id.fragmentgaji, llf);
                ft.commit();
            }
        });
        return inflater.inflate(R.layout.total_layout, container, false);
//return rootView();


    }


}
