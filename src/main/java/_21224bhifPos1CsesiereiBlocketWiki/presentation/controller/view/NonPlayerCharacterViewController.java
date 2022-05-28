package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.MobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.NonPlayerCharacterService;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import com.fasterxml.jackson.databind.annotation.NoClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(NonPlayerCharacterViewController.BASE_URL)
public class NonPlayerCharacterViewController {

    ///TODO - CRUD

    private final NonPlayerCharacterService nonPlayerCharacterService;

    public static final String BASE_URL = "NPC";

    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showNonPlayerCharacters(Model model){
        List<NonPlayerCharacter> nonPlayerCharacterList= nonPlayerCharacterService.getAllNonPlayerCharacters();
        model.addAttribute("NPCs",nonPlayerCharacterList);
        model.addAttribute("NPC", MutateNonPlayerCharacterCommand.builder().build());
        return "/NonPlayerCharacter/index";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "/NonPlayerCharacter/error";
    }

}
