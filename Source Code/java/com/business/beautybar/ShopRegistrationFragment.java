package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopRegistrationFragment extends BaseFragment implements View.OnClickListener{

    EditText mEditTextNameSignup,mEditTextNumberSignup,mEditTextYearsSignup,mEditTextEmployeesSignup,mEditTextPasswordSignup,
    mEditTextAddressSignup;
    Button mButtonSignupDone;
    TextView mTextViewLogin;

    public ShopRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();
    }

    private void init()
    {
        mEditTextNameSignup=(EditText)getView().findViewById(R.id.et_signup_name);
        mEditTextNumberSignup=(EditText)getView().findViewById(R.id.et_signup_number);
        mEditTextYearsSignup=(EditText)getView().findViewById(R.id.et_signup_years);
        mEditTextEmployeesSignup=(EditText)getView().findViewById(R.id.et_signup_employees);
        mEditTextAddressSignup=(EditText)getView().findViewById(R.id.et_signup_address);
        mEditTextPasswordSignup=(EditText)getView().findViewById(R.id.et_signup_password);
        mButtonSignupDone=(Button)getView().findViewById(R.id.btn_sgnp);
        mTextViewLogin=(TextView)getView().findViewById(R.id.txt_login);
    }

    private void listen()
    {
        mButtonSignupDone.setOnClickListener(this);
        mTextViewLogin.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_registration, container, false);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_sgnp)
        {
            String name=mEditTextNameSignup.getText().toString();
            String phone=mEditTextNumberSignup.getText().toString();
            String years=mEditTextYearsSignup.getText().toString();
            String employees=mEditTextEmployeesSignup.getText().toString();
            String address=mEditTextAddressSignup.getText().toString();
            String password=mEditTextPasswordSignup.getText().toString();
            String method="register_shop";
            BackgroundTask backgroundTask=new BackgroundTask(mHelper,getContext());
            backgroundTask.execute(method,name,phone,years,employees,address,password);

        }
        else if(id==R.id.txt_login)
        {
            UserLoginFragment mFrag=new UserLoginFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }

    }

}
