package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
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
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=Gilmore+Girls&apikey=d0bc9998");
		System.out.println(json);

		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados =converteDados.obterDados(json,DadosSerie.class);

		System.out.println(dados);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=Gilmore+Girls&Season=1&Episode=2&apikey=d0bc9998");
		DadosEpisodio dadosEpisodio = converteDados.obterDados(json,DadosEpisodio.class);
		System.out.println("Episodio: " + dadosEpisodio);

		System.out.println("\n=====================================================================\n");

	}
}
