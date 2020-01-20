package pl.bartek.demodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class addControler {
    private OsobaRepo osobaRepo;

    @Autowired
    public addControler(OsobaRepo osobaRepo) {
        this.osobaRepo = osobaRepo;
    }

    @RequestMapping("/")
    public String menu(){
        return "menu";
    }

    @RequestMapping("/add")
    public String addPlayer(){
        return "addPlayer";
    }

    @RequestMapping("/adminMenu")
    public String adminList(){
        return "adminMenu";
    }

    @RequestMapping("/editAdminList")
    public String deleteUser(Model model){
        for (Osoba osoba : osobaRepo.findAll()) {
            System.out.println(osoba);
        }
        model.addAttribute("osoba", osobaRepo.findAll());

        return "editAdminList";
    }

    @RequestMapping("/addPlayer")
    public String addPlayer(
            @RequestParam("name") String name,
            @RequestParam("nameInGame") String nameInGame,
            @RequestParam("surname") String surname,
            @RequestParam("date") String date,
            @RequestParam("role") String role,
            @RequestParam("country") String country,
            @RequestParam("social1") String social1,
            @RequestParam("social2") String social2,
            @RequestParam("team") String team,
            Model model)
            throws Exception {
        Osoba osoba = new Osoba(name, nameInGame, surname, date, role, country, social1, social2, team, true);
        System.out.println(osoba);
        osobaRepo.save(osoba);
        model.addAttribute("osoba", osoba);
        return "placeholder";
    }

    @RequestMapping("/list")
    public String pokaz( Model model){
        int i=0;
        for (Osoba osoba : osobaRepo.findAll()) {
            System.out.println(osoba);
        }
        model.addAttribute("osoba", osobaRepo.findAll());
        return "list";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("id") Integer id, Model model){
        model.addAttribute("osoba", osobaRepo.findById(id));
        return "details";
    }

    @RequestMapping("/delete")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        osobaRepo.deleteById(id);

        model.addAttribute("osoba", osobaRepo.findAll());
        return "editAdminList";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("word") String word, Model model){
        model.addAttribute("osoba", osobaRepo.findAllBynameInGame(word));
        model.addAttribute("osoba", osobaRepo.findAllBycountry(word));
        model.addAttribute("osoba", osobaRepo.findAllByteam(word));
        return "list";
    }

    @RequestMapping("/searchAdmin")
    public String searchAdmin(@RequestParam("word") String word, Model model){
        model.addAttribute("osoba", osobaRepo.findAllBynameInGame(word));
        model.addAttribute("osoba", osobaRepo.findAllBycountry(word));
        model.addAttribute("osoba", osobaRepo.findAllByteam(word));
        return "editAdminList";
    }


    @RequestMapping("/updateList")
    public String updateList(@RequestParam("id") Integer id, Model model)
            throws Exception {
        System.out.println(osobaRepo.findById(id));
        model.addAttribute("osoba", osobaRepo.findById(id));
        return "update";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("nameInGame") String nameInGame,
            @RequestParam("surname") String surname,
            @RequestParam("date") String date,
            @RequestParam("role") String role,
            @RequestParam("country") String country,
            @RequestParam("social1") String social1,
            @RequestParam("social2") String social2,
            @RequestParam("team") String team, Model model)
            throws Exception {
        Osoba osoba = new Osoba(id, name, nameInGame, surname, date, role, country, social1, social2, team, true);
        System.out.println(osoba);
        osobaRepo.save(osoba);
        model.addAttribute("osoba", osoba);
        return "placeholder";
    }
}


