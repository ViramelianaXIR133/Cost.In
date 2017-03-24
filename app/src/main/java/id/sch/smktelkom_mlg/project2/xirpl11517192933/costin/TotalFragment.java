package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalFragment extends Fragment implements View.OnClickListener {

    public TotalFragment() {
        // Required empty public constructor
    }


    //private Context CurrentObj=this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.total_layout, container, false);

        Button totBtn = (Button) rootView.findViewById(R.id.buttonGaji);


        totBtn.setOnClickListener(this);
        return rootView;
        // Inflate the layout for this fragment


//        return v;
        //return inflater.inflate(R.layout.total_layout, container, false);
//return rootView();


    }

//    @Override
//    public void onClick(View view) {
//        if(!menuVisible)
//        {
//            FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            fm.beginTransaction();
//            Fragment fragOne = new GajiFragment();
//            ft.show(fragOne);
//        }
//        else
//        {
//            FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//
//            fm.beginTransaction();
//            // it's wrong , you just hide the fragment that not added to  FragmentTransaction
//            Fragment fragOne = new GajiFragment();
//            ft.hide(fragOne);
//        }
//    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.buttonGaji:
                fragment = new GajiFragment();
                replaceFragment(fragment);
                View frag = getView().findViewById(R.id.fragmenttotal);
                frag.setVisibility(View.GONE);
                break;

        }
    }


    public void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
