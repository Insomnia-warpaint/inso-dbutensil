package com.dbuntensil.bean;

import java.util.Objects;

public class DboConfig {
	
	private Integer id;
	private String watermeter;
	private String station;
	private String flow_front;
	private String flow_reverse;
	private String flow_moment;
	private String electricity;
	private String voltage;
	private String station_tag;
	private String comment_;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWatermeter() {
		return watermeter;
	}
	public void setWatermeter(String watermeter) {
		this.watermeter = watermeter;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getFlow_front() {
		return flow_front;
	}
	public void setFlow_front(String flow_front) {
		this.flow_front = flow_front;
	}
	public String getFlow_reverse() {
		return flow_reverse;
	}
	public void setFlow_reverse(String flow_reverse) {
		this.flow_reverse = flow_reverse;
	}
	public String getFlow_moment() {
		return flow_moment;
	}
	public void setFlow_moment(String flow_moment) {
		this.flow_moment = flow_moment;
	}
	public String getElectricity() {
		return electricity;
	}
	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getStation_tag() {
		return station_tag;
	}
	public void setStation_tag(String station_tag) {
		this.station_tag = station_tag;
	}
	public String getComment_() {
		return comment_;
	}
	public void setComment_(String comment_) {
		this.comment_ = comment_;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(comment_, electricity, flow_front, flow_moment, flow_reverse, id, station, station_tag,
				voltage, watermeter);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DboConfig other = (DboConfig) obj;
		return Objects.equals(comment_, other.comment_) && Objects.equals(electricity, other.electricity)
				&& Objects.equals(flow_front, other.flow_front) && Objects.equals(flow_moment, other.flow_moment)
				&& Objects.equals(flow_reverse, other.flow_reverse) && Objects.equals(id, other.id)
				&& Objects.equals(station, other.station) && Objects.equals(station_tag, other.station_tag)
				&& Objects.equals(voltage, other.voltage) && Objects.equals(watermeter, other.watermeter);
	}
	
	@Override
	public String toString() {
		return "DboConfig [id=" + id + ", watermeter=" + watermeter + ", station=" + station + ", flow_front="
				+ flow_front + ", flow_reverse=" + flow_reverse + ", flow_moment=" + flow_moment + ", electricity="
				+ electricity + ", voltage=" + voltage + ", station_tag=" + station_tag + ", comment_=" + comment_
				+ "]";
	}
	
	
	
	
}
