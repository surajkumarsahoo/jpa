package com.mindtree.showmanagement.service.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.showmanagement.dto.ChannelDto;
import com.mindtree.showmanagement.dto.ChannelGroupDto;
import com.mindtree.showmanagement.dto.ChannelShowDto;
import com.mindtree.showmanagement.entity.Channel;
import com.mindtree.showmanagement.entity.ChannelGroup;
import com.mindtree.showmanagement.entity.ChannelShow;
import com.mindtree.showmanagement.exceptions.errorconst.ErrorConst;
import com.mindtree.showmanagement.exceptions.serviceexception.NoSuchChannelException;
import com.mindtree.showmanagement.exceptions.serviceexception.NoSuchChannelGroupFound;
import com.mindtree.showmanagement.exceptions.serviceexception.ShowManagementServiceException;
import com.mindtree.showmanagement.repository.ChannelGroupRepository;
import com.mindtree.showmanagement.repository.ChannelRepository;
import com.mindtree.showmanagement.repository.ChannelShowRepository;
import com.mindtree.showmanagement.service.ShowManagementService;

@Service
public class ShowManagementServiceImpl implements ShowManagementService {

	@Autowired
	ChannelGroupRepository channelGroupRepository;

	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	ChannelShowRepository showRepository;

	ModelMapper modelMapper = new ModelMapper();

	public ChannelGroup convertChannelGroupDtoToEntity(ChannelGroupDto channelGroupDto) {
		return modelMapper.map(channelGroupDto, ChannelGroup.class);
	}

	public Channel convertChannelDtoToEntity(ChannelDto channelDto) {
		return modelMapper.map(channelDto, Channel.class);
	}

	public ChannelDto convertChannelEntityToDto(Channel channel) {
		return modelMapper.map(channel, ChannelDto.class);
	}

	public ChannelShow convertChannelShowDtoToEntity(ChannelShowDto showDto) {
		return modelMapper.map(showDto, ChannelShow.class);
	}

	@Override
	public String insertChannelGroupToDn(ChannelGroupDto channelGroupDto) {

		ChannelGroup channelGroup = convertChannelGroupDtoToEntity(channelGroupDto);

		channelGroupRepository.save(channelGroup);

		return "Channel Group Added Successfully";
	}

	@Override
	public String insertChannelToDB(ChannelDto channel, String channelGroupName) throws ShowManagementServiceException {

		Optional<ChannelGroup> channelGroup = channelGroupRepository.findBychannelGroupName(channelGroupName);

		try {
			channelGroup.orElseThrow(() -> new NoSuchChannelGroupFound(ErrorConst.NoSuchChannelGroupFound));
		} catch (NoSuchChannelGroupFound e) {

			throw new ShowManagementServiceException(e.getMessage(), e);
		}

		Channel channelEntity = convertChannelDtoToEntity(channel);

		channelEntity.setChannelGroup(channelGroup.get());

		channelRepository.save(channelEntity);

		return "Channel Added Successfully";

	}

	@Override
	public String insertShowToDB(ChannelShowDto showDto, String channelName) throws ShowManagementServiceException {

		Optional<Channel> channel = channelRepository.findBychannelName(channelName);

		try {
			channel.orElseThrow(() -> new NoSuchChannelException(ErrorConst.NoSuchChannelFound));
		} catch (NoSuchChannelException e) {
			throw new ShowManagementServiceException(e.getMessage(), e);
		}

		ChannelShow show = convertChannelShowDtoToEntity(showDto);
		show.setChannel(channel.get());

		showRepository.save(show);

		return "Show Added Successfully";
	}

	@Override
	public List<ChannelDto> getChannelsBasedOnGroupIdDB(int channelGroupId) throws ShowManagementServiceException {

		
		Optional<ChannelGroup> channelGroup = channelGroupRepository.findById(channelGroupId);

		try {
			channelGroup.orElseThrow(() -> new NoSuchChannelGroupFound(ErrorConst.NoSuchChannelGroupFound));
		} catch (NoSuchChannelGroupFound e) {

			throw new ShowManagementServiceException(e.getMessage(), e);
		}
		
		ChannelGroup channelGroupEntity = channelGroup.get();
		
		List<Channel> channels = channelGroupEntity.getChannels().stream().collect(Collectors.toList());
		
		Collections.sort(channels);
		
		List<ChannelDto> channelsDto = channels.stream().map(i -> convertChannelEntityToDto(i))
				.collect(Collectors.toList());

		return channelsDto;

	}
}
