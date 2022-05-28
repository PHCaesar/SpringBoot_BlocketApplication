package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.BlockService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Controller
@RequestMapping(BlockViewController.BASE_URL)
public class BlockViewController {

    private final BlockService blockService;

    public static final String BASE_URL = "Block";
    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showBlocks(Model model){
        prepareModel(model);
        return "Block/index";
    }


    @PostMapping({"/createBlock", UniversalPathVariables.PATH_INDEX})
    public String postBlocks(@ModelAttribute MutateBlockCommand block, Model model){

        blockService.insertBlock(new BlockDto(block.getBlockDurability(),block.getName(),block.getSize(),block.getBlockName()));

        prepareModel(model);
        return "Block/index";
    }


    @PostMapping({"/update",UniversalPathVariables.PATH_INDEX})
    public String updateBlock(@ModelAttribute MutateBlockCommand block, Model model){
        blockService.updateBlock(new BlockDto(block.getBlockDurability(),block.getName(),block.getSize(),block.getBlockName()));

        prepareModel(model);
        return "Block/index";
    }

    @PostMapping({"/remove",UniversalPathVariables.PATH_INDEX})
    public String removeBlock(@ModelAttribute MutateBlockCommand block, Model model){
        blockService.deleteBlock(new BlockDto(block.getBlockDurability(),block.getName(),block.getSize(),block.getBlockName()));

        prepareModel(model);
        return "Block/index";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "Block/error";
    }

    public void prepareModel(Model model){

        List<Block> blocks = blockService.getAllBlocks();
        if(blocks.size()>0)
            model.addAttribute("blocks",blocks);
        else
            model.addAttribute("noInput","The List is Empty please add new Entries");
        model.addAttribute("block",MutateBlockCommand.builder().build());

    }
}
