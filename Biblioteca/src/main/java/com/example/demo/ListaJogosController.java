package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ListaJogosController {
	
	private JogoRepositorioSpring jg;
	
	@Autowired
	public ListaJogosController(JogoRepositorioSpring jg/*, VendaRepositorioSpring vr*/) {
		this.jg = jg;
		/*this.vr = vr;*/
	}

	@RequestMapping("/listajogos")
	public String consultarJogos(Model model) {
		model.addAttribute("Jogos", jg.findAll());
		return "listajogos";
	}
	
	@GetMapping("/jogo/cadastro")
    public String produtoForm(Model model) {
        model.addAttribute("jogoNovo", new Jogo());
        return /*"cadastraprodutos"*/"cadastrajogos";
    }
	
	@PostMapping("/jogo/cadastro")
	public String produtoCadastro(@ModelAttribute Jogo jogoNovo, Model model) {
		Jogo novoJg = jg.save(jogoNovo);
		return "redirect:/listajogos";
	}
	
}