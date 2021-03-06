package com.mindtree.showmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.showmanagement.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

	Optional<Channel> findBychannelName(String channelName);
}
