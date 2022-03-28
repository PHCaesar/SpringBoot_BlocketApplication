package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller;


import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(NonPlayerCharacterController.BASE_URL)
public class NonPlayerCharacterController {
    public static final String BASE_URL = "/nonplayercharacter";
}
