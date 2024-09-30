package br.pucminas.aluguelDeCarros.controller;

import br.pucminas.aluguelDeCarros.model.Agente;
import br.pucminas.aluguelDeCarros.model.Automovel;
import br.pucminas.aluguelDeCarros.model.Cliente;
import br.pucminas.aluguelDeCarros.model.Pedido;
import br.pucminas.aluguelDeCarros.repository.AgenteRepository;
import br.pucminas.aluguelDeCarros.repository.AutomovelRepository;
import br.pucminas.aluguelDeCarros.repository.ClienteRepository;
import br.pucminas.aluguelDeCarros.repository.PedidoRepository;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class PedidoController {

    Random random = new Random();

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AutomovelRepository automovelRepository;
    @Autowired
    private AgenteRepository agenteRepository;

    @GetMapping("/criarPedido")
    public String mostrarFormCriarPedido(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        List<Automovel> automoveis = automovelRepository.findAll();
        List<Agente> agentes = agenteRepository.findAll();

        model.addAttribute("clientes", clientes);
        model.addAttribute("automoveis", automoveis);
        model.addAttribute("agentes", agentes);
        model.addAttribute("pedido", new Pedido());

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
        List<Cliente> clientes = clienteRepository.findAll();
        List<Automovel> automoveis = automovelRepository.findAll();
        List<Agente> agentes = agenteRepository.findAll();

        model.addAttribute("clientes", clientes);
        model.addAttribute("automoveis", automoveis);
        model.addAttribute("agentes", agentes);
        model.addAttribute("pedido", pedido);
        return "updatePedido";
    }

    @PostMapping("/pedidoEdit/{id}")
    public String updatePedido(@PathVariable("id") long id, @Valid Pedido pedido,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            pedido.setId(id);
            return "updatePedido";
        }

        pedidoRepository.save(pedido);
        return "redirect:/pedidoEdit/{id}";
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

    @GetMapping("/readPedidoBanco")
    public String showPedidosBanco(Model model) {
        List<Pedido> pedidos = pedidoRepository.findPedidosByConfirmado(true);
        model.addAttribute("pedidos", pedidos);
        return "readPedidoBanco";
    }

//    @PostMapping("/aprovarPedidos")
//    public String aprovarPedidos(@RequestParam(value = "pedidoIds", required = false) List<Long> pedidoIds) {
//        if (pedidoIds != null) {
//            for (Long pedidoId : pedidoIds) {
//                Pedido pedido = pedidoRepository.findById(pedidoId)
//                    .orElseThrow(() -> new IllegalArgumentException("Pedido inválido Id:" + pedidoId));
//                pedido.setConfirmado(true);
//                pedidoRepository.save(pedido);
//            }
//        }
//        return "redirect:/readPedidoAgente";
//    }

}
