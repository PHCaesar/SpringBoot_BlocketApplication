package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameUser is a Querydsl query type for GameUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameUser extends EntityPathBase<GameUser> {

    private static final long serialVersionUID = 776962495L;

    public static final QGameUser gameUser = new QGameUser("gameUser");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Surname, QSurname> surnames = this.<Surname, QSurname>createList("surnames", Surname.class, QSurname.class, PathInits.DIRECT2);

    public final StringPath token = createString("token");

    public final StringPath username = createString("username");

    public QGameUser(String variable) {
        super(GameUser.class, forVariable(variable));
    }

    public QGameUser(Path<? extends GameUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameUser(PathMetadata metadata) {
        super(GameUser.class, metadata);
    }

}

