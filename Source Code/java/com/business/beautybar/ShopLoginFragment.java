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
public class ShopLoginFragment extends BaseFragment implements View.OnClickListener {
    EditText mEditTextPhone, mEditTextPasswordLogin;
    Button mButtonLoginDone;
    TextView mTextViewCreateNew;


    public ShopLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        listen();

    }

    private void init() {
        mEditTextPhone = (EditText) getView().findViewById(R.id.et_login_phone);
        mEditTextPasswordLogin = (EditText) getView().findViewById(R.id.et_login_password);
        mButtonLoginDone = (Button) getView().findViewById(R.id.btn_lgn);
        mTextViewCreateNew = (TextView) getView().findViewById(R.id.txt_new_account);
    }

    private void listen() {
        mButtonLoginDone.setOnClickListener(this);
        mTextViewCreateNew.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_login, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_lgn)
        {
            String phone=mEditTextPhone.getText().toString();
            String password=mEditTextPasswordLogin.getText().toString();
            String method = "shop_login";
            BackgroundTask backgroundTask = new BackgroundTask(mHelper,getActivity().getApplicationContext());
            backgroundTask.execute(method, phone, password);
        } else if (id == R.id.txt_new_account) {
            ShopRegistrationFragment mFrag=new ShopRegistrationFragment();
            mHelper.replaceFragment(R.id.framelayout_home, mFrag, false);
        }

    }
}
