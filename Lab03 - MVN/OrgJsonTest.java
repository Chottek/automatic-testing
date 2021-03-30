import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrgJsonTest {

    @Test
    public void testCreatingJSONObject(){
        final JSONObject j = new JSONObject()
                        .put("NAME", "Martin")
                        .put("AGE", "22")
                        .put("CITY", "3CITY");
        assertEquals(3, j.keySet().size());
    }

    @Test
    public void testCreatingJSONObjectFromString(){
        final JSONObject j = new JSONObject(
                "{\"NAME\":\"Martin\"," +
                        "\"AGE\":\"22\"," +
                        "\"CITY\":\"3CITY\"}");
        assertEquals(3, j.keySet().size());
    }

    @Test
    public void testCreatingJSONObjectFromJavaObject(){
        final int id = 1;
        final String name = "Martin";
        final java.util.Date date = java.util.Date.from(java.time.LocalDateTime
                .now()
                .atZone(java.time.ZoneId.systemDefault())
                .toInstant());
        final boolean isFine = true;

        final JavaBeanObj javaBean = new JavaBeanObj()
                .withId(id)
                .withName(name)
                .withDate(date)
                .withFine(isFine);
        final JSONObject j = new JSONObject(javaBean);
        assertEquals(4, j.keySet().size());
    }

    @Test
    public void testThrowingExceptionOnEmptyArrSearch(){
        final JSONArray jarr = new JSONArray();
        jarr.put("Hello");
        jarr.put(3);

        final JSONObject j = new JSONObject()
                        .put("NAME", "Martin")
                        .put("AGE", "22")
                        .put("CITY", "3CITY");
        jarr.put(j);
        jarr.clear();
        assertThrows(JSONException.class, () -> jarr.getJSONObject(2).keySet());
    }

    @Test
    public void testCreatingJSONObjectFromMap(){
        java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put("NAME", "Martin");
        map.put("AGE", "22");
        map.put("CITY", "3CITY");
        JSONObject j = new JSONObject(map);
        assertFalse(j.isEmpty());
    }

    @Test
    public void checkKeysInCreatedObject(){
        String[] keys = {"Name", "Age", "City"};
        String[] values = {"Martin", "22", "3CITY"};

        JSONObject j = new JSONObject();

        for (int i = 0; i < keys.length; i++) {
            j.put(keys[i], values[i]);
        }

        j.remove(keys[0]);
        assertFalse(j.keySet().isEmpty() && j.keySet().contains(keys[0]));
    }





}
