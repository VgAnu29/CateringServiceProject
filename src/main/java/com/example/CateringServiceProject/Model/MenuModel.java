package com.example.CateringServiceProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuModel
{
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int dishId;
    private String dishName ;

}
