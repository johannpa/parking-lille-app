package com.project.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldsEntity {

	@JsonProperty(value = "id")
	private String idObj;
	
	@JsonProperty(value = "libelle")
	private String nomParking; //grpNom
	
	@JsonProperty(value = "max")
	private int maxPlace; // grpExploitation
	
	@JsonProperty(value = "dispo")
	private int dispoPlace; // grpDisponible
	
	@JsonProperty(value = "etat")
	private String etatParking; // grpStatut
	
	@JsonProperty(value = "datemaj")
	private String dateMaj; // grpHorodatage
	
	@JsonProperty(value = "id")
	public String getIdObj() {
		return idObj;
	}

	public void setIdObj(String idObj) {
		this.idObj = idObj;
	}

	public String getNomParking() {
		return nomParking;
	}

	public void setNomParking(String nomParking) {
		this.nomParking = nomParking;
	}

	public int getMaxPlace() {
		return maxPlace;
	}

	public void setMaxPlace(int maxPlace) {
		this.maxPlace = maxPlace;
	}

	public int getDispoPlace() {
		return dispoPlace;
	}

	public void setDispoPlace(int dispoPlace) {
		this.dispoPlace = dispoPlace;
	}

	public String getEtatParking() {
		return etatParking;
	}

	public void setEtatParking(String etatParking) {
		this.etatParking = etatParking;
	}

	public String getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(String dateMaj) {
		this.dateMaj = dateMaj;
	}
	
	
	
}
