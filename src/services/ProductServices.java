/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entity.Product;
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
public class ProductServices {
    
       Preferences prefs = Preferences.userNodeForPackage(services.UserServices.class);
        String defaultValue = "ehsas";
        String bussId = prefs.get("bussinessId", defaultValue);

    public boolean addProductDetail(String name, String catId, String subCatId, String model, String quantity, String code, String sku, String parchasePrice, String salePrice, String description) {

        boolean status = false;
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/add_product.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            param += "&" + URLEncoder.encode("cat_id", "UTF-8") + "=" + URLEncoder.encode(catId, "UTF-8");
            param += "&" + URLEncoder.encode("sub_cat_id", "UTF-8") + "=" + URLEncoder.encode(subCatId, "UTF-8");
            param += "&" + URLEncoder.encode("model", "UTF-8") + "=" + URLEncoder.encode(model, "UTF-8");
            param += "&" + URLEncoder.encode("quantity", "UTF-8") + "=" + URLEncoder.encode(quantity, "UTF-8");
            param += "&" + URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8");
            param += "&" + URLEncoder.encode("sku", "UTF-8") + "=" + URLEncoder.encode(sku, "UTF-8");
            param += "&" + URLEncoder.encode("purchase_price", "UTF-8") + "=" + URLEncoder.encode(parchasePrice, "UTF-8");
            param += "&" + URLEncoder.encode("sale_price", "UTF-8") + "=" + URLEncoder.encode(salePrice, "UTF-8");
            param += "&" + URLEncoder.encode("desc", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8");
            param += "&" + URLEncoder.encode("reg_bus_id", "UTF-8") + "=" + URLEncoder.encode(bussId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();

            if (data.equals("1")) {
                //System.out.println("Product detail added sucessfully");
                status = true;

            } else {
                //System.out.println("Product detail not added");
            }

        } catch (Exception e) {
        }
        return status;

    }

    public List<Product> getProductDetail() {

        List<Product> vectorProductDetail = new ArrayList<Product>();
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/grid/grid.php");
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

                Product product = new Product();

                product.setProId(obj.getString("id"));
                product.setProName(obj.getString("pro_name"));
                product.setProCode(obj.getString("pro_code"));
                product.setProQuantity(obj.getString("pro_qty"));
                product.setProSku(obj.getString("pro_sku"));
                product.setPurchasePrice(obj.getString("purchase_price"));
                product.setSalePrice(obj.getString("sale_price"));

                vectorProductDetail.add(product);
            }
        } catch (Exception ex) {

        }

        return vectorProductDetail;
    }
    
    public List<Product> getSubProductDetail(String orderId) {

        List<Product> vectorSubProductDetail = new ArrayList<Product>();
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/return_sub_orders.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(orderId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();
            JSONArray array = new JSONArray(data);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Product product = new Product();

                product.setProName(obj.getString("p_name"));
                product.setProCode(obj.getString("p_code"));
                product.setProModel(obj.getString("p_model"));
                product.setProSku(obj.getString("p_sku"));
                product.setProPrice(obj.getString("p_price"));
                product.setProAttribute(obj.getString("p_attr"));

                vectorSubProductDetail.add(product);
            }
        } catch (Exception ex) {

        }

        return vectorSubProductDetail;
    }

    public boolean deleteProduct(String productId) {
    
         boolean status = false;
        try {
            URL url = new URL("http://www.stores.wiki/app_panel/grid/delete_grid.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("p_id", "UTF-8") + "=" + URLEncoder.encode(productId, "UTF-8");

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


    public boolean updateProductDetail(String id,String name, String quantity, String code, String sku, String parchasePrice, String salePrice, String description) {
   
        boolean status = false;
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/grid/update_grid.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("p_name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            param += "&" + URLEncoder.encode("p_id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
            //param += "&" + URLEncoder.encode("model", "UTF-8") + "=" + URLEncoder.encode(model, "UTF-8");
            param += "&" + URLEncoder.encode("p_qty", "UTF-8") + "=" + URLEncoder.encode(quantity, "UTF-8");
            param += "&" + URLEncoder.encode("p_code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8");
            param += "&" + URLEncoder.encode("p_sku", "UTF-8") + "=" + URLEncoder.encode(sku, "UTF-8");
            param += "&" + URLEncoder.encode("purchase_price", "UTF-8") + "=" + URLEncoder.encode(parchasePrice, "UTF-8");
            param += "&" + URLEncoder.encode("sale_price", "UTF-8") + "=" + URLEncoder.encode(salePrice, "UTF-8");
            param += "&" + URLEncoder.encode("p_desc", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8");
      
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

    public List<Product> getProImageDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Product> getProImageDetail(String proId) {
    
        List<Product> vectorProImageDetail = new ArrayList<Product>();
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/grid/return_image.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("p_id", "UTF-8") + "=" + URLEncoder.encode(proId, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = reader.readLine();
            JSONArray array = new JSONArray(data);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Product product = new Product();

                product.setpImageId(obj.getString("id"));
                product.setpImageName(obj.getString("name"));

                vectorProImageDetail.add(product);
            }
        } catch (Exception ex) {

        }

        return vectorProImageDetail;
    }

    public boolean deleteProImage(String pImageId) {
    
        boolean status = false;
        try {
            URL url = new URL("http://www.stores.wiki/app_panel/grid/delete_img.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("img_id", "UTF-8") + "=" + URLEncoder.encode(pImageId, "UTF-8");

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

    public boolean addSeo(String id, String title, String tag, String paragraph, String keyWord, String metaDesc) {
    
         boolean status = false;
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/grid/update_seo.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("p_id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
            param += "&" + URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
            param += "&" + URLEncoder.encode("tag", "UTF-8") + "=" + URLEncoder.encode(tag, "UTF-8");
            param += "&" + URLEncoder.encode("para", "UTF-8") + "=" + URLEncoder.encode(paragraph, "UTF-8");
            param += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(keyWord, "UTF-8");
            param += "&" + URLEncoder.encode("desc", "UTF-8") + "=" + URLEncoder.encode(metaDesc, "UTF-8");

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

//    public List<Ward> getProductAttributes(String proId) {
//        
//        Vector<Ward> vectorProductAttributes = new Vector<Ward>();
//
//        try {
//
//        } catch (Exception ex) {
//
//        }
//
//        return vectorProductAttributes;
//    
//    }

    public boolean deleteProductAttribute(String attributeId) {
    
        boolean status = false;
        try {
            URL url = new URL("http://www.stores.wiki/app_panel/grid/delete_att.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(attributeId, "UTF-8");

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

    public String getProId(String proName) {
    
        String proId = "";
       
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/return_pid.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(proName, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(param);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("the reader is "+reader);
            String data = reader.readLine();
        
                proId = data;
                System.out.println("the proId is "+proId);
          
        } catch (Exception ex) {

        }

        return proId;
    }

    public boolean addProAttributeValues(String attId, String proId, String attValId) {
        boolean status = false;
        try {

            URL url = new URL("http://www.stores.wiki/app_panel/grid/insert_box.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            String param = URLEncoder.encode("p_id", "UTF-8") + "=" + URLEncoder.encode(proId, "UTF-8");
            param += "&" + URLEncoder.encode("att_id", "UTF-8") + "=" + URLEncoder.encode(attId, "UTF-8");
            param += "&" + URLEncoder.encode("att_text_field_id", "UTF-8") + "=" + URLEncoder.encode(attValId, "UTF-8");
            param += "&" + URLEncoder.encode("reg_bus_id", "UTF-8") + "=" + URLEncoder.encode(bussId, "UTF-8");

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
