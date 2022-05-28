package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api;


import _21224bhifPos1CsesiereiBlocketWiki.Services.NonPlayerCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(NonPlayerCharacterController.BASE_URL)
public class NonPlayerCharacterController {

    public static final String BASE_URL = "api/nonplayercharacter";

    public final NonPlayerCharacterService nonPlayerCharacterService;
}
