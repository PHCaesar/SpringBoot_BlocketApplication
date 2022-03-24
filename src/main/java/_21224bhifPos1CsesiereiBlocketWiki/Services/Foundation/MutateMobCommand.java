package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

public class MutateMobCommand {

    public String name;
    public List<Item> drops;
    public MobType type;
}
