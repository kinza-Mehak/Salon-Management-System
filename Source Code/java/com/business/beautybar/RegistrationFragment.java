package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends BaseFragment implements View.OnClickListener {
    Button mCustomerButton,mBeauticianButton;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();
    }

    private void init()
    {
        mCustomerButton=(Button)getView().findViewById(R.id.btn_customer);
        mBeauticianButton=(Button)getView().findViewById(R.id.btn_beautician);
    }

    private void listen()
    {
        mCustomerButton.setOnClickListener(this);
        mBeauticianButton.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_customer)
        {
            UserLoginFragment mFrag=new UserLoginFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
        else if(id==R.id.btn_beautician)
        {

            ShopLoginFragment mFrag=new ShopLoginFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
    }
}
