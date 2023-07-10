package com.sagachoreographyps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagachoreographyps.entity.UserBalance;


public interface UserBalanceDao extends JpaRepository<UserBalance, Integer>{

}
