package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    @GetMapping("/listar")
    public String todosNinjas(){
        return "todosNinjas";
    }

    @PostMapping("/criar")
    public String criandoNinja(){
        return "Criando ninja";
    }
    @PutMapping("/alterarId")
    public String atualizarNinja(){
        return "Alterando dados ninja";
    }
    @GetMapping("/porId")
    public String ninjaPorId(){
        return "Buscando Ninja pelo ID";
    }
    @GetMapping("/deletarId")
    public String deletarNinja(){
        return "Deletando Ninja pelo Id";
    }


}
