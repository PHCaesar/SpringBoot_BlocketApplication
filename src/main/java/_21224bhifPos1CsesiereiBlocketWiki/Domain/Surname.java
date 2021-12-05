package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class Surname {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
