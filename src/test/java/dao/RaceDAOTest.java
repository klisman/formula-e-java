package dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import model.Circuit;
import model.Race;

public class RaceDAOTest {

	@Test
	@Ignore
	public void saveTest() {
		CircuitDAO circuitDAO = new CircuitDAO();
		Circuit circuit = circuitDAO.findById(1L);

		Race race = new Race();
		race.setName("Brazil GP");
		race.setDate(new Date(2016, 12, 2));
		race.setCircuit(circuit);

		RaceDAO raceDAO = new RaceDAO();
		raceDAO.save(race);
	}

	@Test
	@Ignore
	public void listTest() {
		RaceDAO raceDAO = new RaceDAO();
		List<Race> resultList = raceDAO.list();

		for (Race race : resultList) {
			System.out.println("Race: " + race.getName() + ", Circuit: " + race.getCircuit().getName() + " Date: "
					+ race.getDate());
		}
	}

	@Test
	@Ignore
	public void findById() {
		RaceDAO raceDAO = new RaceDAO();
		Race race = raceDAO.findById(1L);
		if (race != null) {
			System.out.println("Race: " + race.getName() + ", Circuit: " + race.getCircuit().getName() + " Date: "
					+ race.getDate());
		} else {
			System.out.println("No register found!");
		}
	}

	@Test
	@Ignore
	public void remove() {
		RaceDAO raceDAO = new RaceDAO();
		Race race = raceDAO.findById(3L);
		if (race != null) {
			raceDAO.remove(race);
			System.out.println(race.getName() + " removed!");
		} else {
			System.out.println("No register found!");
		}
	}

	@Test
	public void update() {
		RaceDAO raceDAO = new RaceDAO();
		Race race = raceDAO.findById(4L);
		CircuitDAO circuitDAO = new CircuitDAO();
		System.out.println(race.getName());
		race.setName("Brasil GP");
		raceDAO.update(race);
		System.out.println(race.getName());
	}
}
