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
    public List<NinjaDTO> todosNinjas(){
        return ninjaService.listarNinjas();
    }

    @PostMapping("/criar")
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
            return ninjaService.criarNinja(ninja);
        }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.atualizarNinja(id, ninjaDTO);
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarById(id);
    }

    @DeleteMapping("/deletarNinja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }


}
