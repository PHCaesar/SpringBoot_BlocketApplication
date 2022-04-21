package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWeaponClass is a Querydsl query type for WeaponClass
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QWeaponClass extends EnumPath<WeaponClass> {

    private static final long serialVersionUID = 774751898L;

    public static final QWeaponClass weaponClass = new QWeaponClass("weaponClass");

    public QWeaponClass(String variable) {
        super(WeaponClass.class, forVariable(variable));
    }

    public QWeaponClass(Path<WeaponClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWeaponClass(PathMetadata metadata) {
        super(WeaponClass.class, metadata);
    }

}

