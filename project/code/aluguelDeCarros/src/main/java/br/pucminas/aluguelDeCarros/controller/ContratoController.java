package br.pucminas.aluguelDeCarros.controller;

import br.pucminas.aluguelDeCarros.model.*;
import br.pucminas.aluguelDeCarros.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Controller
public class ContratoController {
  @Autowired
  private ContratoRepository contratoRepository;

  Random random = new Random();

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private AutomovelRepository automovelRepository;
  @Autowired
  private AgenteRepository agenteRepository;

  @GetMapping("/criarContrato{id}")
  public String mostrarFormCriarContrato(@PathVariable long id, Model model) {
    Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid pedido Id:" + id));
    List<Cliente> clientes = clienteRepository.findAll();
    List<Automovel> automoveis = automovelRepository.findAll();
    List<Agente> agentes = agenteRepository.findAll();

    model.addAttribute("clientes", clientes);
    model.addAttribute("automoveis", automoveis);
    model.addAttribute("agentes", agentes);
    model.addAttribute("pedido", pedido);

    return "criarPedido";
  }

  @PostMapping("/criarContrato/{id}")
  public String adicionarContrato(@Valid Contrato contrato, BindingResult result, Model model) {

    if (result.hasErrors()) {
      return "criarContrato";
    }

    contrato.setId((long)random.nextInt(Integer.MAX_VALUE));

    contratoRepository.save(contrato);
    return "redirect:/readPedidoBanco";
  }


}
