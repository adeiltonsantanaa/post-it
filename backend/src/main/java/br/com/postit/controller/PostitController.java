package br.com.postit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postit.models.PostitModel;
import br.com.postit.services.PostitService;

@RestController
@RequestMapping(value = "/postit")
public class PostitController {

	@Autowired
	private PostitService service;
	
	@GetMapping(path = "/check")
	public String check() {
		return "ok";
	}
	
	@GetMapping(path = "/todos")
	public Page<PostitModel> buscarTodosPostits(Pageable pageable) {
		return service.buscaTodos(pageable);
	}
	
	@PostMapping(path = "/salvar")
	public PostitModel salvar(@RequestBody @Valid PostitModel postit) {
		return service.criaPostit(postit);
	}
	
	@PutMapping(path = "/atualizar/{id}")
	public PostitModel atualizarDescricao(@PathVariable Long id, @RequestBody @Valid PostitModel postit) {
		return service.atualizarPostit(postit, id);
	}
	
	
	
	
	
}
