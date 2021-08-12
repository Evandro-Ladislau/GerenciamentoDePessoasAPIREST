package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    //É um campo obrigatorio na tabela e só pode inserir valores unicos (que nõ se repete)
    @Column(nullable = false, unique = true)
    private String cpf;


    private LocalDate birthDate;

    //sera gerada uma tabela intermediaria. ele tera dois dados o id de telefone e o id da pessoa.
    //Ela sera gerada na hora de subir o projeto.
    //cascade sera informado no persiste, merge e remoção dos dados
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;


}
