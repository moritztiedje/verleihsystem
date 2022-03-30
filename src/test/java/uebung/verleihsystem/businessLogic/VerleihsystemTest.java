package uebung.verleihsystem.businessLogic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static uebung.verleihsystem.businessLogic.Kategorie.BUS;
import static uebung.verleihsystem.businessLogic.Kategorie.KOMBI;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerleihsystemTest {

  Auto kombi = new Auto(KOMBI);
  Auto bus = new Auto(BUS);

  Verleihsystem verleihsystem;

  @BeforeEach
  public void setupVerleihsystem() {
    verleihsystem = new Verleihsystem();
    verleihsystem.addAuto(kombi);
    verleihsystem.addAuto(bus);
  }

  @Test
  void listAllAutosWorks() {
    List<Auto> autos = verleihsystem.listAll();

    assertThat(autos, contains(kombi, bus));
  }

  @Test
  void listAllVerfuegbareAutosWorks() {
    List<Auto> autos = verleihsystem.listVerfuegbare();

    assertThat(autos, contains(kombi, bus));
  }

  @Test
  void gemietetesAutoIstNichtMehrVerfuegbar() {
    assertThat(verleihsystem.listVerfuegbare(), contains(kombi, bus));

    verleihsystem.mieteAuto(KOMBI);

    assertThat(verleihsystem.listVerfuegbare(), contains(bus));
    assertThat(verleihsystem.listVerfuegbare(), not(hasItem(kombi)));
  }

}