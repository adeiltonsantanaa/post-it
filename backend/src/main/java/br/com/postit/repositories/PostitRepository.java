package br.com.postit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postit.models.PostitModel;

public interface PostitRepository extends JpaRepository<PostitModel, Long> {

}
