package com.mindtree.showmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.showmanagement.dto.ChannelDto;
import com.mindtree.showmanagement.dto.ChannelGroupDto;
import com.mindtree.showmanagement.dto.ChannelShowDto;
import com.mindtree.showmanagement.exceptions.serviceexception.ShowManagementServiceException;

@Service
public interface ShowManagementService {

	/**
	 * @param channelGroup
	 * @return "Channel Group Added successfully" response when channel group is added 
	 */
	String insertChannelGroupToDn(ChannelGroupDto channelGroup);

	/**
	 * @param channel
	 * @param channelGroupName
	 * @return "Channel Group Added successfully"  response when channel group is added
	 * @throws ShowManagementServiceException when Channel Group is not found
	 */
	String insertChannelToDB(ChannelDto channel, String channelGroupName) throws ShowManagementServiceException;

	/**
	 * @param show
	 * @param channelName
	 * @return "Show added successfully" response when show is added
	 * @throws ShowManagementServiceException when Channel is not found
	 */
	String insertShowToDB(ChannelShowDto show, String channelName) throws ShowManagementServiceException;

	/**
	 * @param channelGroupId
	 * @return All Channels Based on a given channel group ID
	 * @throws ShowManagementServiceException when channel group is not found
	 */
	List<ChannelDto> getChannelsBasedOnGroupIdDB(int channelGroupId) throws ShowManagementServiceException;

	
}
