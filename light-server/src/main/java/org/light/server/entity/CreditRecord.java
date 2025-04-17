package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 * 信用变更记录 实体类。
 *
 * @author 63443
 * @since 2025-04-17
 */
@Table("credit_record")
public class CreditRecord extends Model<CreditRecord> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long userId;

    private Integer score;

    private String rmks;

    private LocalDateTime createTime;

    public static CreditRecord create() {
        return new CreditRecord();
    }

    public Long getId() {
        return id;
    }

    public CreditRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public CreditRecord setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public CreditRecord setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getRmks() {
        return rmks;
    }

    public CreditRecord setRmks(String rmks) {
        this.rmks = rmks;
        return this;
    }

    public LocalDateTime  getCreateTime() {
        return createTime;
    }

    public CreditRecord setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

}
