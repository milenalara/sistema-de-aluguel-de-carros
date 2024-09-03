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
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/criarCliente")
    public String mostrarFormCriarCliente(Cliente cliente) {
        return "criarCliente";
    }

    @PostMapping("/criarCliente")
    public String adicionarCliente(@Valid Cliente cliente, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarCliente";
        }

        clienteRepository.save(cliente);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("cliente", cliente);
        return "updateCliente";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") long id, @Valid Cliente cliente,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            cliente.setId(id);
            return "updateCliente";
        }

        clienteRepository.save(cliente);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        clienteRepository.delete(cliente);
        return "redirect:/index";
    }

}
