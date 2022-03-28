package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller;


import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.MobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.UserService;
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
    public HttpEntity<Mob> getMobsByNames(@PathVariable String firstname, String name){ //Param muss String sein
        Mob mob = mobService.getMobByName(MobDto.builder().name(name).build());
        return ResponseEntity.ok(mob);
    }

    @PostMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<Mob> postBlocks(@RequestBody MutateMobCommand mutateMobCommand){
        return ResponseEntity.ok(mobService.insertMob(
                MobDto.builder()
                        .name(mutateMobCommand.getName())
                        .type(mutateMobCommand.getType())
                        .created_at(temporalValueFactory.create_timestamp())
                        .token(tokenService.createTokenFor(temporalValueFactory.create_timestamp(),mutateMobCommand.getName()))
                        .build()));
    }
}
