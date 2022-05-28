package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.view;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.WeaponDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateWeaponCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.NonPlayerCharacterService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.WeaponService;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.UniversalPathVariables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(WeaponViewController.BASE_URL)
public class WeaponViewController {

    ///TODO - CRUD

    private final WeaponService weaponService;

    public static final String BASE_URL = "Weapon";

    @GetMapping({"", UniversalPathVariables.PATH_INDEX})
    public String showWeapons(Model model){
        List<Weapon> weapons =weaponService.getAll();
        model.addAttribute("weapons",weapons);
        model.addAttribute("weapon", MutateWeaponCommand.builder().build());
        return "/Weapon/index";
    }

    @PostMapping({"/update", UniversalPathVariables.PATH_INDEX})
    public String updateWeapon(@ModelAttribute MutateWeaponCommand weapon, Model model){
        weaponService.updateWeapon(new WeaponDto("",weapon.getDescription() , weapon.getDamage(), weapon.getClassification(),weapon.getName(),weapon.getSize(),null,""));

        List<Weapon> weapons =weaponService.getAll();
        model.addAttribute("weapons",weapons);
        model.addAttribute("weapon", MutateWeaponCommand.builder().build());
        return "/Weapon/index";
    }

    @PostMapping({"/insert",UniversalPathVariables.PATH_INDEX})
    public String insertWeapon(@ModelAttribute MutateWeaponCommand weapon,Model model){
        weaponService.insertWeapon(new WeaponDto("",weapon.getDescription(),weapon.getDamage(),weapon.getClassification(),weapon.getName(),weapon.getSize(),null,""));

        List<Weapon> weapons =weaponService.getAll();
        model.addAttribute("weapons",weapons);
        model.addAttribute("weapon", MutateWeaponCommand.builder().build());
        return "/Weapon/index";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGeneralErrors(Throwable t , Model model){
        model.addAttribute("error",t.getMessage());
        return "/Weapon/error";
    }

}
