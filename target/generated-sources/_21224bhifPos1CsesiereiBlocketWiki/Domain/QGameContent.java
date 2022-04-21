package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameContent is a Querydsl query type for GameContent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameContent extends EntityPathBase<GameContent> {

    private static final long serialVersionUID = 2009688581L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameContent gameContent = new QGameContent("gameContent");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final ListPath<Block, QBlock> blocksInGame = this.<Block, QBlock>createList("blocksInGame", Block.class, QBlock.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<UsableItem, QUsableItem> itemsInGame = this.<UsableItem, QUsableItem>createList("itemsInGame", UsableItem.class, QUsableItem.class, PathInits.DIRECT2);

    public final QGameUser loggedInGameUser;

    public final ListPath<Mob, QMob> mobsInGame = this.<Mob, QMob>createList("mobsInGame", Mob.class, QMob.class, PathInits.DIRECT2);

    public final ListPath<NonPlayerCharacter, QNonPlayerCharacter> nonPlayerCharactersInGame = this.<NonPlayerCharacter, QNonPlayerCharacter>createList("nonPlayerCharactersInGame", NonPlayerCharacter.class, QNonPlayerCharacter.class, PathInits.DIRECT2);

    public final StringPath token = createString("token");

    public final ListPath<Weapon, QWeapon> weaponsInGame = this.<Weapon, QWeapon>createList("weaponsInGame", Weapon.class, QWeapon.class, PathInits.DIRECT2);

    public QGameContent(String variable) {
        this(GameContent.class, forVariable(variable), INITS);
    }

    public QGameContent(Path<? extends GameContent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameContent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameContent(PathMetadata metadata, PathInits inits) {
        this(GameContent.class, metadata, inits);
    }

    public QGameContent(Class<? extends GameContent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.loggedInGameUser = inits.isInitialized("loggedInGameUser") ? new QGameUser(forProperty("loggedInGameUser")) : null;
    }

}

