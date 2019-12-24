package com.mindtree.showmanagement.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelDto {

	private int channelId;
	private String channelName;
	private double price;
	
	@JsonIgnoreProperties("channels")
	private ChannelGroupDto channelGroup;
	
	@JsonIgnoreProperties("channel")
	private Set<ChannelShowDto> shows ;

	public ChannelDto() {
		super();
	}

	public ChannelDto(int channelId, String channelName, double price, ChannelGroupDto channelGroup,
			Set<ChannelShowDto> shows) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
		this.channelGroup = channelGroup;
		this.shows = shows;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@JsonBackReference
	public ChannelGroupDto getChannelGroup() {
		return channelGroup;
	}

	public void setChannelGroup(ChannelGroupDto channelGroup) {
		this.channelGroup = channelGroup;
	}

	@JsonBackReference
	public Set<ChannelShowDto> getShows() {
		return shows;
	}

	public void setShows(Set<ChannelShowDto> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "ChannelDto [channelId=" + channelId + ", channelName=" + channelName + ", price=" + price
				+ ", channelGroup=" + channelGroup + ", shows=" + shows + "]";
	}

	
	
	
}
