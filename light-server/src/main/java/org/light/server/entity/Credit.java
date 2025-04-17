package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;


/**
 * 信用表 实体类。
 *
 * @author 63443
 * @since 2025-04-17
 */
@Table("credit")
public class Credit extends Model<Credit> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long userId;

    private Integer score;

    public static Credit create() {
        return new Credit();
    }

    public Long getId() {
        return id;
    }

    public Credit setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Credit setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Credit setScore(Integer score) {
        this.score = score;
        return this;
    }

}
