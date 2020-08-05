package io.weli.resteasy2638;

import org.jboss.resteasy.plugins.providers.jsonb.CustomizedJsonbProvider;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

// https://stackoverflow.com/questions/32478159/jax-rs-contextresolvert-undestanding
@Provider
@Consumes({"application/json", "application/*+json", "text/json"})
public class MyJsonbProvider implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class<?> aClass) {
        return JsonbBuilder.create();
    }
}
