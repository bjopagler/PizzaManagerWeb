
package dao;

import Model.Pizza;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PizzaDaoInterface {

    public void addPizza(Pizza p);
    public void deletePizza(int id);
    public List<Pizza> getAllPizzas();
    public void updatePizza(Pizza p);
    public Pizza getPizza(int id);
}
