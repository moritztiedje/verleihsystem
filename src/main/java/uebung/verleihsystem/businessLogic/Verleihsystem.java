package uebung.verleihsystem.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Verleihsystem {

  private List<Auto> autos = new ArrayList<>();
  private List<Auto> verfuegbareAutos = new ArrayList<>();

  public void addAuto(Auto auto) {
    autos.add(auto);
    verfuegbareAutos.add(auto);
  }

  public List<Auto> listAll() {
    return autos;
  }

  public List<Auto> listVerfuegbare() {
    return verfuegbareAutos;
  }

  public Auto mieteAuto(Kategorie kategorie) {
    Optional<Auto> verfuegbaresAuto = verfuegbareAutos.stream().filter(auto -> auto.getKategorie().equals(kategorie)).findFirst();
    verfuegbaresAuto.ifPresent(auto -> verfuegbareAutos.remove(auto));

    return verfuegbaresAuto.orElse(null); //TODO - null zurück geben ist unschön. Was soll das Programm tun, wenn kein Auto gemietet werden kann?
  }


}
