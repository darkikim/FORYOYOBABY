package poei.orsys2.paiement.entities;
import javax.persistence.*;

@Entity
@Table
public class Payment {
    @Id
    private long id;
    private long command_id;
    private double price;
    private long cardNumber;

    public Payment(){}

    public Payment(double price, long command_id, long cardNumber) {
        this.price = price;
        this.command_id = command_id;
        this.cardNumber = cardNumber;
    }

    public long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(long command_id) {
        this.command_id = command_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCard() {
        return cardNumber;
    }

    public void setCard(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
