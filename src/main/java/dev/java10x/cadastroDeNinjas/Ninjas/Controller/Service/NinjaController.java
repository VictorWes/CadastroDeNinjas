package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<NinjaDTO>> todosNinjas(){
        List<NinjaDTO> listas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listas);
    }

    @PostMapping("/criar")
        public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
            NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " (ID) " + ninjaDTO.getId());
        }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaDTO);
        if (ninja!= null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja ID " + id + " não encontrado");
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarById(id);
        if ( ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletarNinja/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
       if (ninjaService.listarById(id) != null){
        ninjaService.deletarNinja(id);
       return ResponseEntity.ok("Ninja do ID "+ id + " deletado com sucesso");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja ID " + id + " não encontrado");
       }

     }


}
