/**
 * Yona, 21st Century Project Hosting SW
 * <p>
 * Copyright Yona & Yobi Authors & NAVER Corp.
 * https://yona.io
 **/
package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import controllers.DevFarm;
import models.enumeration.DfGroupState;
import models.enumeration.UserState;
import org.apache.commons.lang3.StringUtils;
import play.data.format.Formats;
import play.db.ebean.Model;
import utils.JodaDateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DfGroup extends Model {
    private static final long serialVersionUID = 1L;

    public static final Finder<Long, DfGroup> find = new Finder<>(Long.class, DfGroup.class);

    public static final int COUNT_PER_PAGE = 30;

    @Id
    public Long id;

    @ManyToOne
    public DfGroup currentGroup;

    @ManyToOne
    public Project project;

    @Enumerated(EnumType.STRING)
    public DfGroupState stateCode;

    public String name;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public Date startDate;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public Date endDate;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public Date createDatetime;

}
