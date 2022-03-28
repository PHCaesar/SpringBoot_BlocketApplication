package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Services.WeaponService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class WeaponServiceTest {

    @Autowired
    private WeaponRepository weaponRepository;
    private WeaponService weaponService;
}
