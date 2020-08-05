package io.weli.resteasy2638;

import org.eclipse.yasson.internal.JsonBindingBuilder;
import org.glassfish.json.JsonProviderImpl;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;

// https://stackoverflow.com/questions/32478159/jax-rs-contextresolvert-undestanding
@Provider
@Consumes({"application/json", "application/*+json", "text/json"})
public class MyJsonbProvider implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class<?> t) {

        Class c = null;

        if (t.isAnnotationPresent(DeserializeAs.class)) {
            DeserializeAs info = t.getAnnotation(DeserializeAs.class);
            c = info.value();

        }

        if (c != null) {
            Jsonb jsonbObj;
            JsonProviderImpl jProviderImpl = new JsonProviderImpl();
            JsonBindingBuilder jbBuilder = new JsonBindingBuilder();
            jsonbObj = jbBuilder.withProvider(jProviderImpl).build();
            return jsonbObj;
        } else {

            return null;
        }
    }
}
