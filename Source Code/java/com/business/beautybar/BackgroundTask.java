package com.business.beautybar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;



public class BackgroundTask extends AsyncTask<String,Void,String>
{
    String user_register_url="https://beautybarbusiness.000webhostapp.com/user_register.php";
    String shop_register_url="https://beautybarbusiness.000webhostapp.com/shop_register.php";
    String user_login_url="http://beautybarbusiness.000webhostapp.com/user_login.php";
    String shop_login_url="http://beautybarbusiness.000webhostapp.com/shop_login.php";
    String fetch_user_profile_url="http://beautybarbusiness.000webhostapp.com/fetch_user_profile.php";
    String fetch_shop_profile_url="http://beautybarbusiness.000webhostapp.com/fetch_shop_profile.php";
    String add_package_url="http://beautybarbusiness.000webhostapp.com/add_package.php";
    String fetch_user_all_packages_url="http://beautybarbusiness.000webhostapp.com/fetch_all_packages.php";
    String fetch_current_shop_packages_url="http://beautybarbusiness.000webhostapp.com/fetch_all_packages.php";
    String status="";

    Context ctx;
    FragmentHelper mHelper;
    String JSON_STRING="";

    BackgroundTask(FragmentHelper mHelper,Context ctx)
    {
        this.mHelper=mHelper;
        this.ctx=ctx;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected String doInBackground(String... voids)
    {
        String method= voids[0];
        if(method.equals("register_user"))
        {
            String name=voids[1];
            String phone=voids[2];
            String gender=voids[3];
            String age=voids[4];
            String password=voids[5];

            try {
                URL url=new URL(user_register_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));


                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"+
                        URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "user_register";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        else if(method.equals("register_shop"))
        {
            String name=voids[1];
            String phone=voids[2];
            String years=voids[3];
            String employees=voids[4];
            String address=voids[5];
            String password=voids[6];

            try {
                URL url=new URL(shop_register_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));


                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("years","UTF-8")+"="+URLEncoder.encode(years,"UTF-8")+"&"+
                        URLEncoder.encode("employees","UTF-8")+"="+URLEncoder.encode(employees,"UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "shop_register";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }








        else if(method.equals("user_login"))
        {
            String phone=voids[1];
            String pass=voids[2];
            URL url= null;
            try {
                url = new URL(user_login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                status="user_login";
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("shop_login"))
        {
            String phone=voids[1];
            String pass=voids[2];
            URL url= null;
            try {
                url = new URL(shop_login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                status="shop_login";
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("fetch_user_profile"))
        {
            String phone=voids[1];
            String pass=voids[2];
            URL url= null;
            try {
                url = new URL(fetch_user_profile_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                status="fetch_user_profile";
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        else if(method.equals("fetch_shop_profile"))
        {
            String phone=voids[1];
            String pass=voids[2];
            URL url= null;
            try {
                url = new URL(fetch_shop_profile_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                status="fetch_shop_profile";
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("add_package"))
        {
            String type=voids[1];
            String name=voids[2];
            String price=voids[3];
            String description=voids[4];
            String phone=voids[5];
            String shop_name=voids[6];

            try {
                URL url=new URL(add_package_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));


                String data= URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode(type,"UTF-8")+"&"+
                        URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("price","UTF-8")+"="+URLEncoder.encode(price,"UTF-8")+"&"+
                        URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("shop_name","UTF-8")+"="+URLEncoder.encode(shop_name,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "add_package";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }









        else if(method.equals("fetch_all_packages"))
        {
            URL url= null;
            try {
                url = new URL(fetch_user_all_packages_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                status="fetch_user_all_packages";
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    else if(method.equals("fetch_current_shop_packages"))
    {
        String shop_phone=voids[1];
        URL url= null;
        try {

            url = new URL(fetch_current_shop_packages_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();


            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while ((JSON_STRING=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(JSON_STRING+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            status="fetch_current_shop_packages";
            return stringBuilder.toString().trim();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }









        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        if (result.equals("user_register"))
        {
            Toast.makeText(ctx, "User registered successfully", Toast.LENGTH_SHORT).show();
        }
        else if (result.equals("shop_register"))
        {
            Toast.makeText(ctx, "Shop registered successfully", Toast.LENGTH_SHORT).show();
        }
        else if(status.equals("user_login"))
        {
            if(result.equals("login failed"))
            {
                Toast.makeText(ctx, "Incorrect details", Toast.LENGTH_SHORT).show();
            }
            else
            {
                parseUserJSON(result);
                Toast.makeText(ctx, "Please wait", Toast.LENGTH_SHORT).show();
                MenuFragment mFrag=new MenuFragment();
                mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);

            }

        }
        else if(status.equals("shop_login"))
        {
            if(result.equals("login failed"))
            {
                Toast.makeText(ctx, "Incorrect details", Toast.LENGTH_SHORT).show();
            }
            else
            {
                parseShopJSON(result);
                Toast.makeText(ctx, "Please wait", Toast.LENGTH_SHORT).show();
                ShopMenuFragment mFrag=new ShopMenuFragment();
                mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);

            }
        }
        else if(status.equals("fetch_user_profile"))
        {
            parseUserJSON(result);
        }
        else if(status.equals("fetch_shop_profile"))
        {
            parseShopJSON(result);
        }
        else if (result.equals("add_package"))
        {
            Toast.makeText(ctx, "Package Added Successfully", Toast.LENGTH_SHORT).show();
        }
        else if (status.equals("fetch_user_all_packages"))
        {
                JsonString.fetch_all_user_packages=result;
                UserShowAllPackagesFragment mFrag=new UserShowAllPackagesFragment();
                mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);

        }
        else if (status.equals("fetch_current_shop_packages"))
        {
            JsonString.fetch_current_shop_packages=result;
            ShopViewPackageFragment mFrag=new ShopViewPackageFragment();
            mHelper.replaceFragment(R.id.framelayout_home,mFrag,false);

        }
    }

    private void parseUserJSON(String result)
    {
        String json_string;
        JSONObject jsonObject;
        JSONArray jsonArray;
        json_string=result;
        String name="";
        String phone="";
        String age="";
        String gender="";
        String password="";

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
                JSONObject JO=jsonArray.getJSONObject(0);
                name= JO.getString("name");
                phone= JO.getString("phone");
                age= JO.getString("age");
                gender= JO.getString("gender");
                password= JO.getString("password");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        CurrentUserSession.name=name;
        CurrentUserSession.phone=phone;
        CurrentUserSession.age=age;
        CurrentUserSession.gender=gender;
        CurrentUserSession.password=password;
    }



    private void parseShopJSON(String result)
    {
        String json_string;
        JSONObject jsonObject;
        JSONArray jsonArray;
        json_string=result;
        String shop_name="";
        String address="";
        String total_years="";
        String total_employees="";
        String shop_phone="";
        String password="";

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
            JSONObject JO=jsonArray.getJSONObject(0);
            shop_name= JO.getString("shop_name");
            address= JO.getString("address");
            total_years= JO.getString("total_years");
            total_employees= JO.getString("total_employees");
            shop_phone= JO.getString("shop_phone");
            password= JO.getString("password");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        CurrentShopSession.shop_name=shop_name;
        CurrentShopSession.address=address;
        CurrentShopSession.total_years=total_years;
        CurrentShopSession.total_employees=total_employees;
        CurrentShopSession.shop_phone=shop_phone;
        CurrentShopSession.password=password;
    }



}