package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWeapon is a Querydsl query type for Weapon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWeapon extends EntityPathBase<Weapon> {

    private static final long serialVersionUID = 1861103998L;

    public static final QWeapon weapon = new QWeapon("weapon");

    // custom
    public final QWeaponClass classification = new QWeaponClass(forProperty("classification"));

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final NumberPath<Integer> damage = createNumber("damage", Integer.class);

    public final StringPath description = createString("description");

    public final StringPath token = createString("token");

    public QWeapon(String variable) {
        super(Weapon.class, forVariable(variable));
    }

    public QWeapon(Path<? extends Weapon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWeapon(PathMetadata metadata) {
        super(Weapon.class, metadata);
    }

}

