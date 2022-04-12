/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.cpit252_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class CPIT252_PROJECT {

    public static void main(String[] args) {
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tracktry.com/v1/trackings/zajil/Z8000543"))
                    .header("Content-Type", "application/json")
                    .header("Tracktry-Api-Key", "7802c747-567c-42aa-b5aa-fc311647fd31")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).
                    thenApply(HttpResponse::body).join();

            Shipment_interface s = new Shipment(response.body());
            s.Print();

           // DBConnection db = DBConnection.getInstance();
            

           
            
//            s.insertShipment();
//            
//            s.retrieveShipment();
//        } catch (SQLException e) {
//            e.printStackTrace();
        } catch (IOException | InterruptedException ex) {
//            Logger.getLogger(CPIT252_PROJECT.class.getName()).log(Level.SEVERE, null, ex);
       }
//            Logger.getLogger(CPIT252_PROJECT.class.getName()).log(Level.SEVERE, null, ex);
//        }


   

    }
}
