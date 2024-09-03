package br.pucminas.aluguelDeCarros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutomovelController {

    @Autowired
    private AutomovelRepository repository;

    @GetMapping("/criarAutomovel")
    public String mostrarFormCriarAutomovel(Automovel automovel) {
        return "criarAutomovel";
    }

    @PostMapping("/criarAutomovel")
    public String adicionarAutomovel(@Valid Automovel automovel, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarAutomovel";
        }

        repository.save(automovel);
        return "redirect:/readAutomovel";
    }

    @GetMapping("/readAutomovel")
    public String showUserList(Model model) {
        model.addAttribute("automoveis", repository.findAll());
        return "readAutomovel";
    }

    @GetMapping("/automovelEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Automovel automovel = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("automovel", automovel);
        return "updateAutomovel";
    }

    @PostMapping("/automovelUpdate/{id}")
    public String updateAutomovel(@PathVariable("id") long id, @Valid Automovel automovel,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            automovel.setId(id);
            return "updateAutomovel";
        }

        repository.save(automovel);
        return "redirect:/readAutomovel";
    }

    @GetMapping("/automovelDelete/{id}")
    public String deleteAutomovel(@PathVariable("id") long id, Model model) {
        Automovel automovel = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repository.delete(automovel);
        return "redirect:/readAutomovel";
    }

}
