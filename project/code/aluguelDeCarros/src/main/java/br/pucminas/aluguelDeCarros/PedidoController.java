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
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/criarPedido")
    public String mostrarFormCriarPedido(Pedido pedido) {
        return "criarPedido";
    }

    @PostMapping("/criarPedido")
    public String adicionarPedido(@Valid Pedido pedido, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarPedido";
        }

        pedidoRepository.save(pedido);
        return "redirect:/readPedido";
    }

    @GetMapping("/readPedido")
    public String showUserList(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "readPedido";
    }

    @GetMapping("/pedidoEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("pedido", pedido);
        return "updatePedido";
    }

    @PostMapping("/pedidoUpdate/{id}")
    public String updatePedido(@PathVariable("id") long id, @Valid Pedido pedido,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            pedido.setId(id);
            return "updatePedido";
        }

        pedidoRepository.save(pedido);
        return "redirect:/readPedido";
    }

    @GetMapping("/pedidoDelete/{id}")
    public String deletePedido(@PathVariable("id") long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        pedidoRepository.delete(pedido);
        return "redirect:/readPedido";
    }

}
