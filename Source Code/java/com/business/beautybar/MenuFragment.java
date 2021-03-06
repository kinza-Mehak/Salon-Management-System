package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends BaseFragment implements View.OnClickListener{
    LinearLayout mLinearLayoutOne,mLinearLayoutTwo,mLinearLayoutThree,mLinearLayoutFour;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();
    }

    private void init()
    {
        mLinearLayoutOne=(LinearLayout)getView().findViewById(R.id.layout_one);
        mLinearLayoutTwo=(LinearLayout)getView().findViewById(R.id.layout_two);
        mLinearLayoutThree=(LinearLayout)getView().findViewById(R.id.layout_three);
        mLinearLayoutFour=(LinearLayout)getView().findViewById(R.id.layout_four);
    }

    private void listen()
    {
        mLinearLayoutOne.setOnClickListener(this);
        mLinearLayoutTwo.setOnClickListener(this);
        mLinearLayoutThree.setOnClickListener(this);
        mLinearLayoutFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.layout_one)
        {
            Toast.makeText(getContext(), "Under construction", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.layout_two)
        {
            String method = "fetch_all_packages";
            BackgroundTask backgroundTask = new BackgroundTask(mHelper,getActivity().getApplicationContext());
            backgroundTask.execute(method);
        }
        else if(id==R.id.layout_three)
        {
            Toast.makeText(getContext(), "Under construction", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.layout_four)
        {
            UserProfileFragment mFrag=new UserProfileFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
    }
}
