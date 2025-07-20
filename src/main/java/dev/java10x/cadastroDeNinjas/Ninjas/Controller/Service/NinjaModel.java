package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;

     @Column(name = "nome")
     private String nome;


     @Column(unique = true, name = "email")
     private String email;

     @Column(name = "idade")
     private int idade;

     @ManyToOne
     @JoinColumn(name = "missoes_id")
     @Column(name = "missoes")
     private MissoesModel missoes;


}
