package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.GameContentService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.UserService;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(GameContentViewController.BASE_URL)
public class GameContentViewController {

    private final GameContentService gameContentService;

    public static final String BASE_URL = "GameContent";


    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showContent(Model model){
        //TODO : Implement GameContentService
        return "/GameContent/gameContent";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "/GameContent/error";
    }
}
