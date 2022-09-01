package br.com.postit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.postit.models.PostitModel;

public interface PostitRepository extends JpaRepository<PostitModel, Long> {

	
	@Query("SELECT obj FROM PostitModel obj ORDER BY obj.id ASC")
	Page<PostitModel> findPostit(Pageable pageable);
}
