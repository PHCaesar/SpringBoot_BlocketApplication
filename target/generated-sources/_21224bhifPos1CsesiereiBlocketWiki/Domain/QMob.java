package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMob is a Querydsl query type for Mob
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMob extends EntityPathBase<Mob> {

    private static final long serialVersionUID = 1585201886L;

    public static final QMob mob = new QMob("mob");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final ListPath<UsableItem, QUsableItem> drops = this.<UsableItem, QUsableItem>createList("drops", UsableItem.class, QUsableItem.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath token = createString("token");

    // custom
    public final QMobType type = new QMobType(forProperty("type"));

    public QMob(String variable) {
        super(Mob.class, forVariable(variable));
    }

    public QMob(Path<? extends Mob> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMob(PathMetadata metadata) {
        super(Mob.class, metadata);
    }

}

