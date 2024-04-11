package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerDetails;
@Repository
public interface Model extends JpaRepository<CustomerDetails, Integer> {

}
