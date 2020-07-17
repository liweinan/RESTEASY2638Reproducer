package io.weli.resteasy2638;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class ParameterConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        System.err.println("TYPE: " + rawType);
        if (rawType == IMetaData.class) {
            return (ParamConverter) new ParamConverter<MetaData>() {

                @Override
                public MetaData fromString(String value) {
                    var rv = new MetaData();
                    rv.metaInfo = "barfoo";
                    return rv;
                }

                @Override
                public String toString(MetaData value) {
                    return "{ }";
                }

            };
        }
        return null;
    }

}