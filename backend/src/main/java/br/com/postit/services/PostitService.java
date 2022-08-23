package br.com.postit.services;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postit.models.PostitModel;
import br.com.postit.repositories.PostitRepository;

@Service
public class PostitService {

	@Autowired
	private PostitRepository repository;
	
	
	public List<PostitModel> buscaTodos(){
		return repository.findAll();
	}
	public PostitModel criaPostit(PostitModel postit) {
		validaEntradas(postit);
		postit.setDate(LocalDateTime.now());
		return repository.save(postit);
	}
	public PostitModel atualizarPostit(PostitModel postit) {
		return null;
	}
	
	
	public void validaEntradas(PostitModel postit) throws ServiceException {		
		if(postit.getDescricao() == null || postit.getDescricao().isEmpty()) {
			throw new ServiceException("A descrição não pode ser nula!");
		}
	}
}
