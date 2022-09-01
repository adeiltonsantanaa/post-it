package br.com.postit.services;

import java.time.LocalDateTime;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.postit.models.PostitModel;
import br.com.postit.repositories.PostitRepository;

@Service
public class PostitService {

	@Autowired
	private PostitRepository repository;
	@Autowired
	private PostitEmailService mail;

	public Page<PostitModel> buscaTodos(Pageable pageable) {
		return repository.findPostit(pageable);
	}

	public PostitModel criaPostit(PostitModel postit) {
		new Thread() {

			@Override
			public void run() {

				validaEntradas(postit);
				postit.setDate(LocalDateTime.now());
				mail.sendMail("Postit Adicionado \n" + postit);
			}
		}.start();
		return repository.save(postit);
	}

	public PostitModel atualizarPostit(PostitModel postit, long id) {
		PostitModel p1 = repository.getById(id);
		p1.setDescricao(postit.getDescricao());
		return null;
	}

	public void validaEntradas(PostitModel postit) throws ServiceException {
		if (postit.getDescricao() == null || postit.getDescricao().isEmpty()) {
			throw new ServiceException("A descrição não pode ser nula!");
		}
	}
}
