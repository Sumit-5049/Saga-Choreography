package com.sagachoreographyps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagachoreographyps.entity.UserTranscation;


public interface UserTranscationDao extends JpaRepository<UserTranscation, Integer>{

}
