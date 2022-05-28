package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.MobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.UserService;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(MobViewController.BASE_URL)
public class MobViewController {

    private final MobService mobService;

    public static final String BASE_URL = "Mob";

    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showAllMobs(Model model){
        prepareModel(model);
        return "/Mob/index";
    }

    @PostMapping({"/createMob",UniversalPathVariables.PATH_INDEX})
    public String createMob(@PathVariable MutateMobCommand mob,Model model){
        mobService.insertMob(new MobDto("",mob.getName(),mob.getDrops(),mob.getType(),null,""));

        prepareModel(model);
        return "/Mob/index";
    }

    @PostMapping({"/update",UniversalPathVariables.PATH_INDEX})
    public String updateMob(@PathVariable MutateMobCommand mob,Model model){
        mobService.updateMob(new MobDto("",mob.getName(),mob.getDrops(),mob.getType(),null,""));

        prepareModel(model);
        return "/Mob/index";
    }

    public void prepareModel(Model model){
        List<Mob> mobs =mobService.getAllMobs();
        if(mobs.size()==0)
            model.addAttribute("noInput","There are no current Blocks!\nAdd Blocks to the Database!");
        model.addAttribute("mobs",mobs);
        model.addAttribute("mob",MutateMobCommand.builder().build());

        model.addAttribute("aggressive", MobType.AGGRESSIVE);
        model.addAttribute("friendly", MobType.FRIENDLY);
        model.addAttribute("passive", MobType.PASSIVE);
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "/Mob/error";
    }
}
