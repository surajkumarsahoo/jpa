package com.mindtree.showmanagement.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelGroupDto {

	private int channelGroupId;
	private String channelGroupName;
	
	@JsonIgnoreProperties("channelGroup")
	private Set<ChannelDto> channels;

	public ChannelGroupDto() {
		super();
	}

	public int getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(int channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	public String getChannelGroupName() {
		return channelGroupName;
	}

	public void setChannelGroupName(String channelGroupName) {
		this.channelGroupName = channelGroupName;
	}

	public Set<ChannelDto> getChannels() {
		return channels;
	}

	public void setChannels(Set<ChannelDto> channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "ChannelGroupDto [channelGroupId=" + channelGroupId + ", channelGroupName=" + channelGroupName
				+ ", channels=" + channels + "]";
	}
	
	
	
}
