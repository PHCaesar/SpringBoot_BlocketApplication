package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSurname is a Querydsl query type for Surname
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSurname extends EntityPathBase<Surname> {

    private static final long serialVersionUID = -1216672327L;

    public static final QSurname surname = new QSurname("surname");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath token = createString("token");

    public QSurname(String variable) {
        super(Surname.class, forVariable(variable));
    }

    public QSurname(Path<? extends Surname> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurname(PathMetadata metadata) {
        super(Surname.class, metadata);
    }

}

