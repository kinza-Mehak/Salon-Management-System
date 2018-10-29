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
public class UserProfileFragment extends BaseFragment implements View.OnClickListener{

    ImageButton mImageButtonUserProfilePic;
    TextView mTextViewUserName,mTextViewUserPhone,mTextViewUserAge,mTextViewUserGender,mTextViewUserPassword;
    TextView mTextViewEditUserProfile;
    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
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
        mImageButtonUserProfilePic=(ImageButton)getView().findViewById(R.id.user_profile_photo);
        mTextViewUserName=(TextView) getView().findViewById(R.id.user_profile_name);
        mTextViewUserPhone=(TextView) getView().findViewById(R.id.user_phone_number);
        mTextViewUserAge=(TextView) getView().findViewById(R.id.user_age);
        mTextViewUserGender=(TextView) getView().findViewById(R.id.user_gender);
        mTextViewUserPassword=(TextView) getView().findViewById(R.id.user_password);
        mTextViewEditUserProfile=(TextView)getView().findViewById(R.id.edit_user_profile);
        fetchValues();
        assignProfileValues();
    }

    private void fetchValues()
    {
        String method = "fetch_user_profile";
        BackgroundTask backgroundTask = new BackgroundTask(mHelper,getActivity().getApplicationContext());
        backgroundTask.execute(method, CurrentUserSession.name,CurrentUserSession.phone);
    }

    private void assignProfileValues()
    {
        mTextViewUserName.setText(""+CurrentUserSession.name);
        mTextViewUserPhone.setText("Phone : "+CurrentUserSession.phone);
        mTextViewUserAge.setText("Age : "+CurrentUserSession.age);
        mTextViewUserGender.setText("Gender : "+CurrentUserSession.gender);
        mTextViewUserPassword.setText("Password : "+CurrentUserSession.password);
    }

    private void listen()
    {
        mTextViewEditUserProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.edit_user_profile)
        {

        }
    }
}
