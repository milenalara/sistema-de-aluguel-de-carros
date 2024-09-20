package br.pucminas.aluguelDeCarros.controller;

import br.pucminas.aluguelDeCarros.model.Usuario;
import br.pucminas.aluguelDeCarros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/criarUsuario")
    public String mostrarFormCriarUsuario(Usuario usuario) {
        return "criarUsuario";
    }

    @PostMapping("/criarUsuario")
    public String adicionarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarUsuario";
        }

        usuarioRepository.save(usuario);
        return "redirect:/readUsuario";
    }

    @GetMapping("/readUsuario")
    public String showUsuarioList(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "readUsuario";
    }

    @GetMapping("/usuarioEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid usuario Id:" + id));

        model.addAttribute("usuario", usuario);
        return "updateUsuario";
    }

    @PostMapping("/usuarioEdit/{id}")
    public String updateUsuario(@PathVariable("id") long id, @Valid Usuario usuario,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            usuario.setId(id);
            return "updateUsuario";
        }

        usuarioRepository.save(usuario);
        return "redirect:/readUsuario";
    }

    @GetMapping("/usuarioDelete/{id}")
    public String deleteUsuario(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid usuario Id:" + id));
        usuarioRepository.delete(usuario);
        return "redirect:/readUsuario";
    }

}
