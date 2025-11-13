package com.example.CateringServiceProject.Repository;

import com.example.CateringServiceProject.Model.ClientMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClientMenuModelRepository extends JpaRepository<ClientMenuModel ,Integer>

{
    Optional<ClientMenuModel> findByClientPhoneNoAndDishNameAndOrderDate(String clientPhoneNo,
                                                                         String dishName,
                                                                         LocalDate orderDate);
}
