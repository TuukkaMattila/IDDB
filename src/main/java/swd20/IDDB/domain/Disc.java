package swd20.IDDB.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Disc {
	//Attributes
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Database server generates unique value
	private long modelId;
	
	

	@NotNull
	@Size(min = 2, max = 15)
	private String model;
	
	@NotNull
	@Max(value = 14)
	private int speed;
	
	@NotNull
	private int glide;
	
	@NotNull
	private int turn;
	
	@NotNull
	private int fade;
	
	@ManyToOne
	//Vältytään loputtomalta loopilta käyttämällä @JsonIgnoreProperties
	@JsonIgnoreProperties("discs")
	@JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;
	
	//Constructors

	public Disc(String model, int speed, int glide, int turn, int fade, Manufacturer manufacturer) {
		super();
		this.model = model;
		this.speed = speed;
		this.glide = glide;
		this.turn = turn;
		this.fade = fade;
		this.manufacturer = manufacturer;
	}

	public Disc() {
		super();
	}
	
	

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getGlide() {
		return glide;
	}

	public void setGlide(int glide) {
		this.glide = glide;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getFade() {
		return fade;
	}

	public void setFade(int fade) {
		this.fade = fade;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
	
	
	
	
	

}
