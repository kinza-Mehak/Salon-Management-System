package com.business.beautybar;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class UserAllPackagesAdapter extends ArrayAdapter
{
    List list=new ArrayList();
    public UserAllPackagesAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public void add(Package object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.user_all_packages_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.txtPackageType=(TextView)row.findViewById(R.id.package_type);
            contactHolder.txtPackageTitle=(TextView)row.findViewById(R.id.package_title);
            contactHolder.txtPackageDescription=(TextView)row.findViewById(R.id.package_description);
            contactHolder.txtPackagePrice=(TextView)row.findViewById(R.id.package_price);
            contactHolder.txtShopName=(TextView)row.findViewById(R.id.shop_name);
            contactHolder.txtShopPhone=(TextView)row.findViewById(R.id.shop_phone);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder)row.getTag();
        }
        Package obj=(Package) this.getItem(position);
        contactHolder.txtPackageType.setText(obj.getPackage_type()+" Package");
        contactHolder.txtPackageTitle.setText("Title : "+obj.getPackage_name());
        contactHolder.txtPackageDescription.setText("Description : "+obj.getPackage_description());
        contactHolder.txtPackagePrice.setText("Price : "+obj.getPackage_price());
        contactHolder.txtShopName.setText("Shop : "+obj.getShop_name());
        contactHolder.txtShopPhone.setText("Phone : "+obj.getShop_contact());
        return row;

    }

    static class ContactHolder
    {
        TextView txtPackageType,txtPackageTitle,txtPackagePrice,txtPackageDescription,txtShopName,txtShopPhone;
    }



}
