package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "homeworkj2ee", catalog = "")
public class UserEntity {
    private int iduser;
    private String userpwd;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "userpwd")
    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return iduser == that.iduser &&
                Objects.equals(userpwd, that.userpwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, userpwd);
    }
}
