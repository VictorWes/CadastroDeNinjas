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
        public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
            return ninjaService.criarNinja(ninja);
        }

    @PutMapping("/alterarId")
    public String atualizarNinja(){
        return "Alterando dados ninja";
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarById(id   );
    }

    @DeleteMapping("/deletarNinja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }


}
