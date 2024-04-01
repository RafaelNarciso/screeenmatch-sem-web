package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeiroProjetoSpringSemWebApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(PrimeiroProjetoSpringSemWebApplication.class, args);
	}

	@Override/*Com essa implementacao do CommandLineRunner sera o methado men para rodar */
	public void run(String... args) throws Exception {

		System.out.println("\n=====================================================================\n");
		System.out.println("Primeiro projeto Spring Sem Web Application");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=Gilmore+Girls&apikey=d0bc9998");
		System.out.println(json);



	/*	System.out.println("\n=====================================================================\n");
		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		System.out.println("\n=====================================================================\n");
*/
		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados =converteDados.obterDados(json,DadosSerie.class);

		System.out.println(dados);
	    System.out.println("\n=====================================================================\n");

	}
}
