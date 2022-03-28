package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(GameContentController.BASE_URL)
public class GameContentController {

    public static final String BASE_URL = "/gamecontent";
}
