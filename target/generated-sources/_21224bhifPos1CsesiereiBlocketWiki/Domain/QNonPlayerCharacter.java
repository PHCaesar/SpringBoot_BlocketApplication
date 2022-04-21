package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNonPlayerCharacter is a Querydsl query type for NonPlayerCharacter
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNonPlayerCharacter extends EntityPathBase<NonPlayerCharacter> {

    private static final long serialVersionUID = -1518742755L;

    public static final QNonPlayerCharacter nonPlayerCharacter = new QNonPlayerCharacter("nonPlayerCharacter");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final NumberPath<Float> health = createNumber("health", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<UsableItem, QUsableItem> shopItems = this.<UsableItem, QUsableItem>createList("shopItems", UsableItem.class, QUsableItem.class, PathInits.DIRECT2);

    public final StringPath token = createString("token");

    public QNonPlayerCharacter(String variable) {
        super(NonPlayerCharacter.class, forVariable(variable));
    }

    public QNonPlayerCharacter(Path<? extends NonPlayerCharacter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNonPlayerCharacter(PathMetadata metadata) {
        super(NonPlayerCharacter.class, metadata);
    }

}

