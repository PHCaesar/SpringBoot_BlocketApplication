package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.persistence.SurnameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SurnameService {

    public final SurnameRepository surnameRepository;


}
