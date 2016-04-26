package dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import model.Circuit;

public class CircuitDAOTest {

	@Test
	@Ignore
	public void saveTest() {
		Circuit circuit = new Circuit();
		circuit.setName("Autódromo de Interlagos");
		circuit.setLocation("São Paulo");
		circuit.setLength(4309.00);

		CircuitDAO circuitDAO = new CircuitDAO();
		circuitDAO.save(circuit);
	}

	@Test
	@Ignore
	public void listTest() {
		CircuitDAO circuitDAO = new CircuitDAO();
		List<Circuit> resultList = circuitDAO.list();
		System.out.println("Matches: " + resultList.size());
	}

	@Test
	@Ignore
	public void findByIdTest() {
		Long code = 1L;
		CircuitDAO circuitDAO = new CircuitDAO();
		Circuit circuit = circuitDAO.findById(code);
		if (circuit != null) {
			System.out.println(circuit.getName());
		} else {
			System.out.println("No register found!");
		}

	}

	@Test
	@Ignore
	public void remove() {
		Long code = 3L;
		CircuitDAO circuitDAO = new CircuitDAO();
		Circuit circuit = circuitDAO.findById(code);
		if (circuit != null) {
			circuitDAO.remove(circuit);
			System.out.println(circuit.getName() + " successfully removed");
		} else {
			System.out.println("No register found!");
		}
	}

	@Test
	public void update() {
		Long code = 2L;
		CircuitDAO circuitDAO = new CircuitDAO();
		Circuit circuit = circuitDAO.findById(code);
		if (circuit != null) {
			circuit.setName("Bahrain International Circuit");
			circuitDAO.update(circuit);
		}else{
			System.out.println("No register found!");
		}
	}
}
