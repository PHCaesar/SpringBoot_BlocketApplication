package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api;


import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.MobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(MobController.BASE_URL)
public class MobController {
    private final MobService mobService;

    @Autowired
    private TemporalValueFactory temporalValueFactory;
    @Autowired
    private TokenService tokenService;

    public static final String BASE_URL = "api/mob";
    public static final String PATH_VAR_DURABILITY ="/{durability}";

    @GetMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<List<Mob>> getMobs(){
        List<Mob> mobs = mobService.getAllMobs(); //Should be be using DTOS while returning MutateCommands to the Service
        return ResponseEntity.ok(mobs);

    }

    @GetMapping({"",PATH_VAR_DURABILITY})
    public HttpEntity<Mob> getMobsByNames(@PathVariable String name){ //Param muss String sein
        Mob mob = mobService.getMobByName(name);
        return ResponseEntity.ok(mob);
    }

    @PostMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<Mob> postBlocks(@RequestBody MutateMobCommand mutateMobCommand){
        return ResponseEntity.ok(mobService.insertMob(
                new MobDto("",mutateMobCommand.getName(), mutateMobCommand.getDrops(), mutateMobCommand.getType(),null, "")));
    }
}
