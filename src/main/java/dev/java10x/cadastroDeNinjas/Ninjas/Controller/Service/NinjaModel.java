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
     private MissoesModel missoes;

     @Column(name = "ranking")
     private String ranking;


     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public int getIdade() {
          return idade;
     }

     public void setIdade(int idade) {
          this.idade = idade;
     }

     public MissoesModel getMissoes() {
          return missoes;
     }

     public void setMissoes(MissoesModel missoes) {
          this.missoes = missoes;
     }

     public String getRanking() {
          return ranking;
     }

     public void setRanking(String ranking) {
          this.ranking = ranking;
     }
}
