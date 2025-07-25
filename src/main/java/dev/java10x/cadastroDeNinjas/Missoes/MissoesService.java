package dev.java10x.cadastroDeNinjas.Missoes;


import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO missaoId(Long id){
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        return missaoId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public void deletarNinja(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesAtualizar){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);

        if (missaoExiste.isPresent()){
            MissoesModel atualizado = missoesMapper.map(missoesAtualizar);
            atualizado.setId(id);
            MissoesModel missaoSalva= missoesRepository.save(atualizado);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }


}
