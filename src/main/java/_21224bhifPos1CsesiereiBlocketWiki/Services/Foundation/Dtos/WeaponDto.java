package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;

import java.time.LocalDateTime;

public record WeaponDto(String description , int damage , WeaponClass classification,String name,int size,LocalDateTime created_at,String token) {
    public WeaponDto(Weapon weapon){
        this(weapon.getDescription(), weapon.getDamage(),weapon.getClassification(),weapon.getName(), weapon.getSize(), weapon.getCreated_at(), weapon.getToken());
    }
}
