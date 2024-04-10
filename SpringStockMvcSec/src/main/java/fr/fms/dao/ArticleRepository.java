package fr.fms.dao;

import fr.fms.entity.Article;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article,Long>{
	Page<Article> findByDescriptionContains(String description, Pageable pageable);
}
