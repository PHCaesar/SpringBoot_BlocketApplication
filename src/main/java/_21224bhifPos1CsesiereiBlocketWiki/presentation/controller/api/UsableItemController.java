package _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(UsableItemController.BASE_URL)
public class UsableItemController {
    public static final String BASE_URL = "/UsableItem";
}
