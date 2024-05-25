package entity;

import card.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import gameobject.GameObject;
import gamestatus.GameStatus;
import petakladang.KartuLadang;
import player.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class saveloadXML implements Entity {
    private GameStatus gameStatus;

    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }

    public void savePlayer(Player player, String filename) throws IOException {
        String path = "src/main/resources/" + filename;
        XmlMapper mapper = new XmlMapper();

        Map<String, Object> data = new HashMap<>();
        data.put("gulden", player.getGulden());

        Map<String, Object> deck = new HashMap<>();
        deck.put("pasifSize", player.getDeck().getPasifSize());
        deck.put("aktifSize", player.getDeck().getAktifSize());

        List<Map<String, String>> aktifElements = new ArrayList<>();
        for (int i = 0; i < player.getDeck().getAktifSize(); i++) {
            Map<String, String> aktifElement = new HashMap<>();
            aktifElement.put("position", player.getDeck().getAktifElement(i).getPosition());
            aktifElement.put("name", player.getDeck().getAktifElement(i).getName());
            aktifElements.add(aktifElement);
        }
        deck.put("aktifElements", aktifElements);
        data.put("deck", deck);

        Map<String, Object> petakLadang = new HashMap<>();
        petakLadang.put("nEff", player.getPetakLadang().getNEff());

        List<Map<String, Object>> petakLadangElements = new ArrayList<>();
        for (List<KartuLadang> row : player.getPetakLadang().getPetakLadang()) {
            for (KartuLadang elm : row) {
                if (elm != null) {
                    Map<String, Object> element = new HashMap<>();
                    element.put("position", elm.getKartu().getPosition());
                    element.put("name", elm.getKartu().getName());

                    Map<String, Object> attributes = new HashMap<>();
                    if (elm.getKartu() instanceof Hewan) {
                        attributes.put("type", "Hewan");
                        attributes.put("berat", ((Hewan) elm.getKartu()).getBerat());
                    } else {
                        attributes.put("type", "Tanaman");
                        attributes.put("umur", ((Tanaman) elm.getKartu()).getUmur());
                    }
                    element.put("attributes", attributes);

                    List<String> items = new ArrayList<>();
                    for (int k = 0; k < elm.getItems().size(); k++) {
                        items.add(elm.getElementItem(k).getName());
                    }
                    element.put("items", items);

                    petakLadangElements.add(element);
                }
            }
        }
        petakLadang.put("petakLadangElements", petakLadangElements);
        data.put("petakLadang", petakLadang);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
    }

    public void loadPlayer(Player player, String filename) throws IOException {
        XmlMapper mapper = new XmlMapper();
        String path = "src/main/resources/" + filename;
        // Membaca file XML
        JsonNode rootNode = mapper.readTree(new File(path));

        // Membaca gulden
        int gulden = rootNode.path("gulden").asInt();
        player.setGulden(gulden);

        // Membaca deck
        JsonNode deckNode = rootNode.path("deck");
        int pasifSize = deckNode.path("pasifSize").asInt();
        player.getDeck().insertPassiveDeck(pasifSize);

        int aktifSize = deckNode.path("aktifSize").asInt();
        JsonNode aktifElementsNode = deckNode.path("aktifElements");

        for (Iterator<JsonNode> it = aktifElementsNode.elements(); it.hasNext(); ) {
            JsonNode aktifElement = it.next();
            String position = aktifElement.path("position").asText();
            String name = aktifElement.path("name").asText();

            // Menambahkan kartu deck aktif
            if (player.isIn(GameObject.hewanList, name)) {
                for (Hewan hewan : GameObject.hewanList) {
                    if (hewan.getName().equals(name)) {
                        player.getDeck().addAktifElement(new Hewan(hewan), Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                    }
                }
            } else if (player.isIn(GameObject.tanamanList, name)) {
                for (Tanaman tanaman : GameObject.tanamanList) {
                    if (tanaman.getName().equals(name)) {
                        player.getDeck().addAktifElement(new Tanaman(tanaman), Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                    }
                }
            } else if (player.isIn(GameObject.produkList, name)) {
                for (Produk produk : GameObject.produkList) {
                    if (produk.getName().equals(name)) {
                        player.getDeck().addAktifElement(new Produk(produk), Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                    }
                }
            } else if (player.isIn(GameObject.itemList, name)) {
                for (Item item : GameObject.itemList) {
                    if (item.getName().equals(name)) {
                        player.getDeck().addAktifElement(new Item(item), Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                    }
                }
            }
        }

        // Membaca petak ladang
        JsonNode petakLadangNode = rootNode.path("petakLadang");
        int nEff = petakLadangNode.path("nEff").asInt();

        JsonNode petakLadangElementsNode = petakLadangNode.path("petakLadangElements");

        for (Iterator<JsonNode> it = petakLadangElementsNode.elements(); it.hasNext(); ) {
            JsonNode petakLadangElement = it.next();
            String position = petakLadangElement.path("position").asText();
            String name = petakLadangElement.path("name").asText();
            JsonNode attributesNode = petakLadangElement.path("attributes");
            String type = attributesNode.path("type").asText();

            KartuLadang kartuLadang = null;

            if ("Hewan".equals(type)) {
                int berat = attributesNode.path("berat").asInt();
                for (Hewan hewan : GameObject.hewanList) {
                    if (hewan.getName().equals(name)) {
                        Hewan hewanNew = new Hewan(hewan);
                        hewanNew.setBerat(berat);
                        hewanNew.setPosition(Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                        kartuLadang = new KartuLadang<>(hewanNew);
                    }
                }
            } else if ("Tanaman".equals(type)) {
                int umur = attributesNode.path("umur").asInt();
                for (Tanaman tanaman : GameObject.tanamanList) {
                    if (tanaman.getName().equals(name)) {
                        Tanaman tanamanNew = new Tanaman(tanaman);
                        tanamanNew.setUmur(umur);
                        tanamanNew.setPosition(Card.convertStringtoRow(position), Card.convertStringtoCol(position));
                        kartuLadang = new KartuLadang<>(tanamanNew);
                    }
                }
            }

            if (kartuLadang != null) {
                JsonNode itemsNode = petakLadangElement.path("items");
                for (Iterator<JsonNode> itemIt = itemsNode.elements(); itemIt.hasNext(); ) {
                    String itemName = itemIt.next().asText();
                    for (Item item : GameObject.itemList) {
                        if (item.getName().equals(itemName)) {
                            kartuLadang.addItems(new Item(item));
                        }
                    }
                }

                player.getPetakLadang().addElement(kartuLadang, Card.convertStringtoRow(position), Card.convertStringtoCol(position));
            }
        }
    }

    public void saveToko(String filename) throws IOException {
        XmlMapper mapper = new XmlMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        // Menambahkan turn
        rootNode.put("turn", GameStatus.turn);

        // Menambahkan stok
        ObjectNode stokNode = rootNode.putObject("stok");
        for (Map.Entry<String, Integer> entry : gameStatus.getObjek().geToko().getMapStok().entrySet()) {
            stokNode.put(entry.getKey(), entry.getValue());
        }

        // Menulis ke file
        String path = "src/main/resources/" + filename;
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), rootNode);
    }

    public void loadToko(String path) throws IOException {
        // Bersihkan stok saat ini
        gameStatus.getObjek().geToko().getMapStok().clear();

        // Membaca file XML
        XmlMapper mapper = new XmlMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + path);
        }

        JsonNode rootNode = mapper.readTree(inputStream);

        // Parse current turn
        GameStatus.turn = rootNode.path("turn").asInt();

        // Parse stok toko
        JsonNode stokNode = rootNode.path("stok");
        Iterator<Map.Entry<String, JsonNode>> fields = stokNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String itemName = field.getKey();
            int quantity = field.getValue().asInt();
            gameStatus.getObjek().geToko().addStok(itemName, quantity);
        }

        inputStream.close();
    }

    @Override
    public void save(String folder) throws IOException {
        Path path = Paths.get("src/main/resources/" + folder);

        try {
            Files.createDirectories(path);
            System.out.println("Directory created successfully.");
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }

        this.savePlayer(gameStatus.getObjek().getPlayer1(), folder+ "/player1.xml");
        this.savePlayer(gameStatus.getObjek().getPlayer2(),folder + "/player2.xml");
        this.saveToko(folder + "/gamestate.xml");
    }

    @Override
    public void load(String folder) throws IOException {
        if (folder.length() != 0) {
            this.loadPlayer(gameStatus.getObjek().getPlayer1(),folder + "/player1.xml");
            this.loadPlayer(gameStatus.getObjek().getPlayer2(),folder + "/player2.xml");
            this.loadToko(folder + "/gamestate.xml");
        }
    }
}
