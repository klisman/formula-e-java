package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Circuit extends BaseEntity{
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String location;
	@Column(nullable=false, precision=7, scale=2)
	private Double length;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	
}
