package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MockUp {

    ///BLOCK
    public static BlockDto mockUpBlockDTO(int durability, String blockname, String name, int size){
        return new BlockDto(durability,name,size,blockname);
    }

    public static Block mockUpBlock(String name,int blockDur,String blockName,int size,LocalDateTime localDateTime,String token){
        return Block.builder().name(name).blockDurability(blockDur).blockname(blockName).size(size).created_at(localDateTime).token(token).build();
    }

    ///ITEM
    public static UsableItem mockUpItem(int size,String name,String description,LocalDateTime localDateTime,String token){
        return UsableItem.builder().size(size).name(name).description(description).created_at(localDateTime).token(token).build();
    }

    public static UsableItemDto mockUpItemDTO(String name , int size , LocalDateTime created_at , String description , String token){
        return new UsableItemDto(name,size,created_at,description,token);
    }

    ///WEAPON
    public static Weapon mockUpWeapon(int damage, String name, WeaponClass weaponClass, String description, LocalDateTime created_at, String token){
        return Weapon.builder().damage(damage).name(name).classification(weaponClass).description(description).created_at(created_at).token(token).build();
    }

    public static WeaponDto mockUpWeaponDTO(int damage, String name, WeaponClass weaponClass, String description, LocalDateTime created_at, String token){
        return new WeaponDto(mockUpWeapon(damage,name,weaponClass,description,created_at,token));
    }

    //MOB
    public static Mob mockUpMob(String name, List<UsableItem> drops,MobType type, LocalDateTime created_at, String token){
        return Mob.builder().name(name).drops(drops).type(type).created_at(created_at).token(token).build();
    }

    public static MobDto mockUpMobDTO(String name, List<UsableItem> drops,MobType type, LocalDateTime created_at, String token){
        return new MobDto(mockUpMob(name,drops,type,created_at,token));
    }

    //NonPlayerCharacter
    public static NonPlayerCharacter mockUpNonPlayerCharacter(String name,int health,List<UsableItem> shopItems,LocalDateTime created_at, String token){
        return NonPlayerCharacter.builder().name(name).health(health).shopItems(shopItems).created_at(created_at).token(token).build();
    }

    public static NonPlayerCharacterDto mockUpNonPlayerCharacterDto(String name,int health,List<UsableItem> shopItems,LocalDateTime created_at, String token){
        return new NonPlayerCharacterDto(mockUpNonPlayerCharacter(name, health, shopItems, created_at, token));
    }

    //SURNAME
    public static Surname mockUpSurname(String name,String token,LocalDateTime created_at){
        return Surname.builder().name(name).created_at(created_at).token(token).build();
    }

    public static SurnameDto mockUpSurnameDTO(String name,String token,LocalDateTime created_at){
        return new SurnameDto(mockUpSurname(name, token, created_at));
    }

    //USER
    public static GameUser mockUpGameUser(String name,String firstname, String username,List<Surname> surnames, LocalDate birthDate,String token,LocalDateTime created_at){
        return GameUser.builder().name(name).firstname(firstname).username(username).surnames(surnames).birthDate(birthDate).token(token).created_at(created_at).build();
    }

    public static GameUserDto mockUpGameUserDTO(String name, String firstname,String username,List<Surname> surnames, LocalDate birthDate,String token,LocalDateTime created_at){
        return new GameUserDto(mockUpGameUser(name, firstname,username, surnames, birthDate, token, created_at));
    }

    //GameContent
    public static GameContent mockUpGameContent(List<Block> blocks,List<UsableItem> items,List<Mob> mobs,GameUser user,List<NonPlayerCharacter> npcs,String token,LocalDateTime created_at){
        return GameContent.builder().blocksInGame(blocks).itemsInGame(items).mobsInGame(mobs).loggedInGameUser(user).nonPlayerCharactersInGame(npcs).created_at(created_at).token(token).build();
    }
}

