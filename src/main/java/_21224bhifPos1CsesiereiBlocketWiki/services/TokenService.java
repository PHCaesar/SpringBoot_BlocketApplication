package _21224bhifPos1CsesiereiBlocketWiki.Services;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class TokenService {
    private Hashids hashids;
    @Value("MySecretSalt")
    private String salt;
    private Collector<CharSequence , ? , String> joining = Collectors.joining("|","[","]");

    @PostConstruct
    private void initHash(){
        hashids = new Hashids(salt);
    }

    public String createTokenFor(LocalDateTime datetime , String... strings){
        return  createTokenFor(datetime , Arrays.stream(strings)
                .filter(s -> s != null)
                .collect(joining));
    }
    public String createTokenFor(LocalDateTime datetime , String string){
        Long tokensource = datetime.toEpochSecond(ZoneOffset.UTC)+string.hashCode();
        return hashids.encode(tokensource);
    }


}
