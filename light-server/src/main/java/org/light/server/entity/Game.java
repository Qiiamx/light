package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;


/**
 *  实体类。
 *
 * @author 63443
 * @since 2025-04-19
 */
@Table("game")
public class Game extends Model<Game> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;

    public static Game create() {
        return new Game();
    }

    public Long getId() {
        return id;
    }

    public Game setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Game setName(String name) {
        this.name = name;
        return this;
    }

}
