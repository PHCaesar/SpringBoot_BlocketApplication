package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor

@Component
public class MobRepositoryCustomImpl implements MobRepositoryCustom{

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Mob mob) {
        entityManager.persist(mob);
        try{
            mob.getDrops().stream().forEach((current)->entityManager.persist(current));
        } catch (Exception e){}
        entityManager.flush();
    }

    @Override
    public Mob findByName(String name) {
        Query query = entityManager.createQuery("SELECT id FROM Mob WHERE name = :name");
        query.setParameter("name", name);

        return entityManager.find(Mob.class, query.getSingleResult());
    }

    @Override
    public List<Mob> findByDrops(List<UsableItem> drops) {
        //QMob mob = QMob.mob;
        //QUsableItem usableItem = QUsableItem.usableItem;
        //JPAQuery query = new JPAQuery(entityManager);
        //JPAQueryBase jb = query.from(mob).innerJoin(usableItem);
        //jb.where(drops.)
        //List<Mob> mobs = ;
        
        Query query = entityManager.createQuery("SELECT id FROM Mob WHERE drops = :drops ");
        query.setParameter("drops", drops);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Mob.class,x)).collect(Collectors.toList());
    }

    @Override
    public Mob findByDTO(MobDto mutateMobCommand) {
        Query sqlQuery = entityManager.createQuery("SELECT id FROM Mob WHERE name = :name AND type = :type");
        sqlQuery.setParameter("type", mutateMobCommand.type());
        sqlQuery.setParameter("name", mutateMobCommand.name());

        return entityManager.find(Mob.class, sqlQuery.getSingleResult());
    }

    @Override
    public List<Mob> findByType(MobType type) {
        Query query = entityManager.createQuery("SELECT id FROM Mob WHERE type = :type",Long.class);
        query.setParameter("type", type);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Mob.class,x)).collect(Collectors.toList());
    }
}
