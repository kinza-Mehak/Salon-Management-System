package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopProfileFragment extends BaseFragment {
    ImageButton mImageButtonShopProfilePic;
    TextView mTextViewShopName,mTextViewShopAddress,mTextViewShopTotalYears,mTextViewShopTotalEmployees,
            mTextViewShopPhone,mTextViewShopPassword;

    public ShopProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        init();
        fetchValues();
        assignProfileValues();
    }

    private void init()
    {
        mImageButtonShopProfilePic=(ImageButton)getView().findViewById(R.id.shop_profile_photo);
        mTextViewShopName=(TextView)getView().findViewById(R.id.shop_profile_name);
        mTextViewShopAddress=(TextView)getView().findViewById(R.id.shop_address);
        mTextViewShopTotalYears=(TextView)getView().findViewById(R.id.shop_years);
        mTextViewShopTotalEmployees=(TextView)getView().findViewById(R.id.shop_employees);
        mTextViewShopPhone=(TextView)getView().findViewById(R.id.shop_phone);
        mTextViewShopPassword=(TextView)getView().findViewById(R.id.shop_password);
    }

    private void fetchValues()
    {
        String method = "fetch_shop_profile";
        BackgroundTask backgroundTask = new BackgroundTask(mHelper,getActivity().getApplicationContext());
        backgroundTask.execute(method, CurrentShopSession.shop_name,CurrentShopSession.shop_phone);
    }


    private void assignProfileValues()
    {
        mTextViewShopName.setText(""+CurrentShopSession.shop_name);
        mTextViewShopAddress.setText("Address : "+CurrentShopSession.address);
        mTextViewShopTotalYears.setText("Total years : "+CurrentShopSession.total_years);
        mTextViewShopTotalEmployees.setText("Total employees : "+CurrentShopSession.total_employees);
        mTextViewShopPhone.setText("Phone : "+CurrentShopSession.shop_phone);
        mTextViewShopPassword.setText("Password : "+CurrentShopSession.password);
    }



}
