package com.example.CateringServiceProject.Controller;

import com.example.CateringServiceProject.Model.MenuModel;
import com.example.CateringServiceProject.Service.MenuModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuModelController
{
    @Autowired
    public MenuModelService menuSer ;

    @GetMapping("/MenuModel")
    public List<MenuModel> getMenuList()

    {
        return menuSer.getMenuList();
    }

    //@RequestBody is used to convert JSON to JAVA object ...
    @PostMapping("menu/added")
    public String addMenuModel(@RequestBody MenuModel menumd)
    {
        menuSer.addMenuModel(menumd);
        return "Added the Menu list....";
    }

    //@Requestparam is used to pass the pair value to the method parameter.
    @PostMapping("client/order")
    public String addClientMenuModelList(@RequestParam("clientName") String clientName,
                                         @RequestParam("dishName") String dishName,
                                         @RequestParam("clientPhoneNo") String clientPhoneNo,
                                         @RequestParam("clientAddress") String clientAddress)
    {
         menuSer.addClientMenuModelList(clientName,dishName,clientPhoneNo,clientAddress);
         return "Hi "+clientName+" , your order has been placed successfully. Our customer team will contact you for further details. Thank you for choosing Shri Raghavendra Catering Service";
    }

    @DeleteMapping("client/order/del/{dishNo}")

    public ResponseEntity<String> deleteClientOrder(@PathVariable("dishNo") int dishNo)
    {
        try {
            menuSer.deleteClientOrder(dishNo);
            return ResponseEntity.ok("The client order has been deleted successfully");
        }
        catch(RuntimeException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

