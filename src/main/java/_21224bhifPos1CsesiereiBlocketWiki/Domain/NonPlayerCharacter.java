package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
public class NonPlayerCharacter {

    private String name;
    private float health;
    private List<Item> shopItems;

    @Id
    @GeneratedValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Item> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<Item> shopItems){
        this.shopItems=shopItems;
    }


    public float getHealth(){
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

}
