package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * User Model Class
 */

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder

@Entity
@Table(name = "Users")
public class User {

    @Id @GeneratedValue
    private Long id;

    @OneToMany
    private List<Surname> surnames;

    private String firstname;

    private String name;

    private String username;

    private LocalDate birthDate;
    @ElementCollection
    private List<Permission> permissions;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
