package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.NanoIdFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IBlockService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class BlockService implements IBlockService {
    // Parameterized Exception output

    private final BlockRepository blockRepository;

    @Autowired
    private final TemporalValueFactory temporalValueFactory;
    @Autowired
    private final TokenService tokenService;

    // GET

    public List<Block> getBlocksByDurability(int durability) {

        if(blockRepository.findByBlocksDurability(durability).size()>0)
        {
            return blockRepository.findByBlocksDurability(durability);
        }else throw new NoResultException("Blocks "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public List<Block> getAllBlocks(){
        return blockRepository.findAll();
    }

    public List<Block> getBlock(BlockDto block){
        checkParameterInput(block);

        var realBlock = blockRepository.findAll();
        log.info("Found {} blocks", realBlock.size());
        return realBlock;
    }
    // CRUD

    // CREATE
    public Block insertBlock(BlockDto block){
        checkParameterInput(block);
        if(blockRepository.findByDTO(block)==null){
            Block blockInstance = createInstanceByDTO(block);
            blockInstance.setNanoId(new NanoIdFactory().randomNanoId(16));
            blockRepository.insert(blockInstance);
            log.info("InsertBlock {} blockInstance", blockInstance);
            return blockInstance;
        } else {
            log.warn("InsertBlock Block "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Block "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public Block updateBlock(BlockDto block){
        checkParameterInput(block);

        if(blockRepository.findByDTO(block)!=null){
            deleteBlock(block);
            Block blockInstance = createInstanceByDTO(block);
            log.info("updateBlock {} blockInstance", blockInstance);
            return blockInstance;
        } else {
            log.warn("updateBlock Block "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteBlock(BlockDto block){
        checkParameterInput(block);

        if(blockRepository.findByDTO(block)!=null) {
            blockRepository.deleteBlock(blockRepository.findByDTO(block));
            log.info("updateBlock {} block", block);
        } else {
            log.warn("deleteBlock Block "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void deleteAll() {
        blockRepository.deleteAll();
    }


    public void checkParameterInput(BlockDto block) {

        Objects.requireNonNull(block);

        if(block.name().isEmpty()) {
            log.warn("checkParameterInput Block " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(block.size()==0) {
            log.warn("checkParameterInput Block " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Size " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Block createInstanceByDTO(BlockDto block){
        Objects.requireNonNull(block);

        Block blockInstance = Block.builder()
                .blockname(block.blockname())
                .created_at(temporalValueFactory.create_datetimestamp())
                .token(tokenService.createTokenFor(temporalValueFactory.create_datetimestamp(),block.name()))
                .size(block.size())
                .name(block.name())
                .blockDurability(block.blockDurability())
                .build();
        blockRepository.insert(blockInstance);
        log.info("createInstanceByMutateCommand {} block", block);
        return blockInstance;
    }

    
}
