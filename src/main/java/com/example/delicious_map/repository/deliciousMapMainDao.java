package com.example.delicious_map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.delicious_map.entity.DeliciousMapMain;

@Repository
public interface DeliciousMapMainDao extends JpaRepository<DeliciousMapMain, String>{

}
