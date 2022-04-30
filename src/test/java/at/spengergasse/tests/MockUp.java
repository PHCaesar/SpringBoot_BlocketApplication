package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;

import java.time.LocalDateTime;

public class MockUp {

    public static BlockDto mockUpBlockDTO(int durability, String blockname, String name, int size, LocalDateTime dateTime){
        return new BlockDto(durability,name,size,dateTime,blockname);
    }

    public static Block mockUpBlock(String name,int blockDur,String blockName,int size,LocalDateTime localDateTime,String token){
        return Block.builder().name(name).blockDurability(blockDur).blockname(blockName).size(size).created_at(localDateTime).token(token).build();
    }
}
