package com.mindtree.showmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.showmanagement.dto.ChannelDto;
import com.mindtree.showmanagement.dto.ChannelGroupDto;
import com.mindtree.showmanagement.dto.ChannelShowDto;
import com.mindtree.showmanagement.exceptions.controllerexception.ShowManagementControllerException;
import com.mindtree.showmanagement.exceptions.serviceexception.ShowManagementServiceException;
import com.mindtree.showmanagement.service.ShowManagementService;

@RestController
public class ShowManagementController {

	@Autowired
	ShowManagementService service;

	/**
	 * @param channelGroup
	 * @return "Channel Group Added successfully" when channel group is added
	 */
	@PostMapping("/channelgroup")
	public String insertChannelGroup(@RequestBody ChannelGroupDto channelGroup) {

		String response = service.insertChannelGroupToDn(channelGroup);
		return response;

	}

	/**
	 * @param channel
	 * @param channelGroupName
	 * @return "Channel Group Added successfully" when channel group is added
	 * @throws ShowManagementControllerException when Channel Group is not found
	 */
	@PostMapping("/channel/{channelGroupName}")
	public String insertChannel(@RequestBody ChannelDto channel, @PathVariable String channelGroupName)
			throws ShowManagementControllerException {

		String response;
		try {
			response = service.insertChannelToDB(channel, channelGroupName);
		} catch (ShowManagementServiceException e) {
			throw new ShowManagementControllerException(e.getMessage(), e);
		}
		return response;
	}

	/**
	 * @param show
	 * @param channelName
	 * @return "Show added successfully" response when show is added
	 * @throws ShowManagementControllerException when Channel is not found
	 */
	@PostMapping("/show/{channelName}")
	public String insertShow(@RequestBody ChannelShowDto show, @PathVariable String channelName)
			throws ShowManagementControllerException {

		String response;
		try {
			response = service.insertShowToDB(show, channelName);
		} catch (ShowManagementServiceException e) {
			throw new ShowManagementControllerException(e.getMessage(), e);
		}
		return response;
	}

	/**
	 * @param channelGroupId
	 * @return all channels based on a given channel group ID
	 * @throws ShowManagementControllerException when channel group is not found
	 */
	@GetMapping("/channels/{channelGroupId}")
	public List<ChannelDto> getChannelBasedOnGroupId(@PathVariable int channelGroupId)
			throws ShowManagementControllerException {

		List<ChannelDto> channels = new ArrayList<ChannelDto>();
		try {
			channels = service.getChannelsBasedOnGroupIdDB(channelGroupId);
		} catch (ShowManagementServiceException e) {
			throw new ShowManagementControllerException(e.getMessage(), e);
		}
		return channels;
	}

}
