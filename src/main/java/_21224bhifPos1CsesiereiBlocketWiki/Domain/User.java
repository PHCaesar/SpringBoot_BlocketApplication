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

    @Getter @Setter @OneToMany
    private List<Surname> surnames;
    @Getter @Setter @Column(name = "firstname")
    private String Firstname;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "username")
    private String username;
    @Getter @Setter @Column(name = "birthDate")
    private LocalDate birthDate;
    @Getter @Setter @ElementCollection @Column(name = "permissions")
    private List<Permission> permissions;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
