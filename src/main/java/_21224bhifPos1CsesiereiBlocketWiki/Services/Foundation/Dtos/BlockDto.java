package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;

import java.time.LocalDateTime;

public record BlockDto(int blockDurability,String name,int size
        ,String blockname) {
    public  BlockDto(Block block) {
        this(block.getBlockDurability(),block.getName(),block.getSize(),block.getBlockname());
    }
}
