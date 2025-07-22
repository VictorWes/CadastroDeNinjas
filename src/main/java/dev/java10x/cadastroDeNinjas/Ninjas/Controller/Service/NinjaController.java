package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    @GetMapping("/listarNinjas")
    public List<NinjaModel> todosNinjas(){
        return ninjaService.listarNinjas();
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
