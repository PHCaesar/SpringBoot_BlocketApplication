package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.GameContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(GameContentController.BASE_URL)
public class GameContentController {

    public static final String BASE_URL = "api/gamecontent";

    public final GameContentService gameContentService;

}
