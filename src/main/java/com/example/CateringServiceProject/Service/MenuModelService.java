package com.example.CateringServiceProject.Service;

import com.example.CateringServiceProject.Model.ClientMenuModel;
import com.example.CateringServiceProject.Model.MenuModel;
import com.example.CateringServiceProject.Repository.ClientMenuModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CateringServiceProject.Repository.MenuModelRepository ;

import java.time.LocalDate;
import java.util.List;

@Service
public class MenuModelService
{
    @Autowired
    public MenuModelRepository menmdlRepo;

    @Autowired
    public ClientMenuModelRepository clientMenuRepo;

    public List<MenuModel> getMenuList()
    {
      return  menmdlRepo.findAll();
    }

    public void addMenuModel(MenuModel menumd)
    {
        menmdlRepo.save(menumd);
    }


    public void addClientMenuModelList(String clientName,String dishName,String clientPhoneNo,String clientAddress)
    {
        LocalDate date =LocalDate.now();
        System.out.println("printing the date value :: " +LocalDate.now());
        boolean existingorder =clientMenuRepo.
                findByClientPhoneNoAndDishNameAndOrderDate(clientPhoneNo,dishName,date)
                .isPresent();
        if(existingorder)
        {
            throw new RuntimeException("Hi " + clientName + "You have already placed an oder " + dishName + "today");
        }
        else
        {
            ClientMenuModel clntMenModl = new ClientMenuModel(clientName, dishName, clientPhoneNo, clientAddress);
            clientMenuRepo.save(clntMenModl);
        }
    }


    public void deleteClientOrder(int dishNo)
    {
        if(clientMenuRepo.existsById((dishNo))) {
            clientMenuRepo.deleteById(dishNo);
        }
        else {
            throw new RuntimeException("order with the client no " +dishNo + " is not found");
        }
    }
}
