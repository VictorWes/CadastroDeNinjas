package dev.java10x.cadastroDeNinjas.ControllerDocker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("docker")
@RestController
public class DockerController {

    @GetMapping("/docker")
    public String mensagem(){
        return "Essa é uma aplicação Docker";
    }
}
