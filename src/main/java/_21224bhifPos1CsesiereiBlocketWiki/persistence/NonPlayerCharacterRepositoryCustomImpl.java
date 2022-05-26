package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor

@Component
public class NonPlayerCharacterRepositoryCustomImpl implements  NonPlayerCharacterRepositoryCustom{

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(NonPlayerCharacter nonPlayerCharacter) {
        entityManager.persist(nonPlayerCharacter);
        entityManager.flush();
    }

    public NonPlayerCharacter findByName(String name) {
        Query query = entityManager.createQuery("SELECT id FROM NonPlayerCharacter WHERE name = :name");
        query.setParameter("name", name);

        return entityManager.find(NonPlayerCharacter.class, query.getSingleResult());
    }

    @Override
    public List<NonPlayerCharacter> findByShopItemsNotNull() {
        Query query = entityManager.createQuery("SELECT NonPlayerCharacter.id FROM NonPlayerCharacter WHERE NonPlayerCharacter.shopItems is not empty ");

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(NonPlayerCharacter.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<NonPlayerCharacter> findByHealth(float health) {
        Query query = entityManager.createQuery("SELECT id FROM NonPlayerCharacter WHERE health = :health");
        query.setParameter("health", health);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(NonPlayerCharacter.class,x)).collect(Collectors.toList());
    }

    @Override
    public NonPlayerCharacter findByMutateCommand(MutateNonPlayerCharacterCommand mutateNonPlayerCharacterCommand) {
        Query query = entityManager.createQuery("SELECT id FROM NonPlayerCharacter WHERE name = :name and health = :health");
        query.setParameter("name", mutateNonPlayerCharacterCommand.getName());
        query.setParameter("health", mutateNonPlayerCharacterCommand.getHealth());

        return entityManager.find(NonPlayerCharacter.class, query.getSingleResult());
    }
}
