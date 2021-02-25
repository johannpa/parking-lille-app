package com.project.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.parking.dao.ParkingAPIDAO;
import com.project.parking.dao.entity.RecordEntity;
import com.project.parking.dao.entity.ReponseParkingAPIEntity;
import com.project.parking.models.Parking;
import com.project.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	public ParkingAPIDAO parkingAPIDAO;
	
	@Override
	public List<Parking> getListeParkings() {
		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParking();
//		En dessous c'était le bouchon avant d'avoir le DAO
//		Parking parkingTest = new Parking();
//		parkingTest.setNom("Parking de test");
//		parkingTest.setNbPlacesTotal(300);
//		parkingTest.setNbPlacesDispo(125);
//		parkingTest.setStatut("FERME");
//		parkingTest.setHeureMaj("20h15");
//		ArrayList<Parking> liste = new ArrayList<Parking>();
//		liste.add(parkingTest);
		return transformEntityToModel(reponse);
	}

	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		for (RecordEntity record : reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getNomParking());
			parking.setStatut(record.getFields().getEtatParking());
			parking.setNbPlacesDispo(record.getFields().getDispoPlace());
			parking.setNbPlacesTotal(record.getFields().getMaxPlace());
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		
		return resultat;
	}

	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getDateMaj());
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+01:00"));
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
	}

}
