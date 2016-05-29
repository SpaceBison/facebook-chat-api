package org.spacebison.facebookchatapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Polymporphic deserializer builder for {@link Gson}.
 * <p>
 * Create @{JsonDeserializer} instances to use with {@link GsonBuilder#registerTypeAdapter(Type, Object)}.
 * Deserializers built using this class use the specified property and its value to resolve the
 * target class that JSON should be deserialized to.
 */
public class GsonDeserializerBuilder <T> {
    private final HashMap<String, Class<? extends T>> mTypeMap = new HashMap<>();
    private final Gson mGson = new Gson();
    private final String mTypeProperty;
    private Class<T> mBaseClass;

    /**
     * Constructs the builder.
     *
     * @param typeProperty Name of the property which values will be used to resolve target class
     * @param baseClass The class that target classes extend
     */
    public GsonDeserializerBuilder(String typeProperty, Class<T> baseClass) {
        mTypeProperty = typeProperty;
        mBaseClass = baseClass;
    }

    /**
     * Adds a property value -> target class mapping.
     *
     * @param typeString Value of typeProperty
     * @param classOfT Target class
     * @return
     */
    public GsonDeserializerBuilder<T> addType(String typeString, Class<? extends T> classOfT) {
        mTypeMap.put(typeString, classOfT);
        return this;
    }

    /**
     * Builds the {@link JsonDeserializer}.
     *
     * @return {@link JsonDeserializer} instance
     */
    public JsonDeserializer<T> buildDeserializer() {
        return new Deserializer(new HashMap<>(mTypeMap));
    }

    private class Deserializer implements JsonDeserializer<T> {
        private final Map<String, Class<? extends T>> mTypeMap;

        private Deserializer(Map<String, Class<? extends T>> typeMap) {
            mTypeMap = typeMap;
        }

        @Override
        public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (!json.isJsonObject()) {
                throw new JsonParseException("Not an object");
            }

            JsonObject object = json.getAsJsonObject();

            if (!object.has(mTypeProperty)) {
                throw new JsonParseException("Object does not contain type property: " + mTypeProperty);
            }

            JsonElement typeElement = object.get(mTypeProperty);

            if (!typeElement.isJsonPrimitive()) {
                throw new JsonParseException("Property " + mTypeProperty + " is not a primitive");
            }

            JsonPrimitive typePrimitive = typeElement.getAsJsonPrimitive();

            if (!typePrimitive.isString()) {
                throw new JsonParseException("Property " + mTypeProperty + " is not a string");
            }

            String type = typePrimitive.getAsString();

            if (!mTypeMap.containsKey(type)) {
                return mGson.fromJson(json, mBaseClass);
            }

            Class<? extends T> tClass = mTypeMap.get(type);

            return context.deserialize(json, tClass);
        }
    }
}