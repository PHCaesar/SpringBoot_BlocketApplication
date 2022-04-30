package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;

import java.util.List;

public interface IMobService {
    public Mob getMobByName(String mobname);
    public List<Mob> getAllMobs();
    public Mob insertMob(MobDto mob);
    public Mob updateMob(MobDto mob);
    public void deleteMob(MobDto mob);
    public void deleteAll();
}
