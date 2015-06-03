package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stavros
 */
@Entity
@Table(name = "user_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroups.findAll", query = "SELECT u FROM UserGroups u"),
    @NamedQuery(name = "UserGroups.findByUsergroupsID", query = "SELECT u FROM UserGroups u WHERE u.usergroupsID = :usergroupsID"),
    @NamedQuery(name = "UserGroups.findByGroupName", query = "SELECT u FROM UserGroups u WHERE u.groupName = :groupName"),
    @NamedQuery(name = "UserGroups.findByUsername", query = "SELECT u FROM UserGroups u WHERE u.username = :username")})
public class UserGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)    
    @Column(name = "User_groupsID")
    private Integer usergroupsID;
    @Size(max = 50)
    @Column(name = "GroupName")
    private String groupName;
    @Size(max = 50)
    @Column(name = "Username")
    private String username;

    public UserGroups() {
    }

    public UserGroups(Integer usergroupsID) {
        this.usergroupsID = usergroupsID;
    }

    public Integer getUsergroupsID() {
        return usergroupsID;
    }

    public void setUsergroupsID(Integer usergroupsID) {
        this.usergroupsID = usergroupsID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
