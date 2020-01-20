package pl.bartek.demodemo;

import javax.persistence.*;


@Entity
@Table(name="GCD")
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nameInGame;
    private String surname;
    @Column(name="numer", nullable=false)
    private String date;
    private String role;
    private String country;
    private String social1;
    private String social2;
    @Column(length = 2048)
    private String team;
    @Transient
    boolean  nowy;

    public Osoba(String name, String nameInGame, String surname, String date, String role, String country, String social1, String social2,  String team, boolean nowy) {
        this.name = name;
        this.nameInGame = nameInGame;
        this.surname = surname;
        this.date = date;
        this.role = role;
        this.country = country;
        this.social1 = social1;
        this.social2 = social2;
        this.team = team;
        this.nowy = nowy;
    }

    public Osoba(Integer id, String name, String nameInGame, String surname, String date, String role, String country, String social1, String social2, String team, boolean nowy) {
        this.id = id;
        this.name = name;
        this.nameInGame = nameInGame;
        this.surname = surname;
        this.date = date;
        this.role = role;
        this.country = country;
        this.social1 = social1;
        this.social2 = social2;
        this.team = team;
        this.nowy = nowy;
    }

    public Osoba() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameInGame() {
        return nameInGame;
    }

    public void setNameInGame(String nameInGame) {
        this.nameInGame = nameInGame;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSocial1() {
        return social1;
    }

    public void setSocial1(String social1) {
        this.social1 = social1;
    }

    public String getSocial2() {
        return social2;
    }

    public void setSocial2(String social2) {
        this.social2 = social2;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", nameInGame=" + nameInGame + '\'' +
                ", surname=" + surname + '\'' +
                ", date=" + date + '\'' +
                ", role=" + role + '\'' +
                ", country=" + country + '\'' +
                ", social=" + social1 + '\'' +
                ", social=" + social2 + '\'' +
                " team=" + team + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}
