/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit252_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;



public class Shipment implements Shipment_interface{
    
private String tracking_number;
private String id;
private String carrier_code;
private String status;
private String lastUpdateTime;
private String ItemReceived;
private String created_at;
private String weblink;
private String updated_at;
private ArrayList<Shipment_interface> shipment_status; 







 public static StringTokenizer pars(String body) {
        body = "[" + body + "]";
        JSONArray d = new JSONArray(body);

        JSONObject a = d.getJSONObject(0);

        String s = a.toMap().get("data").toString();

        StringTokenizer t = new StringTokenizer(s, ",{}");
        return t;

    }

    private  void create_shipment(StringTokenizer t) {

      shipment_status = new ArrayList<>();

       

        while (t.hasMoreTokens()) {

            String l = t.nextToken();

            if (l.startsWith(" tracking_number")) {
                this.tracking_number = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" id")) {
                this.id = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" carrier_code")) {
                this.carrier_code = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" status")) {
                this.status = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" lastUpdateTime")) {
                this.lastUpdateTime = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" ItemReceived")) {
                this.ItemReceived = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" created_at")) {
                this.created_at = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" weblink")) {
                this.weblink = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" updated_at")) {
                this.updated_at = (l.substring(l.indexOf("=")).replace("=", ""));
            }

            if (l.startsWith("checkpoint_status")) {
                l = t.nextToken();
                if (l.startsWith(" ItemNode")) {
                    l = t.nextToken();
                }
                if (l.startsWith(" Details")) {
                    String Location, Current_status_code, Current_status, Time;

                    Location = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Current_status_code = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Current_status = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Time = l.substring(l.indexOf("=")).replace("=", "");
                    
                    Shipment_interface s=new Shipment_status(Location, Current_status_code, Current_status, Time);
                    shipment_status.add(s);
                }

            }

        }

       
        

    }



public void insertShipment(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            
            
           
            
            PreparedStatement insertStmt =
            dbConnection.prepareStatement("INSERT INTO new_table (tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            insertStmt.setString(1, this.tracking_number);
            insertStmt.setString(2, (this.id));
            insertStmt.setString(3, (this.carrier_code));
            insertStmt.setString(4, (this.status));
            insertStmt.setString(5, (this.lastUpdateTime));
            insertStmt.setString(6, (this.ItemReceived));
            insertStmt.setString(7, (this.created_at));
            insertStmt.setString(8, (this.weblink));
            insertStmt.setString(9, (this.updated_at));
            
            int rows = insertStmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveShipment(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
           
            String query = "SELECT tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at FROM new_table";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
               
                String row = "tracking_number: " + rs.getString("tracking_number") +
                "id: " + rs.getString("id") +
                "carrier_code: " + rs.getString("carrier_code") +
                "status: " + rs.getString("status") +
                "lastUpdateTime: " + rs.getString("lastUpdateTime") +
                "ItemReceived: " + rs.getString("ItemReceived") +
                "created_at: " + rs.getString("created_at") +
                "weblink: " + rs.getString("weblink") +
                "updated_at: " + rs.getString("updated_at");
                             
                System.out.print(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    
   

  







  


public Shipment(String body) {
      
    
    create_shipment(pars(body));
    
    
    }











    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier_code() {
        return carrier_code;
    }

    public void setCarrier_code(String carrier_code) {
        this.carrier_code = carrier_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getItemReceived() {
        return ItemReceived;
    }

    public void setItemReceived(String ItemReceived) {
        this.ItemReceived = ItemReceived;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public void Print() {
        
        System.out.println("Shipment{" + "tracking_number=" +
                tracking_number + ", id=" +
                id + ", carrier_code=" +
                carrier_code + ", status=" +
                status + ", lastUpdateTime=" +
                lastUpdateTime + ", ItemReceived=" +
                ItemReceived + ", created_at=" +
                created_at + ", weblink=" + weblink +
                ", updated_at=" + updated_at);
        
        for (Shipment_interface shipment_statu : shipment_status) {
            shipment_statu.Print();
        }
        
    }

    
}
