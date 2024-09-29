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
public class ContratoFinanceiroController {
  @Autowired
  private ContratoFinanceiroRepository contratoRepository;
  @Autowired
  private PedidoRepository pedidoRepository;
  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private AutomovelRepository automovelRepository;
  @Autowired
  private AgenteRepository agenteRepository;

  Random random = new Random();
  @GetMapping("/criarContrato")
  public String mostrarFormCriarContrato(@PathVariable("id") long id, Model model) {
    Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid pedido Id:" + id));
    model.addAttribute("pedido", pedido);
    model.addAttribute("contrato", new ContratoFinanceiro());

    return "criarContrato";
  }

  @PostMapping("/criarContrato/{id}")
  public String criarContrato(@PathVariable("id") long id, @Valid ContratoFinanceiro contrato, BindingResult result, Model model) {
    Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid pedido Id:" + id));

    model.addAttribute("pedido", pedido);
    model.addAttribute("contrato", contratoRepository.findAll());

    if (result.hasErrors()) {
      model.addAttribute("contrato", contrato);
      return "criarContrato";
    }

    contrato.setId((long)random.nextInt(Integer.MAX_VALUE));

    contratoRepository.save(contrato);
    return "redirect:/readPedidoBanco";
  }
}
