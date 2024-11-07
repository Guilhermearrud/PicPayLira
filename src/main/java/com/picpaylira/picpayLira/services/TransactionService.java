package com.picpaylira.picpayLira.services;

import com.picpaylira.picpayLira.domain.transaction.Transaction;
import com.picpaylira.picpayLira.domain.user.User;
import com.picpaylira.picpayLira.dtos.TransactionDTO;
import com.picpaylira.picpayLira.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    final String url = "https://util.devi.tools/api/v2/authorize";

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate; // Spring Class that allows communication HTTP between services and we can make HTTP calls like GET, POST...

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.checkAuthorization();
        if (!isAuthorized) {
            throw new Exception("Transaction not authorized. Please check with your bank.");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        transactionRepository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

//        this.notificationService.sendNotification(sender, "Transaction realized with success.");
//        this.notificationService.sendNotification(receiver, "Transaction received with success.");

        return newTransaction;
    }

    public boolean checkAuthorization() {
        try {
            // Make the API call
            ResponseEntity<Map<String, Object>> authorizationResponse = restTemplate.getForEntity(url, (Class<Map<String, Object>>) (Class<?>) Map.class);

            // Log the response body
            System.out.println("Authorization Response: " + authorizationResponse.getBody());

            // Return the response body
            return true;
        } catch (HttpClientErrorException e) {
            // Log the HTTP error response
            System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return false;
        }
    }


//    public Boolean authorizeTransaction() {
//        // Call the checkAuthorization method to get the response
//        Boolean authorizationResponse = checkAuthorization();
//
//        // Log the full response (you can access specific parts of the response as well)
//        System.out.println("Authorization Response: " + authorizationResponse);
//
//        // Extract the "data" field and check the authorization status
//        Map<String, Object> data = (Map<String, Object>) authorizationResponse.get("data");
//        Boolean authorization = (Boolean) data.get("authorization");
//
//        // Log the authorization value
//        System.out.println("Authorization status: " + authorization);
//
//        if (!authorization) {
//            // Log the failure reason
//            System.out.println("Transaction not authorized. Please check with your bank.");
//            return false;
//        }
//
//        return true;
//    }

}
