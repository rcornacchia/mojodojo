package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Users extends Model {
    
    @Id
    public Long id;
    
    
    public String username;
    
    
    
}