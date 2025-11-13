package com.example.CateringServiceProject.Repository;

import com.example.CateringServiceProject.Model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuModelRepository extends JpaRepository<MenuModel,Integer>
{
}
