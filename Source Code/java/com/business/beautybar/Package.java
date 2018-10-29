package com.business.beautybar;


public class Package
{
    String package_type="";
    String package_name="";
    String package_price="";
    String package_description="";
    String shop_name="";
    String shop_contact="";

    public Package(String package_type,String package_name,String package_price,String package_description,String shop_name,String shop_contact)
    {
        this.package_type=package_type;
        this.package_name=package_name;
        this.package_price=package_price;
        this.package_description=package_description;
        this.shop_name=shop_name;
        this.shop_contact=shop_contact;
    }

    public String getPackage_type() {
        return package_type;
    }

    public void setPackage_type(String package_type) {
        this.package_type = package_type;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getPackage_price() {
        return package_price;
    }

    public void setPackage_price(String package_price) {
        this.package_price = package_price;
    }

    public String getPackage_description() {
        return package_description;
    }

    public void setPackage_description(String package_description) {
        this.package_description = package_description;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_contact() {
        return shop_contact;
    }

    public void setShop_contact(String shop_contact) {
        this.shop_contact = shop_contact;
    }
}
