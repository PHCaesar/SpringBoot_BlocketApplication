package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class BlockService {
    // Parameterized Exception output

    private final BlockRepository blockRepository;

    // GET
    public Block getBlock(MutateBlockCommand block){
        checkParameterInput(block);

        var realBlock = blockRepository.findByName(block.name);
        return realBlock;
    }

    // CRUD

    // CREATE
    public Block insertBlock(MutateBlockCommand block){
        checkParameterInput(block);
        if(blockRepository.findByName(block.name)==null){
            Block blockInstance = createInstanceByMutateCommand(block);
            blockRepository.insert(blockInstance);
            return blockInstance;
        } else throw new IllegalArgumentException("Block "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public Block updateBlock(MutateBlockCommand block){
        checkParameterInput(block);

        if(blockRepository.findByName(block.name)!=null){
            Block blockInstance = createInstanceByMutateCommand(block);
            blockRepository.insert(blockInstance);
            return blockInstance;
        } else throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteBlock(MutateBlockCommand block){
        checkParameterInput(block);

        if(blockRepository.findByName(block.name)!=null)
            blockRepository.delete(blockRepository.findByName(block.name));
        else throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public void checkParameterInput(MutateBlockCommand block){
        if(block.name.isEmpty())
            throw new IllegalArgumentException("Name "+UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if(block.size==0)
            throw new IllegalArgumentException("Size "+UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public Block createInstanceByMutateCommand(MutateBlockCommand block){
        Block blockInstance = new Block();
        blockInstance.setName(block.name);
        blockInstance.setBlockDurability(block.blockDurability);
        blockInstance.setSize(block.size);
        return blockInstance;
    }

    
}
