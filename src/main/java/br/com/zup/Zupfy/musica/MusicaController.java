package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.dtos.MusicaCadastroDTO;
import br.com.zup.Zupfy.musica.dtos.MusicaDetalhesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MusicaService musicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDetalhesDTO cadastrarMusica (@RequestBody @Valid MusicaCadastroDTO musicaCadastroDTO){
        Musica musica = modelMapper.map(musicaCadastroDTO, Musica.class);

        return modelMapper.map(musicaService.cadastrarMusica(musica),MusicaDetalhesDTO.class);
    }
}
