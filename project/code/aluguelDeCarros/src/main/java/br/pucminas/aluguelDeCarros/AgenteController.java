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
public class AgenteController {

    @Autowired
    private AgenteRepository agenteRepository;

    @GetMapping("/criarAgente")
    public String mostrarFormCriarAgente(Agente agente) {
        return "criarAgente";
    }

    @PostMapping("/criarAgente")
    public String adicionarAgente(@Valid Agente agente, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarAgente";
        }

        agenteRepository.save(agente);
        return "redirect:/readAgente";
    }

    @GetMapping("/readAgente")
    public String showAgenteList(Model model) {
        model.addAttribute("agentes", agenteRepository.findAll());
        return "readAgente";
    }

    @GetMapping("/agenteEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Agente agente = agenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agente Id:" + id));

        model.addAttribute("agente", agente);
        return "updateAgente";
    }

    @PostMapping("/agenteUpdate/{id}")
    public String updateAgente(@PathVariable("id") long id, @Valid Agente agente,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            agente.setId(id);
            return "updateAgente";
        }

        agenteRepository.save(agente);
        return "redirect:/readAgente";
    }

    @GetMapping("/agenteDelete/{id}")
    public String deleteAgente(@PathVariable("id") long id, Model model) {
        Agente agente = agenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agente Id:" + id));
        agenteRepository.delete(agente);
        return "redirect:/readAgente";
    }

}
