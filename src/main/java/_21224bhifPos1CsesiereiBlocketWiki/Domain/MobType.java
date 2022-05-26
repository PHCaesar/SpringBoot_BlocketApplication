package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import com.querydsl.core.annotations.QueryEmbeddable;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Mobtypes for further Mob specification
 */


public enum MobType {
    FRIENDLY,
    AGGRESSIVE,
    PASSIVE
}
