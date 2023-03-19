package gridList;

import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.util.Resources;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.plaf.Border;
import entity.Game;
import java.io.IOException;

public class GameDetails extends Form {

    private Button acheterBtn;
    private SpanLabel description;
    private Label price;

    public GameDetails(Resources theme, Game game) {
        super(new BorderLayout());

        // Create UI components
        //Button Login
        acheterBtn = new Button("Acheter");

        acheterBtn.getAllStyles().setBorder(Border.createEmpty());
        acheterBtn.getAllStyles().setBgTransparency(255);
        acheterBtn.getAllStyles().setBgColor(0x2196F3);
        acheterBtn.getAllStyles().setFgColor(0xFFFFFF);
        acheterBtn.getAllStyles().setMargin(10, 10, 200, 200);
        try {
            acheterBtn.setIcon(Image.createImage("/bag.png"));

        } catch (IOException ex) {
            System.out.println("err" + ex.getMessage());

        }

        //Creation de Form
        Form form = new Form(game.getName(), new BorderLayout());
        form.getToolbar().addCommandToLeftBar("", theme.getImage("icons8-back-arrow-90.png"), (e) -> new GamesList(theme).showBack());

        // Create the ImageView component with the image
        ImageViewer imageView;
        try {
            imageView = new ImageViewer(Image.createImage(game.getImg()));
            //changer la taille de l'image
            imageView.setPreferredH(600);
            imageView.setPreferredW(200);
            form.add(BorderLayout.CENTER, imageView);

        } catch (IOException ex) {
            System.out.println("err" + ex.getMessage());
        }

        //create a SpanButton
        description = new SpanLabel(game.getDescription());
        description.getAllStyles().setAlignment(Component.CENTER);

        price = new Label(game.getPrice() + " TND");
        price.setAlignment(Component.CENTER);
        // Add components to form
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        centerContainer.add(form);
        centerContainer.add(description);
        centerContainer.add(price);

        centerContainer.add(acheterBtn);

        add(BorderLayout.CENTER, centerContainer);

        // Set login button action
        acheterBtn.addActionListener(e -> {

            Dialog.show("Validation Error", "Vérifier le champs Email ", "OK", null);

        });

        // Set Inscrit button action
        //  InscritButton.addActionListener(e -> new InscritForm(theme).show());
    }
}
