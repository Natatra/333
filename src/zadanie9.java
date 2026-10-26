import org.json.JSONArray;
import org.json.JSONObject;

public class zadanie9 {
    public static void main(String[] args) throws Exception {
        // 1. Pobranie danych ze Steam API i wyciągnięcie tablicy specials.items
        JSONObject dane = Api.pobierz("https://store.steampowered.com/api/featuredcategories/?cc=pl&l=polish");
        JSONArray gry = dane.getJSONObject("specials").getJSONArray("items");

        // 2. Deklaracja zmiennej minimalnego rabatu (na start 50, potem zmień na 75)
        int minimalnyRabat = 50;

        // 3. Pętla for przechodząca po wszystkich elementach tablicy gry
        for (int i = 0; i < gry.length(); i++) {
            JSONObject gra = gry.getJSONObject(i);
            int rabat = gra.getInt("discount_percent");

            // 4. Warunek: jeśli rabat jest większy lub równy progowi, wyświetlamy grę
            if (rabat >= minimalnyRabat) {
                String nazwa = gra.getString("name");
                System.out.println(nazwa + ", rabat: " + rabat + "%");
            }
        }
    }
}