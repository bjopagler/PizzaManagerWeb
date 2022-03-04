
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    
    private String pizzaName;
    private String size;

    public Pizza() {
    }

    public Pizza(String pizzaName, String size) {
        this.pizzaName = pizzaName;
        this.size = size;
    }

    public Pizza(int id, String pizzaName, String size) {
        this.id = id;
        this.pizzaName = pizzaName;
        this.size = size;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
}
