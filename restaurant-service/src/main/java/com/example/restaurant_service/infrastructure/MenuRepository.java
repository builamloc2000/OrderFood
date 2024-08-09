package com.example.restaurant_service.infrastructure;

import com.example.restaurant_service.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

}
