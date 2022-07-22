package poei.orsys2.produit.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Produit {


    @Id @GeneratedValue
    private int id;

    private String description;

    private String image;

    private double prix;

    private String titre;

    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Produit(String description, String image, double prix, String titre) {
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", prix=" + prix +
                ", titre='" + titre + '\'' +
                '}';
    }
}
