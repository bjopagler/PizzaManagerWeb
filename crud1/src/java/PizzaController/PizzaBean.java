package PizzaController;

import Model.Pizza;
import dao.PizzaDaoInterface;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "pizzaBean")
@RequestScoped
public class PizzaBean {

    private int id;
    private String pizzaName;
    private String size;
    
    private List<Integer> ids;
    private List<Pizza> pizzas;

    @Inject
    private PizzaDaoInterface dao;

    @PostConstruct
    public void getAllPizzas() {
        pizzas = dao.getAllPizzas();
        ids = pizzas.stream().map(p -> p.getId()).collect(toList());
    }

    public PizzaBean() {
    }
    
    public String findPizza(){
        Pizza p = dao.getPizza(id);
        id = p.getId();
        pizzaName = p.getPizzaName();
        size = p.getSize();
        
        return "showOneOrder.xhtml";
    }

    public String submitOrder() {
        dao.addPizza(new Pizza(pizzaName, size));
        getAllPizzas();
        
        return "index.xhtml?faces-redirect=true";
    }

    public String updatePizza(int id) {
        Pizza p = dao.getPizza(id);
        this.id = p.getId();
        this.pizzaName = p.getPizzaName();
        this.size = p.getSize();

        return "updatePage.xhtml";
    }

    public String update() {
        Pizza p = new Pizza(id, pizzaName, size);
        dao.updatePizza(p);
        getAllPizzas();

        return "index.xhtml?faces-redirect=true";
    }

    public String removePizza(int id) {
        dao.deletePizza(id);
        getAllPizzas();

        return "index.xhtml?faces-redirect=true";
    }
    
    public String removePizza2() {
        dao.deletePizza(id);
        getAllPizzas();

        return "index.xhtml?faces-redirect=true";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PizzaDaoInterface getDao() {
        return dao;
    }

    public void setDao(PizzaDaoInterface dao) {
        this.dao = dao;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
