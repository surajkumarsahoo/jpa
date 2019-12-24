package com.mindtree.showmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.showmanagement.entity.ChannelShow;

@Repository
public interface ChannelShowRepository extends JpaRepository<ChannelShow,Integer> {

}
