package services;

import entity.Users;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.prefs.Preferences;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ehsas
 */
public class UserServices {

    Preferences prefs = Preferences.userNodeForPackage(services.UserServices.class);
    String defaultValue = "ehsas";
    String bussId = prefs.get("bussinessId", defaultValue);

    public String logInUser(String userName, String password) {

        String record = "";
        String reqBusId = "";
        String storeName = "";
        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            URL url = new URL("http://www.stores.wiki/app_panel/login.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8");
            param += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();

            JSONArray array = new JSONArray(data);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                record = obj.getString("record");
                reqBusId = obj.getString("reg_bus_id");
                storeName = obj.getString("store_name");

            }

            if (record.equals("1")) {

                // Retrieve the user preference node for the package name
                Preferences prefs = Preferences.userNodeForPackage(services.UserServices.class);

                // Preference key name
                String USER_NAME = "userName";
                String PASSWORD = "password";
                String BUSS_ID = "bussinessId";
                String STORE_NAME = "storeName";

                // Set the value of the preference
                //String newValue = reqBusId;
                prefs.put(USER_NAME, userName);
                prefs.put(PASSWORD, password);
                prefs.put(BUSS_ID, reqBusId);
                prefs.put(STORE_NAME, storeName);

            }

        } catch (Exception e) {
        }
        return record;
    }

    public boolean addAdminInfo(String name, String password, String conformPass) {

        Preferences prefs = Preferences.userNodeForPackage(services.UserServices.class);
        String defaultValue = "ehsas";
        String bussId = prefs.get("bussinessId", defaultValue); //
        //System.out.println("the value is" + bussId);

        boolean status = false;
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/add_sub_admins.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            param += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            param += "&" + URLEncoder.encode("reg_bus_id", "UTF-8") + "=" + URLEncoder.encode(bussId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();

            if (data.equals("1")) {
                System.out.println("Admin added sucessfully");
                status = true;

            } else {
                System.out.println("Admin Not added");
            }

        } catch (Exception e) {
        }
        return status;
    }

    public List<Users> getSubAdmin() {

        List<Users> vectorSubAdmin = new ArrayList<Users>();
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/return_sub_admin.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("reg_bus_id", "UTF-8") + "=" + URLEncoder.encode(bussId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();
            JSONArray array = new JSONArray(data);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Users users = new Users();
                users.setUserId(obj.getString("id"));
                users.setUsername(obj.getString("username"));

                vectorSubAdmin.add(users);
            }
        } catch (Exception ex) {

        }

        return vectorSubAdmin;
    }

    public boolean deleteAdmin(String userId) {
    
        boolean status = false;
        try {
            URL url = new URL("http://www.stores.wiki/app_panel/delete_sub_admin.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();

            if (data.equals("1")) {
                status = true;

            } else {
            }

        } catch (Exception e) {
        }
        return status;
    }

    public boolean updateAdmin(String userId,String userName,String password) {
        
        boolean status = false;
        try {
            URL url = new URL("http://www.stores.wiki/app_panel/update_sub_admin.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");
            param += "&" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8");
            param += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();

            if (data.equals("1")) {
                status = true;

            } else {
            }

        } catch (Exception e) {
        }
        return status;
    }

}
