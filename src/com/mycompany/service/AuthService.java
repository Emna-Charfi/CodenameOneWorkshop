/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.*;
import com.mycompany.entity.User;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Ghssissine
 */
public class AuthService implements IAuthService<User> {

    @Override
    public User login(User user) {

        // Define the URL 
        String url = "http://127.0.0.1:9090/user/signin";
        // Define the request body in JSON format
        String requestBody = "{\"username\": \"" + user.getEmail() + "\", \"password\": \"" + user.getPassword() + "\"}";

        ConnectionRequest request = new ConnectionRequest() {
            protected void readResponse(InputStream input) throws IOException {
            }
        };

        request.setUrl(url);

        request.setPost(true);

        request.setHttpMethod("POST");
        request.setRequestBody(requestBody);
        // Add a request header to indicate that we are sending JSON data

        request.addRequestHeader("Content-Type", "application/json");
        request.addRequestHeader("Accept", "application/json");
// Add the request to the network
        NetworkManager.getInstance().addToQueueAndWait(request);

        return user;
    }

    @Override
    public int signup(User u) {

        // Define the URL 
        String url = "http://127.0.0.1:9090/user/signup";
        // Define the request body in JSON format
        String requestBody = "{\"username\": \"" + u.getUsername() + "\", \"email\": \"" + u.getEmail() + "\",\"password\": \"" + u.getPassword() + "\",\"birth\": \"" + u.getBirth() + "\",\"address\": \"" + u.getAddress() + "\"}";
        ConnectionRequest request = new ConnectionRequest() {
            protected void readResponse(InputStream input) throws IOException {
            }
        };
        System.out.println(requestBody);
        request.setUrl(url);

        request.setPost(true);

        request.setHttpMethod("POST");
        request.setRequestBody(requestBody);
        // Add a request header to indicate that we are sending JSON data

        request.addRequestHeader("Content-Type", "application/json");
        request.addRequestHeader("Accept", "application/json");
// Add the request to the network
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request.getResponseCode();
    }

    @Override
    public void updatePass(User user) {
// Define the URL 
        String url = "http://127.0.0.1:9090/user/pwd/" + user.getUsername();
        // Define the request body in JSON format
        ConnectionRequest request = new ConnectionRequest() {
            protected void readResponse(InputStream input) throws IOException {
            }
        };
        request.setUrl(url);

        request.setPost(true);

        request.setHttpMethod("PATCH");
        // Add a request header to indicate that we are sending JSON data

// Add the request to the network
        NetworkManager.getInstance().addToQueueAndWait(request);
    }

    @Override
    public int updateProfile(User u) {

        // Define the URL 
        String url = "http://127.0.0.1:9090/user/signup";
        // Define the request body in JSON format
        String requestBody = "{\"username\": \"" + u.getUsername() + "\", \"email\": \"" + u.getEmail() + "\",\"password\": \"" + u.getPassword() + "\",\"birth\": \"" + u.getBirth() + "\",\"address\": \"" + u.getAddress() + "\"}";
        ConnectionRequest request = new ConnectionRequest() {
            protected void readResponse(InputStream input) throws IOException {
            }
        };
        System.out.println(requestBody);
        request.setUrl(url);

        request.setPost(true);

        request.setHttpMethod("PATCH");
        request.setRequestBody(requestBody);
        // Add a request header to indicate that we are sending JSON data

        request.addRequestHeader("Content-Type", "application/json");
        request.addRequestHeader("Accept", "application/json");
// Add the request to the network
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request.getResponseCode();
    }

}
