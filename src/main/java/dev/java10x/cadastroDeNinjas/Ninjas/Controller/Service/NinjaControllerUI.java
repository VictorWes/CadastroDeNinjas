package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("ninjas/ui")
public class NinjaControllerUI {
    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listarNinjas")
    public String todosNinjas(Model model){
        List<NinjaDTO> listas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", listas);
        return "listarNinjas";
    }

    @GetMapping("/deletarNinja/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/listarNinjas";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja =  ninjaService.listarById(id);
        if (ninja !=null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/criar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listarNinjas";
    }
}
