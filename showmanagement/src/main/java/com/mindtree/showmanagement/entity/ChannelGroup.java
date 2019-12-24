package com.mindtree.showmanagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChannelGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelGroupId;
	private String channelGroupName;

	@OneToMany(mappedBy = "channelGroup", cascade = CascadeType.PERSIST)
	private Set<Channel> channels;

	public ChannelGroup() {
		super();
	}

	public ChannelGroup(int channelId, String channelName, Set<Channel> channels) {
		super();
		this.channelGroupId = channelId;
		this.channelGroupName = channelName;
		this.channels = channels;
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

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "ChannelGroup [channelGroupId=" + channelGroupId + ", channelGroupName=" + channelGroupName
				+ ", channels=" + channels + "]";
	}

}
