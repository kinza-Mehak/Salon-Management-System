package com.business.beautybar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserShowAllPackagesFragment extends BaseFragment {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    UserAllPackagesAdapter allPackagesAdapter;
    ListView listView;

    public UserShowAllPackagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_show_all_packages, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        allPackagesAdapter=new UserAllPackagesAdapter(getContext(),R.layout.user_all_packages_layout);
        listView=(ListView)getView().findViewById(R.id.listView);
        listView.setAdapter(allPackagesAdapter);
        json_string=JsonString.fetch_all_user_packages;
        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            String package_type="";
            String package_name="";
            String package_price="";
            String package_description="";
            String shop_name="";
            String shop_phone="";
            while (count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                package_type= JO.getString("package_type");
                package_name= JO.getString("package_title");
                package_price= JO.getString("package_price");
                package_description= JO.getString("package_description");
                shop_name= JO.getString("shop_name");
                shop_phone= JO.getString("shop_phone");

                Package objPackage=new Package(package_type,package_name,package_price,package_description,shop_name,shop_phone);

                allPackagesAdapter.add(objPackage);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
