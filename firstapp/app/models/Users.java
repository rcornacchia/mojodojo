package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Users extends Model {
    
    @Id
    public Long uid;
    
    
    public String username;
    public String password;
    public String email;
    public int votes;
    
    
}
