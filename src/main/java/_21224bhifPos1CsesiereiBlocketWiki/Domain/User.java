package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.*;

import javax.lang.model.element.Name;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class User {
    private Name name;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private List<Permission> permissions;
    @Getter @Setter
    private String Firstname;

    @Id
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }



}
