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
public class UserRegistrationFragment extends BaseFragment implements View.OnClickListener{

    EditText mEditTextNameSignup,mEditTextNumberSignup,mEditTextAgeSignup,mEditTextGenderSignup,mEditTextPasswordSignup;
    Button mButtonSignupDone;
    TextView mTextViewLogin;
    public UserRegistrationFragment() {
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
        mEditTextAgeSignup=(EditText)getView().findViewById(R.id.et_signup_age);
        mEditTextGenderSignup=(EditText)getView().findViewById(R.id.et_signup_gender);
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
        return inflater.inflate(R.layout.fragment_user_registration, container, false);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_sgnp)
        {
            String name=mEditTextNameSignup.getText().toString();
            String phone=mEditTextNumberSignup.getText().toString();
            String gender=mEditTextGenderSignup.getText().toString();
            String age=mEditTextAgeSignup.getText().toString();
            String password=mEditTextPasswordSignup.getText().toString();
            String method="register_user";
            BackgroundTask backgroundTask=new BackgroundTask(mHelper,getActivity().getApplicationContext());
            backgroundTask.execute(method,name,phone,gender,age,password);

        }
        else if(id==R.id.txt_login)
        {
            UserLoginFragment mFrag=new UserLoginFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);
        }

    }

}
