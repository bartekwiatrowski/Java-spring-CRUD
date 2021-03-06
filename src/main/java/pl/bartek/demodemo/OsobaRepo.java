package pl.bartek.demodemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OsobaRepo extends JpaRepository <Osoba, Integer> {
    List<Osoba> findAllBynameInGame(String search);
    List<Osoba> findAllBycountry(String search);
    List<Osoba> findAllByteam(String search);

}
