package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller;


import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.BlockService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.TemporalValueFactory;
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
@RequestMapping(GameUserController.BASE_URL)
public class GameUserController {

    private final UserService userService;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    @Autowired
    private TokenService tokenService;

    public static final String BASE_URL = "/api/user";
    public static final String PATH_VAR_DURABILITY ="/{durability}";

    @GetMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<List<GameUser>> getUsers(){
        List<GameUser> blocks = userService.getAllUser(); //Should be be using DTOS while returning MutateCommands to the Service
        return ResponseEntity.ok(blocks);

    }

    @GetMapping({"",PATH_VAR_DURABILITY})
    public HttpEntity<GameUser> getUsersByNames(@PathVariable String firstname,String name){ //Param muss String sein
        GameUser users = userService.getUserByName(MutateUserCommand.builder().firstname(firstname).name(name).build());
        return ResponseEntity.ok(users);
    }

    @PostMapping({"",UniversalPathVariables.PATH_INDEX})
    public HttpEntity<GameUser> postBlocks(@RequestBody MutateUserCommand mutateUserCommand){
        return ResponseEntity.ok(userService.insertUser(
                MutateUserCommand.builder()
                        .name(mutateUserCommand.getName())
                        .firstname(mutateUserCommand.getFirstname())
                        .birthDate(mutateUserCommand.getBirthDate())
                        .username(mutateUserCommand.getUsername())
                        .created_at(temporalValueFactory.create_timestamp())
                        .token(tokenService.createTokenFor(temporalValueFactory.create_timestamp()
                                ,mutateUserCommand.getFirstname()
                                ,mutateUserCommand.getName()
                                ,mutateUserCommand.getUsername()
                        ))
                        .build()));
    }
}
