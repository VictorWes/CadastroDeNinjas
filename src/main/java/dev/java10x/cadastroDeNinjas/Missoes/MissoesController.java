package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> ListarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/missao/{id}")
    public ResponseEntity<?> ListarMissoesId(@PathVariable Long id){
        MissoesDTO missao = missoesService.missaoId(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao não localizada");
        }

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoesCriar = missoesService.criarMissao(missao);
        return ResponseEntity.ok("Missao criado com sucesso " + missoesCriar.getId() + missoesCriar.getNome() + missoesCriar.getDificuldade() +
                missoesCriar.getDificuldade());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, MissoesDTO missao){
        MissoesDTO missaoAtualizada = missoesService.atualizarMissao(id, missao);
        if (missaoAtualizada != null){
            return ResponseEntity.ok(missaoAtualizada);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não localizada para alteração");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        MissoesDTO deletarMissao = missoesService.missaoId(id);
        if (deletarMissao != null){
           missoesService.deletarMissao(id);
           return ResponseEntity.ok(deletarMissao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja ID " + id + " não encontrado");
        }
    }
}
