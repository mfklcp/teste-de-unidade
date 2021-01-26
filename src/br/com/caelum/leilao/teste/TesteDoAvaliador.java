package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.Test;
import sun.util.locale.provider.AvailableLanguageTags;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Usuario joao = new Usuario("joão");
        Usuario jose = new Usuario(("jose"));
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 novo");

        leilao.propoe(new Lance(joao, 200.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(300, leiloeiro.getMediaLance(), 0.00001);

        System.out.println(leiloeiro.getMediaLance());
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance(){
        Usuario joao = new Usuario("joão");
        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(joao, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.00, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(1000.00, leiloeiro.getMenorLance(), 0.00001);

    }
    @Test
    public void deveEncontrarOsTresMaiores(){
        Usuario joao = new Usuario("joao");
        Usuario maria = new Usuario("maria");
        Leilao leilao = new Leilao("Playstation 5");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getMaiores();
        assertEquals(3, maiores.size(), 0.00001);
        assertEquals(400,maiores.get(0).getValor(), 0.00001);
        assertEquals(300,maiores.get(1).getValor(), 0.00001);
        assertEquals(200,maiores.get(2).getValor(), 0.00001);
    }
}
