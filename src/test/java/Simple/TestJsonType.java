package Simple;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestJsonType {

    @Test
    public void testJsonFieldTypes() {
        try {
            // Чтение содержимого JSON файла
            String jsonString = new String(Files.readAllBytes(Paths.get("response_339.json")));
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONObject cart = data.getJSONObject("cart");

            // Проверка типов данных значений полей корзины
            checkFieldType(cart, "id", Integer.class);
            checkFieldType(cart, "number", String.class);
            checkFieldType(cart, "client_type_id", Integer.class);
            checkFieldType(cart, "shop_id", Integer.class);
            checkFieldType(cart, "shop_extend_id", Integer.class);
            checkFieldType(cart, "shops_available", JSONArray.class);
            checkFieldType(cart, "shops_recommend_available", JSONArray.class);
            checkFieldType(cart, "update_date", String.class);
            checkFieldType(cart, "expiration_date", String.class);
            checkFieldType(cart, "pay_way_id", Integer.class);
            checkFieldType(cart, "service_id", Integer.class);
            checkFieldType(cart, "service_type", Integer.class);
            checkFieldType(cart, "is_pickup", Boolean.class);
            checkFieldType(cart, "delivery_time", JSONObject.class);
            checkFieldType(cart, "delivery_type_id", Integer.class);
            checkFieldType(cart, "delivery_price", Integer.class);
            checkFieldType(cart, "button", Integer.class);
            checkFieldType(cart, "packaging_id", Object.class);
            checkFieldType(cart, "lp", JSONArray.class);
            checkFieldType(cart, "prices", JSONObject.class);
            checkFieldType(cart, "delivery", JSONObject.class);
            checkFieldType(cart, "products", JSONArray.class);
            checkFieldType(cart, "combo", JSONArray.class);
            checkFieldType(cart, "cutlery", Integer.class);
            checkFieldType(cart, "cart_weight", Double.class);
            checkFieldType(cart, "is_not_need_slots", Boolean.class);
            checkFieldType(cart, "first_snow", JSONObject.class);
            checkFieldType(cart, "toggle_and_texts", JSONObject.class);

            // Проверка типов данных значений полей вложенных объектов
            if (cart.has("shops_available")) {
                JSONArray shopsAvailable = cart.getJSONArray("shops_available");
                for (int i = 0; i < shopsAvailable.length(); i++) {
                    JSONObject shop = shopsAvailable.getJSONObject(i);
                    checkFieldType(shop, "shop_id", Integer.class);
                    checkFieldType(shop, "shop_extend_id", Integer.class);
                }
            }

            if (cart.has("shops_recommend_available")) {
                JSONArray shopsRecommendAvailable = cart.getJSONArray("shops_recommend_available");
                for (int i = 0; i < shopsRecommendAvailable.length(); i++) {
                    JSONObject shop = shopsRecommendAvailable.getJSONObject(i);
                    checkFieldType(shop, "shop_id", Integer.class);
                    checkFieldType(shop, "service_id", Integer.class);
                    checkFieldType(shop, "delivery_time", JSONObject.class);
                }
            }

            if (cart.has("lp")) {
                JSONArray lp = cart.getJSONArray("lp");
                for (int i = 0; i < lp.length(); i++) {
                    JSONObject lpItem = lp.getJSONObject(i);
                    checkFieldType(lpItem, "id", Integer.class);
                    checkFieldType(lpItem, "name", String.class);
                    checkFieldType(lpItem, "remains", Double.class);
                    checkFieldType(lpItem, "photo", String.class);
                    checkFieldType(lpItem, "unit", String.class);
                }
            }

            if (cart.has("products")) {
                JSONArray products = cart.getJSONArray("products");
                for (int i = 0; i < products.length(); i++) {
                    JSONObject product = products.getJSONObject(i);
                    checkFieldType(product, "id", String.class);
                    checkFieldType(product, "product_id", Integer.class);
                    checkFieldType(product, "is_green_price", Boolean.class);
                    checkFieldType(product, "quantity", Integer.class);
                    checkFieldType(product, "amount", Integer.class);
                    checkFieldType(product, "cutlery_product_type", Integer.class);
                    checkFieldType(product, "exception_text", String.class);
                    checkFieldType(product, "remains", JSONArray.class);

                    if (product.has("prices")) {
                        JSONObject prices = product.getJSONObject("prices");
                        checkFieldType(prices, "price_discount", Integer.class);
                        checkFieldType(prices, "price_retail", Integer.class);
                        checkFieldType(prices, "discount", Integer.class);
                        checkFieldType(prices, "discount_percent", Integer.class);
                        checkFieldType(prices, "sum_discount", Integer.class);
                        checkFieldType(prices, "sum_retail", Integer.class);
                        checkFieldType(prices, "sum_loyal", Integer.class);
                        checkFieldType(prices, "price_type", Integer.class);
                        checkFieldType(prices, "privilege_id", Integer.class);
                        checkFieldType(prices, "privilege_type", Integer.class);
                        checkFieldType(prices, "privilege_used", Integer.class);
                        checkFieldType(prices, "result_code", Integer.class);
                    }

                    if (product.has("properties")) {
                        JSONObject properties = product.getJSONObject("properties");
                        checkFieldType(properties, "name", String.class);
                        checkFieldType(properties, "unit", String.class);
                        checkFieldType(properties, "photo", String.class);
                        checkFieldType(properties, "weight_max", Integer.class);
                        checkFieldType(properties, "weight_min", Integer.class);
                        checkFieldType(properties, "weight_avg", Integer.class);
                        checkFieldType(properties, "is_loose", Boolean.class);
                        checkFieldType(properties, "weight_step", Integer.class);
                        checkFieldType(properties, "is_freeze", Boolean.class);
                        checkFieldType(properties, "is_red_price", Boolean.class);
                        checkFieldType(properties, "is_new_price", Boolean.class);
                        checkFieldType(properties, "is_alcohol", Boolean.class);
                        checkFieldType(properties, "weight", Integer.class);
                        checkFieldType(properties, "has_no_bonus_pay", Boolean.class);
                        checkFieldType(properties, "is_perishable", Boolean.class);
                    }

                    if (product.has("resources")) {
                        JSONObject resources = product.getJSONObject("resources");
                        checkFieldType(resources, "is_group_price", Boolean.class);
                        checkFieldType(resources, "title_prefix", String.class);
                        checkFieldType(resources, "product_separator", String.class);
                        checkFieldType(resources, "color", String.class);
                        checkFieldType(resources, "price_text_color", String.class);
                        checkFieldType(resources, "is_show_both", Boolean.class);
                        checkFieldType(resources, "text", String.class);
                        checkFieldType(resources, "desc_text_color", String.class);

                        if (resources.has("icon")) {
                            JSONObject icon = resources.getJSONObject("icon");
                            checkFieldType(icon, "icon_basic", String.class);
                            checkFieldType(icon, "icon_pers", String.class);
                        }
                    }
                }
            }

            if (cart.has("combo")) {
                JSONArray combo = cart.getJSONArray("combo");
                for (int i = 0; i < combo.length(); i++) {
                    JSONObject comboItem = combo.getJSONObject(i);
                    checkFieldType(comboItem, "id", Integer.class);
                    checkFieldType(comboItem, "quantity", Integer.class);
                    checkFieldType(comboItem, "remains_quantity", Integer.class);
                    checkFieldType(comboItem, "unit", String.class);

                    if (comboItem.has("components")) {
                        JSONArray components = comboItem.getJSONArray("components");
                        for (int j = 0; j < components.length(); j++) {
                            JSONObject component = components.getJSONObject(j);
                            checkFieldType(component, "id", Integer.class);
                            checkFieldType(component, "quantity", Integer.class);
                            checkFieldType(component, "photo", String.class);
                            checkFieldType(component, "name", String.class);
                        }
                    }

                    if (comboItem.has("prices")) {
                        JSONObject prices = comboItem.getJSONObject("prices");
                        checkFieldType(prices, "price_discount", Integer.class);
                        checkFieldType(prices, "price_retail", Integer.class);
                        checkFieldType(prices, "discount", Integer.class);
                        checkFieldType(prices, "discount_percent", Integer.class);
                        checkFieldType(prices, "sum_discount", Integer.class);
                        checkFieldType(prices, "sum_retail", Integer.class);
                        checkFieldType(prices, "sum_loyal", Integer.class);
                        checkFieldType(prices, "price_type", Integer.class);
                        checkFieldType(prices, "privilege_id", Integer.class);
                        checkFieldType(prices, "privilege_type", Integer.class);
                        checkFieldType(prices, "privilege_used", Integer.class);
                        checkFieldType(prices, "result_code", Integer.class);
                    }

                    if (comboItem.has("resources")) {
                        JSONObject resources = comboItem.getJSONObject("resources");
                        checkFieldType(resources, "is_group_price", Boolean.class);
                        checkFieldType(resources, "title_prefix", String.class);
                        checkFieldType(resources, "product_separator", String.class);
                        checkFieldType(resources, "color", String.class);
                        checkFieldType(resources, "price_text_color", String.class);
                        checkFieldType(resources, "is_show_both", Boolean.class);
                        checkFieldType(resources, "text", String.class);
                        checkFieldType(resources, "desc_text_color", String.class);

                        if (resources.has("icon")) {
                            JSONObject icon = resources.getJSONObject("icon");
                            checkFieldType(icon, "icon_basic", String.class);
                            checkFieldType(icon, "icon_pers", String.class);
                        }
                    }
                }
            }

            if (cart.has("first_snow")) {
                JSONObject firstSnow = cart.getJSONObject("first_snow");
                checkFieldType(firstSnow, "is_high_demand", Boolean.class);
                checkFieldType(firstSnow, "sum_min", Integer.class);
                checkFieldType(firstSnow, "sum_min_min", Integer.class);
                checkFieldType(firstSnow, "sum_min_max", Integer.class);
            }

            if (cart.has("toggle_and_texts")) {
                JSONObject toggleAndTexts = cart.getJSONObject("toggle_and_texts");
                checkFieldType(toggleAndTexts, "service_type_icon", String.class);
                checkFieldType(toggleAndTexts, "service_icon", String.class);
                checkFieldType(toggleAndTexts, "during_text", String.class);
                checkFieldType(toggleAndTexts, "slots_text", String.class);
                checkFieldType(toggleAndTexts, "delivery_text", String.class);
                checkFieldType(toggleAndTexts, "express_toggle", Boolean.class);
                checkFieldType(toggleAndTexts, "communication", Integer.class);
            }

            // Проверка типов данных значений полей вложенных объектов

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для проверки типа данных поля и вывода сообщения в консоль, если тип не соответствует ожидаемому
    private void checkFieldType(JSONObject object, String field, Class<?> expectedType) {
        if (!object.has(field)) {
            System.out.println("Поле \"" + field + "\" отсутствует в JSON объекте");
            return;
        }
        Object value = object.get(field);
        if (!expectedType.isInstance(value)) {
            System.out.println("Поле \"" + field + "\": Ожидался тип " + expectedType.getSimpleName() + ", но получен " + value.getClass().getSimpleName());
        }
    }
}