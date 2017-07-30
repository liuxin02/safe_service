package com.jason.safe_service.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 测试bean类
 * @author Administrator
 *
 */
public class Task{
	
	private String title;
	private Integer price;
	private Date endDate;
	private Set<String> nameSet;
	private LinkedHashSet<String> channelNames;
	private LinkedList<String> linkedList;
	private Map<Date, Long> mapTest;
	private TreeMap<String, Integer> keyToDate;
	private Boolean isOnGoing;
	private String contactWechat;
	private String timeString;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Set<String> getNameSet() {
		return nameSet;
	}
	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}
	public Boolean getIsOnGoing() {
		return isOnGoing;
	}
	public void setIsOnGoing(Boolean isOnGoing) {
		this.isOnGoing = isOnGoing;
	}
	public String getContactWechat() {
		return contactWechat;
	}
	public void setContactWechat(String contactWechat) {
		this.contactWechat = contactWechat;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public Map<String, Integer> getKeyToDate() {
		return keyToDate;
	}
	public LinkedHashSet<String> getChannelNames() {
		return channelNames;
	}
	public void setChannelNames(LinkedHashSet<String> channelNames) {
		this.channelNames = channelNames;
	}
	public void setKeyToDate(TreeMap<String, Integer> keyToDate) {
		this.keyToDate = keyToDate;
	}
	public Map<Date, Long> getMapTest() {
		return mapTest;
	}
	public void setMapTest(Map<Date, Long> mapTest) {
		this.mapTest = mapTest;
	}
	public LinkedList<String> getLinkedList() {
		return linkedList;
	}
	public void setLinkedList(LinkedList<String> linkedList) {
		this.linkedList = linkedList;
	}
	@Override
	public String toString() {
		return "Task [title=" + title + ", price=" + price + ", endDate=" + endDate + ", nameSet=" + nameSet
				+ ", channelNames=" + channelNames + ", linkedList=" + linkedList + ", mapTest=" + mapTest
				+ ", keyToDate=" + keyToDate + ", isOnGoing=" + isOnGoing + ", contactWechat=" + contactWechat
				+ ", timeString=" + timeString + "]";
	}
	
	
}
