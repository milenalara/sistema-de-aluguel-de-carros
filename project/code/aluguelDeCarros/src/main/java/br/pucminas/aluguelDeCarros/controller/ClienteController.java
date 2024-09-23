package br.pucminas.aluguelDeCarros.controller;

import br.pucminas.aluguelDeCarros.model.Cliente;
import br.pucminas.aluguelDeCarros.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    Random random = new Random();

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

        cliente.setId(random.nextInt(Integer.MAX_VALUE));

        clienteRepository.save(cliente);
        return "redirect:/readCliente";
    }

    @GetMapping("/readCliente")
    public String showUserList(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "readCliente";
    }

    @GetMapping("/clienteEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("cliente", cliente);
        return "updateCliente";
    }

    @PostMapping("/clienteUpdate/{id}")
    public String updateCliente(@PathVariable("id") long id, @Valid Cliente cliente,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            cliente.setId(id);
            return "updateCliente";
        }

        clienteRepository.save(cliente);
        return "redirect:/readCliente";
    }

    @GetMapping("/clienteDelete/{id}")
    public String deleteCliente(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        clienteRepository.delete(cliente);
        return "redirect:/readCliente";
    }

}
