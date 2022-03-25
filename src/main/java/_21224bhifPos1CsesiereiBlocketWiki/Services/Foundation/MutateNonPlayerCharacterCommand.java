package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;

import javax.persistence.OneToMany;
import java.util.List;

public class MutateNonPlayerCharacterCommand {
    public String name;
    public float health;
    public List<UsableItem> shopItems;
}
