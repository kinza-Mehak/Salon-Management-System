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
public class ShopPackageTypeFragment extends BaseFragment implements View.OnClickListener {
        Button mButtonBridalPackage,mButtonFacialPackage,mButtonHairStylePackage;


public ShopPackageTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_package_type, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();
    }

    private void init()
    {
        mButtonBridalPackage=(Button)getView().findViewById(R.id.btn_bridal_package);
        mButtonFacialPackage=(Button)getView().findViewById(R.id.btn_facial_package);
        mButtonHairStylePackage=(Button)getView().findViewById(R.id.btn_hairstyle_package);
    }

    private void listen()
    {
        mButtonBridalPackage.setOnClickListener(this);
        mButtonFacialPackage.setOnClickListener(this);
        mButtonHairStylePackage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_bridal_package)
        {
            ShopBridalPackageFragment mFrag=new ShopBridalPackageFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
        else if(id==R.id.btn_facial_package)
        {

            ShopFacialPackageFragment mFrag=new ShopFacialPackageFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
        else if(id==R.id.btn_hairstyle_package)
        {

            ShopHairStylePackageFragment mFrag=new ShopHairStylePackageFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
    }

}
