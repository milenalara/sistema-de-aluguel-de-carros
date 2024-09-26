package br.pucminas.aluguelDeCarros.controller;

import br.pucminas.aluguelDeCarros.model.Pedido;
import br.pucminas.aluguelDeCarros.repository.ClienteRepository;
import br.pucminas.aluguelDeCarros.repository.PedidoRepository;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedidoController {

    Random random = new Random();

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/criarPedido")
    public String mostrarFormCriarPedido(Pedido pedido) {
        return "criarPedido";
    }

    @PostMapping("/criarPedido")
    public String adicionarPedido(@Valid Pedido pedido, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "criarPedido";
        }

        pedido.setId(random.nextInt(Integer.MAX_VALUE));

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

    @GetMapping("/readPedidoAgente")
    public String showPedidosAgente(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "readPedidoAgente";
    }

    @PostMapping("/aprovarPedidos")
    public String aprovarPedidos(@RequestParam(value = "pedidoIds", required = false) List<Long> pedidoIds) {
        if (pedidoIds != null) {
            for (Long pedidoId : pedidoIds) {
                Pedido pedido = pedidoRepository.findById(pedidoId)
                        .orElseThrow(() -> new IllegalArgumentException("Pedido inválido Id:" + pedidoId));
                pedido.setConfirmado(true);
                pedidoRepository.save(pedido);
            }
        }
        return "redirect:/readPedidoAgente";
    }

    @GetMapping("/pedidoDeleteAgente/{id}")
    public String deletePedidoAgente(@PathVariable("id") long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        pedidoRepository.delete(pedido);
        return "redirect:/readPedidoAgente";
    }

}
