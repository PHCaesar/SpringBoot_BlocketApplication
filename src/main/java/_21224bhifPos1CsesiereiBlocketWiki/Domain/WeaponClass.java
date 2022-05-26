package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import com.querydsl.core.annotations.QueryEmbeddable;
import lombok.Builder;

import javax.persistence.Embeddable;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Available Weaponclasses in the Game
 */

//@Embeddable
//@QueryEmbeddable
public enum WeaponClass {
    MELEE,
    RANGED,
    MAGE,
    BENDER;

    public void WeaponClass(){

    }
}
