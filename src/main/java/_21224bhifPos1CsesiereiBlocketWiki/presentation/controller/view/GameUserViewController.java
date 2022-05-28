package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.BlockService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.UserService;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.BlockController;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.GameUserController;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(GameUserViewController.BASE_URL)
public class GameUserViewController {

    private final UserService userService;

    public static final String BASE_URL = "Login";


    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showLogin(Model model){
        List<GameUser> users = userService.getAllUser();
        model.addAttribute("user",MutateUserCommand.builder().build());
        model.addAttribute("users",users);
        return "/User/login";
    }

    @PostMapping({"/register",UniversalPathVariables.PATH_INDEX})
    public String postRegistration(@ModelAttribute MutateUserCommand userCommand,Model model){
        userService.insertUser(new GameUserDto("",null,new ArrayList<>(), userCommand.getFirstname(), userCommand.getName(),userCommand.getUsername(),userCommand.getBirthDate(),""));
        return "/User/login";
    }

    @GetMapping({"/register", UniversalPathVariables.PATH_INDEX})
    public String showRegister(Model model){
        List<GameUser> users = userService.getAllUser();
        model.addAttribute("user",MutateUserCommand.builder().build());
        model.addAttribute("users",users);
        return "/User/register";
    }

    @GetMapping({"/login",UniversalPathVariables.PATH_INDEX})
    public String logIn(@ModelAttribute MutateUserCommand userCommand,Model model){
            GameUser u =userService.getUserByName(new GameUserDto("",null,new ArrayList<>(), userCommand.getFirstname(), userCommand.getName(),userCommand.getUsername(),userCommand.getBirthDate(),""));

            if(u==null){
                //Throwback to login (NO User with username "name" found
                model.addAttribute("noInput","No User with username "+userCommand.getUsername()+" was found!");
                return "/User/login";
            }

            model.addAttribute("user",userCommand);
            //Redirect to the Main menu
            return "/GameContent/gameContent";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "/User/error";
    }
}
