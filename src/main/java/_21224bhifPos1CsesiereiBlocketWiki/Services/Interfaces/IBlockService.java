package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;

import java.util.List;

public interface IBlockService {

    public List<Block> getAllBlocks();
    public List<Block> getBlocksByDurability(int durability);
    public List<Block> getBlock(BlockDto block);
    public Block insertBlock(BlockDto block);
    public Block updateBlock(BlockDto block);
    public void deleteBlock(BlockDto block);
    public void deleteAll();

}
