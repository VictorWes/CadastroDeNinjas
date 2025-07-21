package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String ListarMissoes(){
        return "Missao listadas com sucesso";
    }
    @GetMapping("/listarId")
    public String ListarMissoesId(){
        return "Missao listadas por id com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }



}
