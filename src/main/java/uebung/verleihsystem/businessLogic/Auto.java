package uebung.verleihsystem.businessLogic;

public class Auto {
  private Kategorie kategorie;

  public Auto(Kategorie kategorie) {
    this.kategorie = kategorie;
  }
  public Kategorie getKategorie() {
    return kategorie;
  }
}
