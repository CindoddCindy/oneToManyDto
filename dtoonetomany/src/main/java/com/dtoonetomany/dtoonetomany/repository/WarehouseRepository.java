package com.dtoonetomany.dtoonetomany.repository;

import com.dtoonetomany.dtoonetomany.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
