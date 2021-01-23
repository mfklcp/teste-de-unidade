package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {

    @Test
    public void main() {
        Usuario joao = new Usuario("joão");
        Usuario jose = new Usuario(("jose"));
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 novo");

        leilao.propoe(new Lance(joao, 200.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();

        leiloeiro.avalia(leilao);

        double maiorEsperado = 400.0;
        double menorEsperado = 200.0;
        double mediaEsperada = 300.0;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperada, leiloeiro.getMediaLance(), 0.00001);

        System.out.println(leiloeiro.getMediaLance());
    }

}
