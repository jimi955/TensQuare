package com.tensquare.qa.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 * @author Pl
 *
 */
@Data
@Entity
@Table(name="tb_pl")
public class Pl implements Serializable {
    @Id
    private String problemid;
            
    @Id 
    private String labelid;
}
