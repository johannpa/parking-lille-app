package com.project.parking.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.project.parking.dao.ParkingAPIDAO;
import com.project.parking.dao.entity.ReponseParkingAPIEntity;

@Repository
public class ParkingAPIDAOImpl implements ParkingAPIDAO {

	private static final String URL_API_OPEN_DATA = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=disponibilite-parkings&q=&facet=libelle&facet=ville&facet=etat";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ReponseParkingAPIEntity getListeParking() {
		return restTemplate.getForEntity(URL_API_OPEN_DATA, ReponseParkingAPIEntity.class).getBody();
	}

}
