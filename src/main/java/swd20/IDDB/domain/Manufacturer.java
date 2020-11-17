package swd20.IDDB.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Manufacturer {
	//Attributes
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Database server generates unique value
	private long manufacturerId;
	
	@NotNull
	@Size(min = 3, max = 15)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
	@JsonIgnoreProperties("manufacturers")
	private List<Disc> discs;

	
	//Constructors
	
	
	public Manufacturer(String name, List<Disc> discs) {
		super();
		this.name = name;
		this.discs = discs;
	}


	public Manufacturer(String name) {
		super();
		this.name = name;
	}


	public Manufacturer() {
		super();
	}


	public long getManufacturerId() {
		return manufacturerId;
	}


	public void setManufacturerId(long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Disc> getDiscs() {
		return discs;
	}


	public void setDiscs(List<Disc> discs) {
		this.discs = discs;
	}
	
	
	
	
	
	
	

}
