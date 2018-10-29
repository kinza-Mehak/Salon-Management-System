package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFacialPackageFragment extends BaseFragment implements View.OnClickListener{

    EditText mEditTextPackageName,mEditTextPackagePrice,mEditTextPackageDescription;
    Button mButtonAddPackage;

    public ShopFacialPackageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_facial_package, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();
    }

    private void init()
    {
        mEditTextPackageName=(EditText)getView().findViewById(R.id.et_package_name);
        mEditTextPackagePrice=(EditText)getView().findViewById(R.id.et_package_price);
        mEditTextPackageDescription=(EditText)getView().findViewById(R.id.et_package_description);
        mButtonAddPackage=(Button)getView().findViewById(R.id.btn_add_package);
    }

    private void listen()
    {
        mButtonAddPackage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_add_package)
        {
            String type="facial";
            String package_name=mEditTextPackageName.getText().toString();
            String package_price=mEditTextPackagePrice.getText().toString();
            String package_description=mEditTextPackageDescription.getText().toString();
            String phone=CurrentShopSession.shop_phone;
            String shop_name=CurrentShopSession.shop_name;

            String method="add_package";
            BackgroundTask backgroundTask=new BackgroundTask(mHelper,getActivity().getApplicationContext());
            backgroundTask.execute(method,type,package_name,package_price,package_description,phone,shop_name);
        }
    }
}
