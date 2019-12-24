package com.mindtree.showmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.showmanagement.entity.Channel;

public class ChannelShowDto {

	private int showId;
	private String showName;
	
	@JsonIgnoreProperties("shows")
	private Channel channel;

	public ChannelShowDto() {
		super();
	}

	public ChannelShowDto(int showId, String showName, Channel channel) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channel = channel;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "ChannelShowDto [showId=" + showId + ", showName=" + showName + ", channel=" + channel + "]";
	}
	
	

}
