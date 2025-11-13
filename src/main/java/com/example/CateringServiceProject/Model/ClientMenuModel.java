package com.example.CateringServiceProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientMenuModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishNo;
    private String clientName;
    private String dishName;
    private String clientPhoneNo;
    private String clientAddress;

   private  LocalDate orderDate =LocalDate.now();

    public ClientMenuModel(String clientName, String dishName, String clientPhoneNo,String clientAddress) {
        this.clientName = clientName;
        this.dishName = dishName;
        this.clientPhoneNo = clientPhoneNo;
        this.clientAddress = clientAddress;
        this.orderDate =LocalDate.now();

    }

}
