package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.entity.Article;
import fr.fms.dao.ArticleRepository;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner{
	@Autowired
	ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {

		//insertDataInDataBase();

		//articleRepository.findAll().forEach(a -> System.out.println(a));

	}

	public void insertDataInDataBase(){
		articleRepository.save(new Article(null, "Café Expresso", 0.89));
		articleRepository.save(new Article(null, "Café long", 1.12));
		articleRepository.save(new Article(null, "Café Machiato", 1.23));
		articleRepository.save(new Article(null, "Café Crème", 1.19));
		articleRepository.save(new Article(null, "Mocha", 1.31));
		articleRepository.save(new Article(null, "Café NewYork", 1.71));
		articleRepository.save(new Article(null, "Cappuchino", 1.51));
		articleRepository.save(new Article(null, "Café au lait", 1.19));
		articleRepository.save(new Article(null, "Café Noisette", 1.21));
		articleRepository.save(new Article(null, "Café Vanille", 1.14));
		articleRepository.save(new Article(null, "Chocolat", 0.93));
		articleRepository.save(new Article(null, "Chocolat fort", 1.23));
		articleRepository.save(new Article(null, "Chocolat au lait entier", 1.73));
		articleRepository.save(new Article(null, "Cacao + lait", 1.96));
		articleRepository.save(new Article(null, "Cacao intense", 2.10));
	}

}
