package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public Musica cadastrarMusica(Musica musica) {
        musica.setDataDeCadastro(LocalDate.now());
        musicaRepository.save(musica);
        return musica;
    }

    public void deletarMusica(int id) {
        if (!musicaRepository.existsById(id)) {
            throw new MusicaNaoEcontradaExeception("Musica não encontrada");
        }
        musicaRepository.deleteById(id);
    }

    public Musica atualizarMusica(Musica musica) {
        musica = new Musica();
        musica.setNome(musica.getNome());
        musica.setDataDeCadastro(musica.getDataDeCadastro());
        musica.setId(musica.getId());
        musicaRepository.save(musica);

        return musica;
    }

    public List<Musica> retornarTodasAsMusicas() {
        List<Musica> musica = (List<Musica>) musicaRepository.findAll();
        return musica;
    }
}
