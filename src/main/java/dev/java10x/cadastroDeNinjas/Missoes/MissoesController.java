package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/todasMissoes")
    public List<MissoesDTO> ListarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/missao/{id}")
    public MissoesDTO ListarMissoesId(@PathVariable Long id){
        return missoesService.missaoId(id);
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, MissoesDTO missao){
        return missoesService.atualizarMissao(id, missao);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarNinja(id);
    }



}
