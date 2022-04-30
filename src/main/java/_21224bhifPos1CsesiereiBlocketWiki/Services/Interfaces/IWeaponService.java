package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.WeaponDto;

public interface IWeaponService {
    public Weapon getByName(String name);
    public Weapon insertWeapon(WeaponDto wep);
    public Weapon updateWeapon(WeaponDto wep);
    public void deleteWeapon(WeaponDto wep);
    public void deleteAll();
}
