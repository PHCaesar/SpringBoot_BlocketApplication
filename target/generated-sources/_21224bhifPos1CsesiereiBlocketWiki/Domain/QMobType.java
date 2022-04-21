package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMobType is a Querydsl query type for MobType
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMobType extends EnumPath<MobType> {

    private static final long serialVersionUID = 1860937528L;

    public static final QMobType mobType = new QMobType("mobType");

    public QMobType(String variable) {
        super(MobType.class, forVariable(variable));
    }

    public QMobType(Path<MobType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMobType(PathMetadata metadata) {
        super(MobType.class, metadata);
    }

}

