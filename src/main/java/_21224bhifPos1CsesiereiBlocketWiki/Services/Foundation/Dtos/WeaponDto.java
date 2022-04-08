package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record WeaponDto(String description , int damage , WeaponClass classification,String name,int size,LocalDateTime created_at) {
    public WeaponDto(Weapon weapon){
        this(weapon.getDescription(), weapon.getDamage(),weapon.getClassification(),weapon.getName(), weapon.getSize(), weapon.getCreated_at());
    }
}
