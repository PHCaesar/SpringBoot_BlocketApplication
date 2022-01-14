package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * User Model Class
 */

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User extends AbstractPersistable<Long> {

    @OneToMany
    private List<Surname> surnames;

    private String firstname;

    private String name;

    private String username;

    private LocalDate birthDate;
    @ElementCollection
    private List<Permission> permissions;

}
