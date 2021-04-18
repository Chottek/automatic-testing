package pl.fox;

import org.junit.jupiter.api.Test;
import pl.fox.lab5.APIBuilder;
import pl.fox.lab5.APIFetcher;

import static org.junit.jupiter.api.Assertions.*;

public class APIFetcherTest {


    //Site: ip-api.com/json/

    @Test
    public void testIPObjectGetting(){
        final String GLOBAL_IP =
                APIFetcher.fetchAsString(new APIBuilder().withHTTP().withSite("checkip.amazonaws.com").getFinalURL());
        final APIBuilder IP_API = new APIBuilder()
                .withHTTP()
                .withSite("ip-api.com")
                .withSubsite("json")
                .withCleanParam(GLOBAL_IP);
        final var obj = APIFetcher.fetchFrom(IP_API.getFinalURL(), "GET");

        assertNotNull(obj);
    }

    @Test
    public void testIPAPIFetching(){
        final String GLOBAL_IP =
                APIFetcher.fetchAsString(new APIBuilder().withHTTP().withSite("checkip.amazonaws.com").getFinalURL());

        final APIBuilder IP_API = new APIBuilder()
                .withHTTP()
                .withSite("ip-api.com")
                .withSubsite("json")
                .withCleanParam(GLOBAL_IP);
        final var obj = APIFetcher.fetchFrom(IP_API.getFinalURL(), "GET");

        assertEquals("success", obj.get("status"));
    }

    @Test
    public void testIPAPICountry(){
        final String GLOBAL_IP =
                APIFetcher.fetchAsString(new APIBuilder().withHTTP().withSite("checkip.amazonaws.com").getFinalURL());

        final APIBuilder IP_API = new APIBuilder()
                .withHTTP()
                .withSite("ip-api.com")
                .withSubsite("json")
                .withCleanParam(GLOBAL_IP);
        final var obj = APIFetcher.fetchFrom(IP_API.getFinalURL(), "GET");

        assertEquals("Poland", obj.get("country"));
    }

    @Test
    public void testIPAPITimezone(){
        final String GLOBAL_IP =
                APIFetcher.fetchAsString(new APIBuilder().withHTTP().withSite("checkip.amazonaws.com").getFinalURL());

        final APIBuilder IP_API = new APIBuilder()
                .withHTTP()
                .withSite("ip-api.com")
                .withSubsite("json")
                .withCleanParam(GLOBAL_IP);
        final var obj = APIFetcher.fetchFrom(IP_API.getFinalURL(), "GET");
        assertEquals("Europe/Warsaw", obj.get("timezone"));
    }


    //Site: api.guildwars2.com

    @Test
    public void testGW2ObjectGetting(){
        final APIBuilder GW_API = new APIBuilder()
                .withHTTPS()
                .withSite("api.guildwars2.com")
                .withSubsite("v2/account")
                .withParam("access_token", "D713D1F6-CB92-3A46-8815-3CBD05A8E3143D3B5BE7-60C1-4C85-BE6D-F1D03D6E783D");

        final var obj = APIFetcher.fetchFrom(GW_API.getFinalURL(), "GET");

        assertNotNull(obj);
    }

    @Test
    public void testGW2Account(){
        final APIBuilder GW_API = new APIBuilder()
                .withHTTPS()
                .withSite("api.guildwars2.com")
                .withSubsite("v2/account")
                .withParam("access_token", "D713D1F6-CB92-3A46-8815-3CBD05A8E3143D3B5BE7-60C1-4C85-BE6D-F1D03D6E783D");

        final var obj = APIFetcher.fetchFrom(GW_API.getFinalURL(), "GET");

        assertTrue(obj.keySet().size() == 8);
        assertEquals("Chotti.4839", obj.get("name"));
    }

    @Test
    public void testGW2Characters(){
        final APIBuilder GW_API = new APIBuilder()
                .withHTTPS()
                .withSite("api.guildwars2.com")
                .withSubsite("v2/characters")
                .withParam("access_token", "D713D1F6-CB92-3A46-8815-3CBD05A8E3143D3B5BE7-60C1-4C85-BE6D-F1D03D6E783D");

        final var obj = APIFetcher.fetchAsString(GW_API.getFinalURL());
        assertFalse(!(obj.contains("Quezz")));
    }

    @Test
    public void testGW2Wallet(){
        final APIBuilder GW_API = new APIBuilder()
                .withHTTPS()
                .withSite("api.guildwars2.com")
                .withSubsite("v2/account/").withSubsite("wallet")
                .withParam("access_token", "D713D1F6-CB92-3A46-8815-3CBD05A8E3143D3B5BE7-60C1-4C85-BE6D-F1D03D6E783D");

        final var walletArr = new org.json.JSONArray(APIFetcher.fetchAsString(GW_API.getFinalURL()));
        assertTrue(walletArr.length() == 14
                && walletArr.getJSONObject(0).get("value").equals(Integer.parseInt("10024166")));
    }

    //Site: TheCocktaildb.com

    @Test
    public void testCocktailObjectGetting(){
        final APIBuilder CDB_API = new APIBuilder()
                .withHTTPS()
                .withSite("thecocktaildb.com").withSubsite("api/")
                .withSubsite("json/").withSubsite("v1/1/").withSubsite("search.php").withParam("s", "Whiskey_Sour");

        final var obj = APIFetcher.fetchFrom(CDB_API.getFinalURL(), "GET");
        assertNotNull(obj);
    }

    @Test
    public void testCocktailDBDrinkGetting(){
        final APIBuilder CDB_API = new APIBuilder()
                .withHTTPS()
                .withSite("thecocktaildb.com").withSubsite("api/")
                .withSubsite("json/").withSubsite("v1/1/").withSubsite("search.php").withParam("s", "Whiskey_Sour");

    //    www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka

        final var obj = APIFetcher.fetchAsString(CDB_API.getFinalURL());
        assertFalse(obj.equals(APIFetcher.EMPTY_RETURN));
    }

    @Test
    public void testCocktailDBDCategories(){
        final APIBuilder CDB_API = new APIBuilder()
                .withHTTPS()
                .withSite("thecocktaildb.com").withSubsite("api/")
                .withSubsite("json/").withSubsite("v1/1/").withSubsite("list.php").withParam("c", "list");

        //    www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka

        final var obj = APIFetcher.fetchFrom(CDB_API.getFinalURL(), "GET");
        assertEquals(11, obj.getJSONArray("drinks").length());
    }


}
