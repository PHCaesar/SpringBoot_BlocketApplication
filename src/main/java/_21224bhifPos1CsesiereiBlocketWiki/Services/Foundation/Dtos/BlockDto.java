package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import lombok.Builder;
import lombok.Data;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record BlockDto(int blockDurability,String name,int size
        ,LocalDateTime created_at,String blockname) {
    public  BlockDto(Block block) {
        this(block.getBlockDurability(),block.getName(),block.getSize(),block.getCreated_at(),block.getBlockname());
    }
}
