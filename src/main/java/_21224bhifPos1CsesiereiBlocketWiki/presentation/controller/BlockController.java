package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller;

import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.BlockService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;

import java.util.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(BlockController.BASE_URL)
public class BlockController {

    private final BlockService blockService;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    @Autowired
    private TokenService tokenService;

    public static final String BASE_URL = "/api/block";
    public static final String PATH_VAR_DURABILITY ="/{durability}";

    @GetMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<List<Block>> getBlocks(){
        List<Block> blocks = blockService.getAllBlocks(); //Should be be using DTOS while returning MutateCommands to the Service
        return ResponseEntity.ok(blocks);

    }

    @GetMapping({"",PATH_VAR_DURABILITY})
    public HttpEntity<List<Block>> getBlocksByDurability(@PathVariable int durability){ //Param muss String sein
        List<Block> blocks = blockService.getBlocksByDurability(durability);//Should be be using DTOS while returning MutateCommands to the Service
        return ResponseEntity.ok(blocks);
    }

    @PostMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<Block> postBlocks(@RequestBody BlockDto blockDto){
        return ResponseEntity.ok(blockService.insertBlock(blockDto));
    }
}
