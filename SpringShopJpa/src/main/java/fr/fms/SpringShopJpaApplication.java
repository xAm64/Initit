package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import java.util.Scanner;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner{
	Scanner scn = new Scanner(System.in);
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category smartphone = categoryRepository.save(new Category("smartphone"));
		Category tablet = categoryRepository.save(new Category("tablet"));
		Category pc = categoryRepository.save(new Category("pc"));
		
		articleRepository.save(new Article("S10", "Samsoung", 549, smartphone));
		articleRepository.save(new Article("S9", "Samsoung", 379, smartphone));
		articleRepository.save(new Article("MI10", "Xiaomi", 149, smartphone));
		articleRepository.save(new Article("GalaxyTab", "Samsoung", 479, tablet));
		articleRepository.save(new Article("Ipad", "Apple", 995, tablet));
		articleRepository.save(new Article("R510", "Asus", 1190, pc));
		articleRepository.save(new Article("G810", "Asus", 1390, pc));
		articleRepository.save(new Article("X58", "Strompoli", 95, tablet));
		articleRepository.save(new Article("Honor 12X", "Huaway", 389, smartphone));
		articleRepository.save(new Article("Bureau 2024", "Acer", 390, pc));
		articleRepository.save(new Article("Transformer T350", "Asus", 290, pc));

		int choise;
		do {
			choise = lookInstructions(scn);
			switch (choise) {
			case 0:
				System.out.println("À bientôt");
			break;
			case 1:
				lookAllArticles();
			break;
			case 4:
				lookAnArticle(itsAnId(scn));
			break;
			case 5:
				System.out.println("Séléctionner l'id de l'article a supprimmer");
				deleteArticle(itsAnId(scn));
			break;
			case 6:
				System.out.println("Séléctionner l'id de l'article a modifier");
				updateArticle(itsAnId(scn));
			break;
			default:
				System.out.println("Cette option n'existe pas");
			}
		}while (choise != 0);
		
	}
	//exercice 1.2
	public void lookAllArticles() {
		for (Article article: articleRepository.findAllByOrderByIdAsc()) {
			System.out.println(article);
		}
	}
	public void lookAnArticle(long id){
		System.out.println(articleRepository.findById((long) id));
	}
	
	//exercice 1.3 
	public void lookArticle(String description, String brand) {
		if (description != null || brand != null) {
			if (description != null) {
				for (Article article : articleRepository.findByDescription(description)) {
					System.out.println(article);
				}
			}
			if (brand != null) {
				for (Article article : articleRepository.findByBrand(brand)) {
					System.out.println(article);
				}
			}
		} else {
			System.out.println("Opéation impossible, l'ordinatgeur n'est pas une voyante");
		}
	}

	//exercice 1.4 ajouter une métode pour effacer un article.
	public void deleteArticle(Long id) {
		articleRepository.deleteById((long) id);
	}
	
	public void updateArticle(Long id) {
		System.out.println("Acticle actuel: "+articleRepository.findById((long) id));
		System.out.println("Nouvelle description");
		String description = scn.nextLine();
		System.out.println("Nouvelle marque");
		String brand = scn.nextLine();
		System.out.println("Nouveau prix");
		Double price = scn.nextDouble();
		articleRepository.updateArticle(id, description, brand, price);
	}
	
	public void articlesByCategoryAsc() {
		
	}
	
	public void articlesByCategory() {
		System.out.println(articleRepository.findAll(Sort.by("category_id")));
	}
	public void articlesByCategoryDesc() {
		for (Article article : articleRepository.findAllByOrderByCategoryIdDesc()) {
			System.out.println(article);
		}
		//System.out.println(articleRepository.findAllByOrderByCategoryIdDesc());
	}
	
	//méthodes pour le TP
	public static int lookInstructions(Scanner scn) {
		String instructions = "Bienvenue dans notre application de gestion d'articles !\n"+
				"0 Sortir\n"+
				"1 Afficher tous les articles\n"+
				"*****************\n"+
				"4 Afficher un article\n"+
				"5 supprimmer un article\n"+
				"6 Modifier un artyicle\n";
		System.out.println(instructions);
		return itsANumber(scn);
	}
	//contrôle si écrit un chiffre
	public static int itsANumber(Scanner scn) {
		Boolean reset = true;
		while (reset) {
			System.out.println("Écrire un chiffre");
			try {
				int x = scn.nextInt();
				reset = true;
				return x;
			}catch (Exception e) {
				System.out.println("ceci n'est pas un chiffre: "+e);
				scn.next();
				reset = false;
			}
		};
		return -1;
	}
	public static long itsAnId(Scanner scn) {
		Boolean reset = true;
		while (reset) {
			System.out.println("Écrire un chiffre");
			try {
				long x = scn.nextInt();
				reset = true;
				return x;
			}catch (Exception e) {
				System.out.println("ceci n'est pas un chiffre: "+e);
				scn.next();
				reset = false;
			}
		};
		return -1;
	}
}