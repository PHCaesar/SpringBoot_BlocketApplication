package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsableItem is a Querydsl query type for UsableItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsableItem extends EntityPathBase<UsableItem> {

    private static final long serialVersionUID = 1249298061L;

    public static final QUsableItem usableItem = new QUsableItem("usableItem");

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final StringPath token = createString("token");

    public QUsableItem(String variable) {
        super(UsableItem.class, forVariable(variable));
    }

    public QUsableItem(Path<? extends UsableItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsableItem(PathMetadata metadata) {
        super(UsableItem.class, metadata);
    }

}

