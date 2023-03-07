package com.thirukkural;

import com.thirukkural.repository.Database;

import java.util.List;

import com.thirukkural.dto.Properties;

public class ThirukkuralModel {

	private ThirukkuralView view;
	private Database db = new Database();

	ThirukkuralModel(ThirukkuralView view) {
		this.view = view;
	}
	
	public void displayArathupaal() {
		List<Properties> arathupaalList = db.displayArathupaal();
		view.arathupaalList(arathupaalList);
	}

	public void displayPorutpaal() {
		List<Properties> porutpaalList = db.displayPorutpaal();
	view.arathupaalList(porutpaalList);
	}

	public void displayInbathupaal() {
		List<Properties> inbathupaalList = db.displayInbathupaal();
		view.arathupaalList(inbathupaalList);
	}

	public void getSpecificKural(String number) {
		Properties property = db.getSpecificKural(number);
		view.printKural(property);
	}

	public void getSpecificAthikaram(String number) {
		List<Properties> athikaram;
		if (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 38)
			athikaram = db.getSpecificAthikaramArathupaal(number);
		else if (Integer.parseInt(number) >= 39 && Integer.parseInt(number) <= 108)
			athikaram = db.getSpecificAthikaramPorutpaal(number);
		else
			athikaram = db.getSpecificAthikaramInbathupaal(number);
		view.printAthikaram(athikaram);
	}

	public void exit() {
		db.exit();
	}

}