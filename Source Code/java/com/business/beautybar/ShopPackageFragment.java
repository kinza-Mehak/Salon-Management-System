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
public class ShopPackageFragment extends BaseFragment implements View.OnClickListener {
    Button mButtonAddPackage,mButtonViewPackage;

    public ShopPackageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_package, container, false);
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
        mButtonAddPackage=(Button)getView().findViewById(R.id.btn_add_package);
        mButtonViewPackage=(Button)getView().findViewById(R.id.btn_view_package);
    }

    private void listen()
    {
        mButtonAddPackage.setOnClickListener(this);
        mButtonViewPackage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_add_package)
        {
            ShopPackageTypeFragment mFrag=new ShopPackageTypeFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }
        else if(id==R.id.btn_view_package)
        {

            String shop_phone=CurrentShopSession.shop_phone;
            String method = "fetch_current_shop_packages";
            BackgroundTask backgroundTask = new BackgroundTask(mHelper,getActivity().getApplicationContext());
            backgroundTask.execute(method,shop_phone);

        }
    }
}
