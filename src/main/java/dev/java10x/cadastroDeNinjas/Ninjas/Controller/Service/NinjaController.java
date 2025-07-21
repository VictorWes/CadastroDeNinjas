package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    @GetMapping("/todosNinjas")
    public String todosNinjas(){
        return "todosNinjas";
    }

    @PostMapping("/criandoNinja")
    public String criandoNinja(){
        return "Criando ninja";
    }
    @PutMapping("/atualizarNinja")
    public String atualizarNinja(){
        return "Alterando dados ninja";
    }
    @GetMapping("/ninjaPorId")
    public String ninjaPorId(){
        return "Buscando Ninja pelo ID";
    }
    @GetMapping("/deletarNinjaId")
    public String deletarNinja(){
        return "Deletando Ninja pelo Id";
    }


}
